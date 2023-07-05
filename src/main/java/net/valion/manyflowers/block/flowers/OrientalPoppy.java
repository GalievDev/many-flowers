package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import static net.valion.manyflowers.ManyFlowers.CONFIG;

public class OrientalPoppy extends FlowerBlock {
    public OrientalPoppy(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL && CONFIG.explosion_oriental_poppy) {
            if (entity instanceof LivingEntity) {
                world.createExplosion(entity, pos.getX(), pos.getY(), pos.getZ(), 1F, World.ExplosionSourceType.TNT);
                entity.damage(world.getDamageSources().generic(), 3);
            }
        }
    }
}
