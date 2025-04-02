package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper.WrapperLookup
import net.valion.manyflowers.ManyFlowers
import java.util.concurrent.CompletableFuture

class ModWorldGenerator(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<WrapperLookup>
) : FabricDynamicRegistryProvider(output, registriesFuture) {

    override fun configure(registries: WrapperLookup, entries: Entries) {
        entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE))
        entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE))
    }

    override fun getName(): String {
        return ManyFlowers.MOD_ID
    }
}