package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.valion.manyflowers.registry.BlocksRegistry
import net.valion.manyflowers.registry.ItemTagsRegistry
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
): FabricTagProvider.ItemTagProvider(output, registriesFuture) {
    override fun configure(wrapperLookup: RegistryWrapper.WrapperLookup?) {
        valueLookupBuilder(ItemTagsRegistry.COMMON_FLOWERS)
            .add(BlocksRegistry.ALSTROEMERIA.asItem())
            .add(BlocksRegistry.HYDRANGEA.asItem())
            .add(BlocksRegistry.MARIGOLD.asItem())
            .add(BlocksRegistry.DAISIES.asItem())
            .add(BlocksRegistry.ZINNIA.asItem())
            .add(BlocksRegistry.COSMOS.asItem())
            .add(BlocksRegistry.PURPLE_CORNFLOWER.asItem())
            .add(BlocksRegistry.PETUNIA.asItem())
            .add(BlocksRegistry.GERANIUM.asItem())
            .add(BlocksRegistry.BEGONIA.asItem())
            .add(BlocksRegistry.SNAPDRAGON.asItem())

        valueLookupBuilder(ItemTagsRegistry.UNCOMMON_FLOWERS)
            .add(BlocksRegistry.SWEET_ALYSSUM.asItem())
            .add(BlocksRegistry.GAILLARDIA.asItem())
            .add(BlocksRegistry.ORIENTAL_POPPY.asItem())
            .add(BlocksRegistry.WATER_HEMLOCK.asItem())
            .add(BlocksRegistry.OENOTHERA.asItem())
            .add(BlocksRegistry.CHRYSANTHEMUM.asItem())
            .add(BlocksRegistry.AUTUMN_CROCUS.asItem())
            .add(BlocksRegistry.BLACK_EYED_SUSAN.asItem())
            .add(BlocksRegistry.COREOPSIS.asItem())
            .add(BlocksRegistry.DAHLIA.asItem())
            .add(BlocksRegistry.LAVENDER.asItem())

        valueLookupBuilder(ItemTagsRegistry.RARE_FLOWERS)
            .add(BlocksRegistry.VELVETS.asItem())
            .add(BlocksRegistry.AUTUMN_ASTERS.asItem())
            .add(BlocksRegistry.BONE_FLOWER.asItem())
            .add(BlocksRegistry.TRADE_FLOWER.asItem())

        valueLookupBuilder(ItemTagsRegistry.ORE_FLOWERS)
            .add(BlocksRegistry.COAL_FLOWER.asItem())
            .add(BlocksRegistry.COPPER_FLOWER.asItem())
            .add(BlocksRegistry.IRON_FLOWER.asItem())
            .add(BlocksRegistry.GOLD_FLOWER.asItem())
            .add(BlocksRegistry.DIAMOND_FLOWER.asItem())
            .add(BlocksRegistry.EMERALD_FLOWER.asItem())
    }
}