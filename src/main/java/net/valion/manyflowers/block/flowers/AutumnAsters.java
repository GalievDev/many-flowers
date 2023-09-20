package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.flowers.entity.AutumnAstersEntity;
import net.valion.manyflowers.setup.BlockEntitiesReg;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

import static net.valion.manyflowers.block.flowers.entity.AutumnAstersEntity.ids;

public class AutumnAsters extends ExtendedFlower {
    public AutumnAsters(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity) {
            if (ids.size() < 10 && ((PlayerEntity) entity).getStackInHand(((PlayerEntity) entity).getActiveHand()).getItem() != Items.AIR) {
                var stack = new ItemStack(((PlayerEntity) entity).getStackInHand(((PlayerEntity) entity).getActiveHand()).getItem(), new Random().nextInt(3));
                ids.put(stack.getItem().toString(), stack.getCount());
                ((PlayerEntity) entity).getInventory().removeStack(((PlayerEntity) entity).getInventory().selectedSlot, stack.getCount());
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && !ids.isEmpty()) {
            for (int i = 0; i < ids.size(); i++) {
                var id = ids.keySet().stream().toList().get(i);
                var count = ids.values().stream().toList().get(i);

                var stack = new ItemStack(Registries.ITEM.get(new Identifier(id)), count);
                ManyFlowers.LOGGER.info("stack: " + id);
                var entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                world.spawnEntity(entity);
            }
/*            ids.forEach((id, count) -> {
                player.sendMessage(Text.of("dofskdfsmdklfskoskdfoiskokdsfo"));
                var stack = new ItemStack(Registries.ITEM.get(new Identifier(id)), count);
                var entity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                world.spawnEntity(entity);
            });*/
            ids.clear();
        }
        return ActionResult.PASS;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT);
    }

    //Block entity
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AutumnAstersEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntitiesReg.AUTUMN_ASTERS_ENTITY, AutumnAstersEntity::tick);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
