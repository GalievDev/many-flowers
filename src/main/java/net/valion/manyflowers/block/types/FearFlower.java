package net.valion.manyflowers.block.types;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.valion.manyflowers.setup.Flowers;

import java.util.Optional;

public class FearFlower extends FlowerBlock {

    public FearFlower(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }
}
