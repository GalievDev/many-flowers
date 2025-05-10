package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class BoneFlower extends BaseFlower {
    private final static MapCodec<BoneFlower> CODEC = createCodec(BoneFlower::new);

    public BoneFlower(Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        for (var targetPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            var targetState = world.getBlockState(targetPos);
            if (targetState.getBlock() instanceof CropBlock cropBlock && cropBlock.isFertilizable(world, targetPos, targetState)) {
                if (world.isDay() && cropBlock.canGrow(world, random, targetPos, targetState)) {
                    cropBlock.grow(world, random, targetPos, targetState);
                }
            }
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    public MapCodec<? extends BaseFlower> getCodec() {
        return CODEC;
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }
}
