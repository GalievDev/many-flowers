package net.valion.manyflowers

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryBuilder
import net.minecraft.registry.RegistryKeys
import net.valion.manyflowers.data.ModModelProvider
import net.valion.manyflowers.data.ModWorldGenerator
import net.valion.manyflowers.world.feature.ModConfiguredFeatures
import net.valion.manyflowers.world.feature.ModPlacedFeatures

class ManyFlowersDataGenerator: DataGeneratorEntrypoint {

    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::ModModelProvider)
        pack.addProvider(::ModWorldGenerator)
    }

    override fun buildRegistry(registryBuilder: RegistryBuilder) {
        registryBuilder.addRegistry(
            RegistryKeys.CONFIGURED_FEATURE
        ) { context -> ModConfiguredFeatures.bootstrap(context) }
        registryBuilder.addRegistry(
            RegistryKeys.PLACED_FEATURE
        ) { context -> ModPlacedFeatures.bootstrap(context) }
    }
}