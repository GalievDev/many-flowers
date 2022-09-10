package net.valion.manyflowers.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.valion.manyflowers.world.feature.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.JUNGLE),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ALSTROEMERIA_FLOWER.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.EXTREME_HILLS, Biome.Category.TAIGA, Biome.Category.ICY),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HYDRANGEA_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS, Biome.Category.FOREST, Biome.Category.MOUNTAIN),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MARIGOLD_PLACED.getKey().get());

        //Ore FLowers//
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.FOREST),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.DIAMOND_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.PLAINS),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.COAL_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.TAIGA),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.IRON_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.MESA, Biome.Category.SAVANNA),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.GOLD_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.EXTREME_HILLS, Biome.Category.MOUNTAIN),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.EMERALD_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.Category.SWAMP),
                GenerationStep.Feature.UNDERGROUND_DECORATION, ModPlacedFeatures.COPPER_PLACED.getKey().get());
    }
}
