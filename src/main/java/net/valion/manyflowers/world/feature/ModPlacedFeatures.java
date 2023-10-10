package net.valion.manyflowers.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.OreFlowers;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ALSTROEMERIA_FLOWER_PLACED = registerKey("alstroemeria_placed");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_FLOWER_PLACED = registerKey("hydrangea_placed");
    public static final RegistryKey<PlacedFeature> MARIGOLD_FLOWER_PLACED = registerKey("marigold_placed");
    public static final RegistryKey<PlacedFeature> ALYSSUM_FLOWER_PLACED = registerKey("sweet_alyssum_placed");
    public static final RegistryKey<PlacedFeature> HEMLOCK_PLACED = registerKey("hemlock_placed");
    public static final RegistryKey<PlacedFeature> OENOTHERA_PLACED = registerKey("oenothera_placed");
    public static final RegistryKey<PlacedFeature> GAILLARDIA_PLACED = registerKey("gaillardia_placed");
    public static final RegistryKey<PlacedFeature> POPPY_PLACED = registerKey("poppy_placed");
    public static final RegistryKey<PlacedFeature> WORLDS_ROOT_PLACED = registerKey("worlds_root_placed");
    public static final RegistryKey<PlacedFeature> VELVETS_PLACED = registerKey("velvets_placed");
    public static final RegistryKey<PlacedFeature> CHRYSANTHEMUM_PLACED = registerKey("chrysanthemum_placed");
    public static final RegistryKey<PlacedFeature> DAISIES_PLACED = registerKey("daisies_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_ASTERS = registerKey("autumn_asters_placed");
    public static final RegistryKey<PlacedFeature> ZINNIA = registerKey("zinnia_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_CROCUS = registerKey("autumn_crocus_placed");
    public static final RegistryKey<PlacedFeature> JACK_FLOWER = registerKey("jack_placed");
    public static final RegistryKey<PlacedFeature> DIAMOND_FLOWER_PLACED = registerKey("diamond_flower_placed");
    public static final RegistryKey<PlacedFeature> GOLD_FLOWER_PLACED = registerKey("gold_flower_placed");
    public static final RegistryKey<PlacedFeature> IRON_FLOWER_PLACED = registerKey("iron_flower_placed");
    public static final RegistryKey<PlacedFeature> EMERALD_FLOWER_PLACED = registerKey("emerald_flower_placed");
    public static final RegistryKey<PlacedFeature> COPPER_FLOWER_PLACED = registerKey("copper_flower_placed");
    public static final RegistryKey<PlacedFeature> COAL_FLOWER_PLACED = registerKey("coal_flower_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ALSTROEMERIA_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ALSTROEMERIA_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(47), Flowers.ALSTROEMERIA_FLOWER));

        register(context, HYDRANGEA_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(32), Flowers.HYDRANGEA_FLOWER));

        register(context, MARIGOLD_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MARIGOLD_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(33), Flowers.MARIGOLD_FLOWER));

        register(context, ALYSSUM_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SWEET_ALYSSUM),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(44), Flowers.SWEET_ALYSSUM));

        register(context, HEMLOCK_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HEMLOCK),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(33), Flowers.HEMLOCK));

        register(context, OENOTHERA_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OENOTHERA),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(33), Flowers.OENOTHERA));

        register(context, GAILLARDIA_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GAILLARDIA),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(25), Flowers.GAILLARDIA));

        register(context, POPPY_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORIENTAL_POPPY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(256), Flowers.ORIENTAL_POPPY));

        register(context, WORLDS_ROOT_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WORLDS_ROOT),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), Flowers.ROOT_OF_THE_WORLDS));

   /*     register(context, VELVETS_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VELVETS),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(180), Flowers.VELVETS));
*/
        RegistryEntry.Reference<ConfiguredFeature<?, ?>> velvet = configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VELVETS);

        PlacedFeatures.register(context, VELVETS_PLACED, velvet, makePatchPlacements(CountPlacementModifier.of(UniformIntProvider.create(0, 4))));


        register(context, CHRYSANTHEMUM_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHRYSANTHEMUM),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), Flowers.CHRYSANTHEMUM));

        register(context, DAISIES_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DAISIES),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(40), Flowers.DAISIES));

        register(context, AUTUMN_ASTERS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_ASTERS),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(200), Flowers.AUTUMN_ASTERS));

        register(context, ZINNIA, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ZINNIA),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(54), Flowers.ZINNIA));

        PlacedFeatures.register(context, AUTUMN_CROCUS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_CROCUS),
                RarityFilterPlacementModifier.of(70), PlacedFeatures.BOTTOM_TO_120_RANGE, SquarePlacementModifier.of(), BiomePlacementModifier.of());

        register(context, JACK_FLOWER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACK_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(50), Flowers.JACK_FLOWER));

        register(context, DIAMOND_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIAMOND_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.DIAMOND_FLOWER));

        register(context, GOLD_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOLD_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.GOLD_FLOWER));

        register(context, IRON_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.IRON_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.IRON_FLOWER));

        register(context, EMERALD_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.EMERALD_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.EMERALD_FLOWER));

        register(context, COPPER_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COPPER_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.COPPER_FLOWER));

        register(context, COAL_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COAL_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(500), OreFlowers.COAL_FLOWER));
    }

    public static List<PlacementModifier> makePatchPlacements(PlacementModifier countOrRarity) {
        return List.of(countOrRarity, SquarePlacementModifier.of(), PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ManyFlowers.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
