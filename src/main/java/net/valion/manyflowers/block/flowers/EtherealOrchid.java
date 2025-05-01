package net.valion.manyflowers.block.flowers;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Dismounting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.CollisionView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.valion.manyflowers.registry.ItemsRegistry;
import net.valion.manyflowers.registry.SoundsRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.ToIntFunction;

public class EtherealOrchid extends BaseFlower {
    public static final MapCodec<EtherealOrchid> CODEC = createCodec(EtherealOrchid::new);
    public static final IntProperty CHARGES = Properties.CHARGES;
    private static final ImmutableList<Vec3i> VALID_HORIZONTAL_SPAWN_OFFSETS = ImmutableList.of(
            new Vec3i(0, 0, -1),
            new Vec3i(-1, 0, 0),
            new Vec3i(0, 0, 1),
            new Vec3i(1, 0, 0),
            new Vec3i(-1, 0, -1),
            new Vec3i(1, 0, -1),
            new Vec3i(-1, 0, 1),
            new Vec3i(1, 0, 1)
    );
    private static final ImmutableList<Vec3i> VALID_SPAWN_OFFSETS = new ImmutableList.Builder<Vec3i>()
            .addAll(VALID_HORIZONTAL_SPAWN_OFFSETS)
            .addAll(VALID_HORIZONTAL_SPAWN_OFFSETS.stream().map(Vec3i::down).iterator())
            .addAll(VALID_HORIZONTAL_SPAWN_OFFSETS.stream().map(Vec3i::up).iterator())
            .add(new Vec3i(0, 1, 0))
            .build();

    public EtherealOrchid(Settings settings) {
        super(settings.luminance(getLightLevel(15)));
        this.setDefaultState(this.stateManager.getDefaultState().with(CHARGES, 3));
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUseWithItem(
            ItemStack stack,
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult hit
    ) {
        if (isChargeItem(stack) && canCharge(state)) {
            charge(player, world, pos, state);
            stack.decrementUnlessCreative(1, player);
            return ActionResult.SUCCESS;
        } else {
            return hand == Hand.MAIN_HAND && isChargeItem(player.getStackInHand(Hand.OFF_HAND)) && canCharge(state)
                    ? ActionResult.PASS
                    : ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
        }
    }

    private static boolean isChargeItem(ItemStack stack) {
        return stack.isOf(ItemsRegistry.INSTANCE.getFLORAL_MEAL());
    }

    private static boolean canCharge(BlockState state) {
        return state.get(CHARGES) < 3;
    }

    public static void charge(@Nullable Entity charger, World world, BlockPos pos, BlockState state) {
        BlockState blockState = state.with(CHARGES, state.get(CHARGES) + 1);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(charger, blockState));
        world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }

    public static ToIntFunction<BlockState> getLightLevel(int maxLevel) {
        return state -> MathHelper.floor(state.get(CHARGES) / 4.0F * maxLevel);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGES);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) placer;
            if (serverPlayerEntity.getSpawnPointDimension() != world.getRegistryKey() || !pos.equals(serverPlayerEntity.getSpawnPointPosition())) {
                serverPlayerEntity.setSpawnPoint(world.getRegistryKey(), pos, 0.0F, false, true);
                world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundsRegistry.INSTANCE.getETHEREAL_ORCHID_PLACED_SOUND(), SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isIn(BlockTags.BASE_STONE_OVERWORLD) ||
                floor.isIn(BlockTags.BASE_STONE_NETHER) || floor.isOf(Blocks.END_STONE);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(CHARGES) != 0) {
            if (random.nextInt(100) == 0) {
                world.playSoundAtBlockCenter(pos, SoundsRegistry.INSTANCE.getETHEREAL_ORCHID_AMBIENT(), SoundCategory.BLOCKS, 1.0F, 1.0F, false);
            }

            double d = pos.getX() + 0.5 + (0.5 - random.nextDouble());
            double e = pos.getY() + 1.0;
            double f = pos.getZ() + 0.5 + (0.5 - random.nextDouble());
            double g = random.nextFloat() * 0.04;
            world.addParticle(ParticleTypes.REVERSE_PORTAL, d, e, f, 0.0, g, 0.0);
        }
    }

    public static Optional<Vec3d> findRespawnPosition(EntityType<?> entity, CollisionView world, BlockPos pos) {
        Optional<Vec3d> optional = findRespawnPosition(entity, world, pos, true);
        return optional.isPresent() ? optional : findRespawnPosition(entity, world, pos, false);
    }

    private static Optional<Vec3d> findRespawnPosition(EntityType<?> entity, CollisionView world, BlockPos pos, boolean ignoreInvalidPos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (Vec3i vec3i : VALID_SPAWN_OFFSETS) {
            mutable.set(pos).move(vec3i);
            Vec3d vec3d = Dismounting.findRespawnPos(entity, world, mutable, ignoreInvalidPos);
            if (vec3d != null) {
                return Optional.of(vec3d);
            }
        }

        return Optional.empty();
    }
}
