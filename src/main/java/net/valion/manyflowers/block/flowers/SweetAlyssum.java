package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.particle.FlowerParticles;

import java.util.Random;

public class SweetAlyssum extends FlowerBlock {
    public SweetAlyssum(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        float chance = 0.35f;
        if(chance < random.nextFloat()) {
            world.addParticle(FlowerParticles.SWEET_ALYSSUM_PARTICLES, pos.getX() + 0.5D,
                    pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    0.2d,0.1d,0.3d);
        }
        super.randomDisplayTick(state, world, pos, random);
    }
}
