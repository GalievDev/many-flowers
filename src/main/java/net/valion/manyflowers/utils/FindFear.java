package net.valion.manyflowers.utils;

import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Optional;

public interface FindFear {
    static boolean isWarpedFlowerAround(CreeperEntity creeper, BlockPos pos) {
        Optional<BlockPos> optional = creeper.getBrain().getOptionalMemory(MemoryModuleType.NEAREST_REPELLENT);
        return optional.isPresent() && ((BlockPos) optional.get()).isWithinDistance(pos, 8.0);
    }
}