package net.valion.manyflowers.registry

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.world.gen.ProbabilityConfig
import net.valion.manyflowers.world.feature.WaterHemlockFeature

object FeaturesRegistry {
    val HEMLOCK_FEATURE = Registry.register(Registries.FEATURE, "hemlock_feature", WaterHemlockFeature(ProbabilityConfig.CODEC))
}