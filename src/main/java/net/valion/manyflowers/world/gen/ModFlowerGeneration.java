package net.valion.manyflowers.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.valion.manyflowers.world.feature.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlower(){
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FOREST,
                        BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ALSTROEMERIA_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.MEADOW, BiomeKeys.TAIGA,
                        BiomeKeys.SNOWY_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.FROZEN_PEAKS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.HYDRANGEA_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FOREST,
                        BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_HILLS,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.MARIGOLD_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.DAISIES_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_MOUNTAIN
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ZINNIA
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FLOWER_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.COSMOS
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.PURPLE_CORNFLOWER
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FLOWER_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.PETUNIA
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE, BiomeKeys.FLOWER_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.GERANIUM
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.JUNGLE, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BEGONIA
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_MOUNTAIN
                ).and(
                        BiomeSelectors.tag(
                                BiomeTags.IS_TAIGA
                        )
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.SNAPDRAGON
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.RIVER, BiomeKeys.OCEAN
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ALYSSUM_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.NETHER_WASTES, BiomeKeys.SAVANNA,
                        BiomeKeys.SAVANNA_PLATEAU
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.GAILLARDIA_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FOREST,
                        BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_HILLS,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.POPPY_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.HEMLOCK_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.FOREST,
                        BiomeKeys.JUNGLE, BiomeKeys.SPARSE_JUNGLE,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.OENOTHERA_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.CHRYSANTHEMUM_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.DEEP_DARK
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.AUTUMN_CROCUS
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.SAVANNA
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BLACK_EYED_SUSAN
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.SWAMP, BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.COREOPSIS
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.FLOWER_FOREST, BiomeKeys.WINDSWEPT_HILLS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.DAHLIA
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.SAVANNA, BiomeKeys.DESERT
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.LAVENDER
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_NETHER
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.VELVETS_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.DARK_FOREST
                ),
                GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.AUTUMN_ASTERS
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.DEEP_DARK, BiomeKeys.DRIPSTONE_CAVES
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BONE_FLOWER
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS, BiomeKeys.SAVANNA
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.TRADE_FLOWER
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.COAL_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.SWAMP
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.COPPER_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.TAIGA
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.IRON_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.BADLANDS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.GOLD_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.DIAMOND_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.WINDSWEPT_HILLS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.EMERALD_FLOWER_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(
                        BiomeTags.IS_TAIGA
                ),
                GenerationStep.Feature.UNDERGROUND_DECORATION,
                ModPlacedFeatures.JACK_FLOWER
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.FOREST
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.WORLDS_ROOT_PLACED
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.PLAINS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.ETHEREAL_ORCHID
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.WINDSWEPT_FOREST, BiomeKeys.WINDSWEPT_HILLS
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.DREADPETAL
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(
                        BiomeKeys.SAVANNA_PLATEAU, BiomeKeys.SAVANNA
                ),
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BLINDBLOSSOM
        );
    }
}
