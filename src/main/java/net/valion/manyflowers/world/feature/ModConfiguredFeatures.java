package net.valion.manyflowers.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.registry.BlocksRegistry;
import net.valion.manyflowers.registry.FeaturesRegistry;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ALSTROEMERIA_FLOWER = registerKey("alstroemeria_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA_FLOWER = registerKey("hydrangea_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MARIGOLD_FLOWER = registerKey("marigold_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAISIES = registerKey("daisies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ZINNIA = registerKey("zinnia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COSMOS = registerKey("cosmos");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_CORNFLOWER = registerKey("purple_cornflower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETUNIA = registerKey("petunia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GERANIUM = registerKey("geranium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BEGONIA = registerKey("begonia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNAPDRAGON = registerKey("snapdragon");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWEET_ALYSSUM = registerKey("sweet_alyssum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GAILLARDIA = registerKey("gaillardia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORIENTAL_POPPY = registerKey("oriental_poppy");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HEMLOCK = registerKey("hemlock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OENOTHERA = registerKey("oenothera");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CHRYSANTHEMUM = registerKey("chrysanthemum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_CROCUS = registerKey("autumn_crocus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACK_EYED_SUSAN = registerKey("black_eyed_susan");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COREOPSIS = registerKey("coreopsis");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAHLIA = registerKey("dahlia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAVENDER = registerKey("lavender");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VELVETS = registerKey("velvets");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_ASTERS = registerKey("autumn_asters");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BONE_FLOWER = registerKey("bone_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TRADE_FLOWER = registerKey("trade_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COAL_FLOWER = registerKey("coal_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COPPER_FLOWER = registerKey("copper_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> IRON_FLOWER = registerKey("iron_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GOLD_FLOWER = registerKey("gold_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIAMOND_FLOWER = registerKey("diamond_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMERALD_FLOWER = registerKey("emerald_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JACK_FLOWER = registerKey("jack_flower");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WORLDS_ROOT = registerKey("worlds_root");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ETHEREAL_ORCHID = registerKey("ethereal_orchid");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DREADPETAL = registerKey("dreadpetal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLINDBLOSSOM  = registerKey("blindblossom");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, ALSTROEMERIA_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                36, 5, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getALSTROEMERIA())))
        ));

        register(context, HYDRANGEA_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                34, 3, 6, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getHYDRANGEA())))
        ));

        register(context, MARIGOLD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                37, 3, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getMARIGOLD())))
        ));

        register(context, DAISIES, Feature.FLOWER, new RandomPatchFeatureConfig(
                64, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getDAISIES())))
        ));

        register(context, ZINNIA, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                34, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getZINNIA())))
        ));

        register(context, COSMOS, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                64, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getCOSMOS())))
        ));

        register(context, PURPLE_CORNFLOWER, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                54, 4, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getPURPLE_CORNFLOWER())))
        ));

        register(context, PETUNIA, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                50, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getPETUNIA())))
        ));

        register(context, GERANIUM, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                47, 5, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getGERANIUM())))
        ));

        register(context, BEGONIA, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                44, 7, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getBEGONIA())))
        ));

        register(context, SNAPDRAGON, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                40, 10, 9, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getSNAPDRAGON())))
        ));

        register(context, SWEET_ALYSSUM, Feature.FLOWER, new RandomPatchFeatureConfig(
                12, 1, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getSWEET_ALYSSUM())))
        ));

        register(context, GAILLARDIA, Feature.FLOWER, new RandomPatchFeatureConfig(
                52, 3, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getGAILLARDIA())))
        ));

        register(context, ORIENTAL_POPPY, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getORIENTAL_POPPY())))
        ));

        register(context, HEMLOCK, FeaturesRegistry.INSTANCE.getHEMLOCK_FEATURE(), new ProbabilityConfig(0.06F));

        register(context, OENOTHERA, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                52, 4, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getOENOTHERA())))
        ));

        register(context, CHRYSANTHEMUM, Feature.FLOWER, new RandomPatchFeatureConfig(
                52, 3, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getCHRYSANTHEMUM())))
        ));

        register(context, AUTUMN_CROCUS, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 3, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getAUTUMN_CROCUS())))
        ));

        register(context, BLACK_EYED_SUSAN, Feature.FLOWER, new RandomPatchFeatureConfig(
                20, 4, 8, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getBLACK_EYED_SUSAN())))
        ));

        register(context, COREOPSIS, Feature.FLOWER, new RandomPatchFeatureConfig(
                11, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getCOREOPSIS())))
        ));

        register(context, DAHLIA, Feature.FLOWER, new RandomPatchFeatureConfig(
                8, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getDAHLIA())))
        ));

        register(context, LAVENDER, Feature.FLOWER, new RandomPatchFeatureConfig(
                21, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getLAVENDER())))
        ));

        register(context, VELVETS, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                120, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getVELVETS())))));

        register(context, AUTUMN_ASTERS, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig(
                1, 2, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getAUTUMN_ASTERS())))
        ));

        register(context, BONE_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                6, 2, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getBONE_FLOWER())))
        ));

        register(context, TRADE_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                4, 2, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getTRADE_FLOWER())))
        ));

        register(context, COAL_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getCOAL_FLOWER())))
        ));

        register(context, COPPER_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getCOPPER_FLOWER())))
        ));

        register(context, IRON_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getIRON_FLOWER())))
        ));

        register(context, GOLD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getGOLD_FLOWER())))
        ));

        register(context, DIAMOND_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getDIAMOND_FLOWER())))
        ));

        register(context, EMERALD_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getEMERALD_FLOWER())))
        ));

        register(context, JACK_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(
                90, 20, 15, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getJACK_FLOWER())))
        ));

        register(context, WORLDS_ROOT, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getROOT_OF_THE_WORLDS())))
        ));

        register(context, ETHEREAL_ORCHID, Feature.FLOWER, new RandomPatchFeatureConfig(
                1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getETHEREAL_ORCHID())))
        ));

        register(context, DREADPETAL, FeaturesRegistry.INSTANCE.getFLOWER_WITH_ENTITY(), new RandomPatchFeatureConfig(
                1, 1, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getDREADPETAL())))
        ));

        register(context, BLINDBLOSSOM, FeaturesRegistry.INSTANCE.getFLOWER_WITH_ENTITY(), new RandomPatchFeatureConfig(
                1, 1, 1, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(BlocksRegistry.INSTANCE.getBLINDBLOSSOM())))
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ManyFlowers.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration
    ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
