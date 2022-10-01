package net.valion.manyflowers.block.flowers;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.valion.manyflowers.setup.Flowers;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Hemlock extends FlowerBlock {
    public Hemlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                if (!livingEntity.isInvulnerableTo(DamageSource.MAGIC)) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 50, 3));
                }
            }

        }
    }
}
