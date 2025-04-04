package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import net.valion.manyflowers.registry.BlocksRegistry
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(wrappetLookup: RegistryWrapper.WrapperLookup) {
        val smallFlowers = arrayOf(
            BlocksRegistry.ALSTROEMERIA,
            BlocksRegistry.HYDRANGEA,
            BlocksRegistry.MARIGOLD,
            BlocksRegistry.DAISIES,
            BlocksRegistry.SWEET_ALYSSUM,
            BlocksRegistry.GAILLARDIA,
            BlocksRegistry.ORIENTAL_POPPY,
            BlocksRegistry.WATER_HEMLOCK,
            BlocksRegistry.CHRYSANTHEMUM,
            BlocksRegistry.AUTUMN_CROCUS,
            BlocksRegistry.VELVETS,
            BlocksRegistry.COAL_FLOWER,
            BlocksRegistry.COPPER_FLOWER,
            BlocksRegistry.IRON_FLOWER,
            BlocksRegistry.GOLD_FLOWER,
            BlocksRegistry.DIAMOND_FLOWER,
            BlocksRegistry.EMERALD_FLOWER,
            BlocksRegistry.JACK_FLOWER,
            BlocksRegistry.ROOT_OF_THE_WORLDS,
        )

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
            .add(*smallFlowers)

        getOrCreateTagBuilder(BlockTags.FLOWERS)
            .add(*smallFlowers)
            .add(BlocksRegistry.ZINNIA)
            .add(BlocksRegistry.OENOTHERA)
            .add(BlocksRegistry.AUTUMN_ASTERS)

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(BlocksRegistry.POTTED_ALSTROEMERIA)
            .add(BlocksRegistry.POTTED_HYDRANGEA)
            .add(BlocksRegistry.POTTED_MARIGOLD)
            .add(BlocksRegistry.POTTED_DAISIES)
            .add(BlocksRegistry.POTTED_SWEET_ALYSSUM)
            .add(BlocksRegistry.POTTED_GAILLARDIA)
            .add(BlocksRegistry.POTTED_ORIENTAL_POPPY)
            .add(BlocksRegistry.POTTED_CHRYSANTHEMUM)
            .add(BlocksRegistry.POTTED_ROOT_OF_THE_WORLDS)

        getOrCreateTagBuilder(BlockTags.CROPS)
            .add(BlocksRegistry.COAL_PLANT)
            .add(BlocksRegistry.COPPER_PLANT)
            .add(BlocksRegistry.IRON_PLANT)
            .add(BlocksRegistry.GOLD_PLANT)
            .add(BlocksRegistry.DIAMOND_PLANT)
            .add(BlocksRegistry.EMERALD_PLANT)
    }
}