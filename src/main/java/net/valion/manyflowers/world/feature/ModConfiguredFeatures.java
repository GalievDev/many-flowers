package net.valion.manyflowers.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.OreFlowers;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ALSTROEMERIA_FLOWER = registerKey("alstroemeria_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA_FLOWER = registerKey("hydrangea_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MARIGOLD_FLOWER = registerKey("marigold_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWEET_ALYSSUM = registerKey("sweet_alyssum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HEMLOCK = registerKey("hemlock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OENOTHERA = registerKey("oenothera");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GAILLARDIA = registerKey("gaillardia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORIENTAL_POPPY = registerKey("oriental_poppy");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WORLDS_ROOT = registerKey("worlds_root");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VELVETS = registerKey("velvets");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHRYSANTHEMUM = registerKey("chrysanthemum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAISIES = registerKey("daisies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_ASTERS = registerKey("autumn_asters");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ZINNIA = registerKey("zinnia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_CROCUS = registerKey("autumn_crocus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JACK_FLOWER = registerKey("jack_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_FLOWER = registerKey("diamond_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_FLOWER = registerKey("gold_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_FLOWER = registerKey("iron_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMERALD_FLOWER = registerKey("emerald_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COPPER_FLOWER = registerKey("copper_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_FLOWER = registerKey("coal_flower");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, ALSTROEMERIA_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                36, 5, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ALSTROEMERIA_FLOWER)))
        ));

        register(context, HYDRANGEA_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                34, 3, 6, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.HYDRANGEA_FLOWER)))
        ));

        register(context, MARIGOLD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                37, 3, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.MARIGOLD_FLOWER)))
        ));

        register(context, SWEET_ALYSSUM, Feature.FLOWER, new RandomPatchFeatureConfig(
                12, 1, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.SWEET_ALYSSUM)))
        ));

        register(context, HEMLOCK, Feature.FLOWER, new RandomPatchFeatureConfig(
                42, 10, 10, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.HEMLOCK)))
        ));

        register(context, OENOTHERA, Feature.FLOWER, new RandomPatchFeatureConfig(
                52, 4, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.OENOTHERA)))
        ));

        register(context, GAILLARDIA, Feature.FLOWER, new RandomPatchFeatureConfig(
                52, 3, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.GAILLARDIA)))
        ));

        register(context, ORIENTAL_POPPY, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ORIENTAL_POPPY)))
        ));

        register(context, WORLDS_ROOT, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ROOT_OF_THE_WORLDS)))
        ));

        register(context, VELVETS, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.VELVETS)));

        register(context, CHRYSANTHEMUM, Feature.FLOWER, new RandomPatchFeatureConfig(
                52, 3, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.CHRYSANTHEMUM)))
        ));

        register(context, DAISIES, Feature.FLOWER, new RandomPatchFeatureConfig(
                64, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.DAISIES)))
        ));

        register(context, AUTUMN_ASTERS, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.AUTUMN_ASTERS)))
        ));

        register(context, ZINNIA, Feature.FLOWER, new RandomPatchFeatureConfig(
                34, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.ZINNIA)))
        ));

        register(context, AUTUMN_CROCUS, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.AUTUMN_CROCUS)))
        ));

        register(context, JACK_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Flowers.JACK_FLOWER)))
        ));

        register(context, DIAMOND_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.DIAMOND_FLOWER)))
        ));

        register(context, GOLD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.GOLD_FLOWER)))
        ));

        register(context, IRON_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.IRON_FLOWER)))
        ));

        register(context, EMERALD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.EMERALD_FLOWER)))
        ));

        register(context, COPPER_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.COPPER_FLOWER)))
        ));

        register(context, COAL_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(OreFlowers.COAL_FLOWER)))
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ManyFlowers.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
