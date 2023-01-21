package net.valion.manyflowers.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.valion.manyflowers.world.feature.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ALSTROEMERIA_FLOWER.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.ICE_SPIKES, BiomeKeys.TAIGA, BiomeKeys.FROZEN_PEAKS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HYDRANGEA_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.WINDSWEPT_HILLS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MARIGOLD_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER, BiomeKeys.OCEAN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ALYSSUM_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HEMLOCK_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OENOTHERA_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.NETHER_WASTES, BiomeKeys.SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GAILLARDIA_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.WINDSWEPT_HILLS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.POPPY_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.TAIGA,
                        BiomeKeys.JUNGLE, BiomeKeys.SAVANNA, BiomeKeys.THE_END, BiomeKeys.FOREST, BiomeKeys.RIVER, BiomeKeys.SWAMP, BiomeKeys.NETHER_WASTES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WORLDS_ROOT.getKey().get());

        //Ore FLowers//
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DIAMOND_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COAL_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.IRON_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BADLANDS, BiomeKeys.SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GOLD_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WINDSWEPT_HILLS, BiomeKeys.FROZEN_PEAKS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.EMERALD_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.COPPER_PLACED.getKey().get());
    }
}
