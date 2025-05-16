package net.valion.manyflowers.registry

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.world.gen.ProbabilityConfig
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig
import net.valion.manyflowers.world.feature.FlowerWithEntityFeature
import net.valion.manyflowers.world.feature.WaterHemlockFeature

object FeaturesRegistry {
    val HEMLOCK_FEATURE = Registry.register(
        Registries.FEATURE,
        "hemlock_feature",
        WaterHemlockFeature(ProbabilityConfig.CODEC)
    )

    val FLOWER_WITH_ENTITY = Registry.register(
        Registries.FEATURE,
        "flower_with_entity",
        FlowerWithEntityFeature(RandomPatchFeatureConfig.CODEC)
    )
}