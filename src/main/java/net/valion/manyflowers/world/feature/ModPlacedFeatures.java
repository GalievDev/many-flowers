package net.valion.manyflowers.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> ALSTROEMERIA_FLOWER = PlacedFeatures.register("alstroemeria_placed",
            ModConfiguredFeatures.ALSTROEMERIA_FLOWER, RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> HYDRANGEA_PLACED = PlacedFeatures.register("hydrangea_placed",
            ModConfiguredFeatures.HYDRANGEA_FLOWER, RarityFilterPlacementModifier.of(36), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> MARIGOLD_PLACED = PlacedFeatures.register("marigold_placed",
            ModConfiguredFeatures.MARIGOLD_FLOWER, RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> ALYSSUM_PLACED = PlacedFeatures.register("alyssum_placed",
            ModConfiguredFeatures.SWEET_ALYSSUM, RarityFilterPlacementModifier.of(16), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> HEMLOCK_PLACED = PlacedFeatures.register("hemlock_placed",
            ModConfiguredFeatures.HEMLOCK, RarityFilterPlacementModifier.of(36), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> OENOTHERA_PLACED = PlacedFeatures.register("oenothera_placed",
            ModConfiguredFeatures.OENOTHERA, RarityFilterPlacementModifier.of(27), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> GAILLARDIA_PLACED = PlacedFeatures.register("gaillardia_placed",
            ModConfiguredFeatures.GAILLARDIA, RarityFilterPlacementModifier.of(17), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> POPPY_PLACED = PlacedFeatures.register("poppy_placed",
            ModConfiguredFeatures.ORIENTAL_POPPY, RarityFilterPlacementModifier.of(13), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    //Ore FLowers//
    public static final RegistryEntry<PlacedFeature> DIAMOND_PLACED = PlacedFeatures.register("diamond_placed",
            ModConfiguredFeatures.DIAMOND_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> COAL_PLACED = PlacedFeatures.register("coal_placed",
            ModConfiguredFeatures.COAL_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> IRON_PLACED = PlacedFeatures.register("iron_placed",
            ModConfiguredFeatures.IRON_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> GOLD_PLACED = PlacedFeatures.register("gold_placed",
            ModConfiguredFeatures.GOLD_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> EMERALD_PLACED = PlacedFeatures.register("emerald_placed",
            ModConfiguredFeatures.EMERALD_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static final RegistryEntry<PlacedFeature> COPPER_PLACED = PlacedFeatures.register("copper_placed",
            ModConfiguredFeatures.COPPER_FLOWER, RarityFilterPlacementModifier.of(35), SquarePlacementModifier.of(),
            PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
}
