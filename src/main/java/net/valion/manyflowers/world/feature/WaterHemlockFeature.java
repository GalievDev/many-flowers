package net.valion.manyflowers.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.valion.manyflowers.registry.BlocksRegistry;

public class WaterHemlockFeature extends Feature<ProbabilityConfig> {

    public WaterHemlockFeature(Codec<ProbabilityConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context) {
        boolean isPlaced = false;
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        ProbabilityConfig probabilityConfig = context.getConfig();
        int i = random.nextInt(8) - random.nextInt(8);
        int j = random.nextInt(8) - random.nextInt(8);
        int k = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX() + i, blockPos.getZ() + j);
        BlockPos placePos = new BlockPos(blockPos.getX() + i, k, blockPos.getZ() + j);
        if (structureWorldAccess.getBlockState(placePos).isOf(Blocks.WATER)) {
            boolean probability = random.nextDouble() < probabilityConfig.probability;
            BlockState blockState = BlocksRegistry.INSTANCE.getWATER_HEMLOCK().getDefaultState();
            if (blockState.canPlaceAt(structureWorldAccess, placePos)) {
                if (probability) {
                    structureWorldAccess.setBlockState(placePos, blockState, Block.NOTIFY_LISTENERS);
                    isPlaced = true;
                }
            }
        }

        return isPlaced;
    }
}
