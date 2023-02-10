package net.valion.manyflowers.world.feature;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.OreFlowers;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class ModConfiguredFeatures {

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ALSTROEMERIA_FLOWER =
            ConfiguredFeatures.register("alstroemeria_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(36, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ALSTROEMERIA_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> HYDRANGEA_FLOWER =
            ConfiguredFeatures.register("hydrangea_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(34, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.HYDRANGEA_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> MARIGOLD_FLOWER =
            ConfiguredFeatures.register("marigold_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(37, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.MARIGOLD_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> SWEET_ALYSSUM =
            ConfiguredFeatures.register("sweet_alyssum", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.SWEET_ALYSSUM)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> HEMLOCK =
            ConfiguredFeatures.register("hemlock", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(35, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.HEMLOCK)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> OENOTHERA =
            ConfiguredFeatures.register("oenothera", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(35, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.OENOTHERA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> GAILLARDIA =
            ConfiguredFeatures.register("gaillardia", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(35, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.GAILLARDIA)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> ORIENTAL_POPPY =
            ConfiguredFeatures.register("oriental_poppy", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ORIENTAL_POPPY)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> WORLDS_ROOT =
            ConfiguredFeatures.register("root_of_the_worlds", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ROOT_OF_THE_WORLDS)))));

    ///Ore Flowers///
    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> DIAMOND_FLOWER =
            ConfiguredFeatures.register("diamond_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.DIAMOND_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> COAL_FLOWER =
            ConfiguredFeatures.register("coal_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.COAL_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> IRON_FLOWER =
            ConfiguredFeatures.register("iron_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.IRON_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> GOLD_FLOWER =
            ConfiguredFeatures.register("gold_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.GOLD_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> EMERALD_FLOWER =
            ConfiguredFeatures.register("emerald_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.EMERALD_FLOWER)))));

    public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> COPPER_FLOWER =
            ConfiguredFeatures.register("copper_flower", Feature.FLOWER,
                    ConfiguredFeatures.createRandomPatchFeatureConfig(1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                            new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.COPPER_FLOWER)))));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + MOD_ID);
    }
}
