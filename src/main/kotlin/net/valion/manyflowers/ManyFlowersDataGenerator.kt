package net.valion.manyflowers

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryBuilder
import net.minecraft.registry.RegistryKeys
import net.valion.manyflowers.data.*
import net.valion.manyflowers.world.feature.ModConfiguredFeatures
import net.valion.manyflowers.world.feature.ModPlacedFeatures

class ManyFlowersDataGenerator: DataGeneratorEntrypoint {

    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::ModModelProvider)
        pack.addProvider(::ModWorldGenerator)
        pack.addProvider(::ModLootTablesProvider)
        pack.addProvider(::ModBlockTagProvider)
        pack.addProvider(::ModRecipeProvider)
        pack.addProvider(::ModAdvancementProvider)
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