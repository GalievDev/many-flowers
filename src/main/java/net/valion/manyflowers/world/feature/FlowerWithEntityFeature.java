package net.valion.manyflowers.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.valion.manyflowers.block.flowers.FlowerWithEntity;

public class FlowerWithEntityFeature extends Feature<RandomPatchFeatureConfig> {

    public FlowerWithEntityFeature(Codec<RandomPatchFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<RandomPatchFeatureConfig> context) {
        RandomPatchFeatureConfig randomPatchFeatureConfig = context.getConfig();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        int i = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int j = randomPatchFeatureConfig.xzSpread() + 1;
        int k = randomPatchFeatureConfig.ySpread() + 1;

        for (int l = 0; l < randomPatchFeatureConfig.tries(); l++) {
            mutable.set(blockPos, random.nextInt(j) - random.nextInt(j), random.nextInt(k) - random.nextInt(k), random.nextInt(j) - random.nextInt(j));
            if (randomPatchFeatureConfig.feature().value().generateUnregistered(structureWorldAccess, context.getGenerator(), random, mutable)) {
                var blockState = structureWorldAccess.getBlockState(mutable);
                if (blockState.getBlock() instanceof FlowerWithEntity flower) {
                    flower.getEntityType().spawn(structureWorldAccess.toServerWorld(), mutable, SpawnReason.CHUNK_GENERATION);
                }
                i++;
            }
        }

        return i > 0;
    }
}
