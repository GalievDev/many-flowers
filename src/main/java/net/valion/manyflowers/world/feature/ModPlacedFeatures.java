package net.valion.manyflowers.world.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
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
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), Flowers.ORIENTAL_POPPY));

        register(context, WORLDS_ROOT_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WORLDS_ROOT),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), Flowers.ROOT_OF_THE_WORLDS));

/*
        register(context, VELVETS_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VELVETS),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(33), Flowers.VELVETS));
*/

        register(context, DIAMOND_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIAMOND_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.DIAMOND_FLOWER));

        register(context, GOLD_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GOLD_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.GOLD_FLOWER));

        register(context, IRON_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.IRON_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.IRON_FLOWER));

        register(context, EMERALD_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.EMERALD_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.EMERALD_FLOWER));

        register(context, COPPER_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COPPER_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.COPPER_FLOWER));

        register(context, COAL_FLOWER_PLACED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COAL_FLOWER),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(RarityFilterPlacementModifier.of(100), OreFlowers.COAL_FLOWER));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ManyFlowers.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
