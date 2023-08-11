package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

import static net.valion.manyflowers.ManyFlowers.blockChanges;
import static net.valion.manyflowers.setup.Flowers.VELVETS;

public class Velvets extends FlowerBlock {
    public Velvets(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        Random random = new Random();
        int duration = random.nextInt(2) + 3; // Случайное число от 3600 до 6000 (3-6 минут)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos nearbyPos = pos.add(dx, dy, dz);
                    if (world.getBlockState(nearbyPos).getBlock() != VELVETS) {
                        blockChanges.put(nearbyPos, duration);
                    }
                }
            }
        }
    }
}
