package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.valion.manyflowers.config.MFConfig;

public class Gaillardia extends BaseFlower {
    private final static MapCodec<Gaillardia> CODEC = createCodec(Gaillardia::new);

    public Gaillardia(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL && MFConfig.HANDLER.instance().damage_gaillardia) {
            if (!entity.isFireImmune() && entity instanceof LivingEntity) {
                boolean hasFrostWalker = false;
                var registryEntries = EnchantmentHelper.getEnchantments(((LivingEntity) entity)
                        .getEquippedStack(EquipmentSlot.FEET)).getEnchantmentEntries();

                for (Object2IntMap.Entry<RegistryEntry<Enchantment>> entry : registryEntries) {
                    var registryEntry = entry.getKey();
                    if (registryEntry.getKey().isPresent()) {
                        hasFrostWalker = registryEntry.getKey().get().isOf(Enchantments.FROST_WALKER.getRegistryRef());
                    }
                }

                if (!hasFrostWalker) {
                    entity.damage((ServerWorld) world, world.getDamageSources().inFire(), 1.0F);
                }
            }
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        float chance = 0.35f;
        if(chance < random.nextFloat()) {
            world.addParticleClient(ParticleTypes.LAVA, pos.getX() + 0.5D,
                    pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    0.2d,0.1d,0.3d);
        }
        super.randomDisplayTick(state, world, pos, random);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.CRIMSON_NYLIUM) || floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL) || super.canPlantOnTop(floor, world, pos);
    }
}
