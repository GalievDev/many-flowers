package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import net.valion.manyflowers.registry.BlockTagsRegistry
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
            BlocksRegistry.PURPLE_CORNFLOWER,
            BlocksRegistry.PETUNIA,
            BlocksRegistry.BEGONIA,
            BlocksRegistry.SNAPDRAGON,
            BlocksRegistry.SWEET_ALYSSUM,
            BlocksRegistry.GAILLARDIA,
            BlocksRegistry.ORIENTAL_POPPY,
            BlocksRegistry.WATER_HEMLOCK,
            BlocksRegistry.CHRYSANTHEMUM,
            BlocksRegistry.AUTUMN_CROCUS,
            BlocksRegistry.BLACK_EYED_SUSAN,
            BlocksRegistry.COREOPSIS,
            BlocksRegistry.DAHLIA,
            BlocksRegistry.LAVENDER,
            BlocksRegistry.VELVETS,
            BlocksRegistry.BONE_FLOWER,
            BlocksRegistry.TRADE_FLOWER,
            BlocksRegistry.COAL_FLOWER,
            BlocksRegistry.COPPER_FLOWER,
            BlocksRegistry.IRON_FLOWER,
            BlocksRegistry.GOLD_FLOWER,
            BlocksRegistry.DIAMOND_FLOWER,
            BlocksRegistry.EMERALD_FLOWER,
            BlocksRegistry.JACK_FLOWER,
            BlocksRegistry.ROOT_OF_THE_WORLDS,
            BlocksRegistry.ETHEREAL_ORCHID,
            BlocksRegistry.DREADPETAL,
            BlocksRegistry.BLINDBLOSSOM,
        )

        getOrCreateTagBuilder(BlockTagsRegistry.COMMON_FLOWERS)
            .add(BlocksRegistry.ALSTROEMERIA)
            .add(BlocksRegistry.HYDRANGEA)
            .add(BlocksRegistry.MARIGOLD)
            .add(BlocksRegistry.DAISIES)
            .add(BlocksRegistry.ZINNIA)
            .add(BlocksRegistry.COSMOS)
            .add(BlocksRegistry.PURPLE_CORNFLOWER)
            .add(BlocksRegistry.PETUNIA)
            .add(BlocksRegistry.GERANIUM)
            .add(BlocksRegistry.BEGONIA)
            .add(BlocksRegistry.SNAPDRAGON)

        getOrCreateTagBuilder(BlockTagsRegistry.UNCOMMON_FLOWERS)
            .add(BlocksRegistry.SWEET_ALYSSUM)
            .add(BlocksRegistry.GAILLARDIA)
            .add(BlocksRegistry.ORIENTAL_POPPY)
            .add(BlocksRegistry.WATER_HEMLOCK)
            .add(BlocksRegistry.OENOTHERA)
            .add(BlocksRegistry.CHRYSANTHEMUM)
            .add(BlocksRegistry.AUTUMN_CROCUS)
            .add(BlocksRegistry.BLACK_EYED_SUSAN)
            .add(BlocksRegistry.COREOPSIS)
            .add(BlocksRegistry.DAHLIA)
            .add(BlocksRegistry.LAVENDER)

        getOrCreateTagBuilder(BlockTagsRegistry.RARE_FLOWERS)
            .add(BlocksRegistry.VELVETS)
            .add(BlocksRegistry.AUTUMN_ASTERS)
            .add(BlocksRegistry.BONE_FLOWER)
            .add(BlocksRegistry.TRADE_FLOWER)

        getOrCreateTagBuilder(BlockTagsRegistry.ORE_FLOWERS)
            .add(BlocksRegistry.COAL_FLOWER)
            .add(BlocksRegistry.COPPER_FLOWER)
            .add(BlocksRegistry.IRON_FLOWER)
            .add(BlocksRegistry.GOLD_FLOWER)
            .add(BlocksRegistry.DIAMOND_FLOWER)
            .add(BlocksRegistry.EMERALD_FLOWER)

        getOrCreateTagBuilder(BlockTagsRegistry.EPIC_FLOWERS)
            .add(BlocksRegistry.JACK_FLOWER)
            .add(BlocksRegistry.ROOT_OF_THE_WORLDS)
            .add(BlocksRegistry.ETHEREAL_ORCHID)
            .add(BlocksRegistry.DREADPETAL)
            .add(BlocksRegistry.BLINDBLOSSOM)

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
            .add(*smallFlowers)

        getOrCreateTagBuilder(BlockTags.FLOWERS)
            .add(*smallFlowers)
            .add(BlocksRegistry.ZINNIA)
            .add(BlocksRegistry.OENOTHERA)
            .add(BlocksRegistry.AUTUMN_ASTERS)
            .add(BlocksRegistry.COSMOS)
            .add(BlocksRegistry.GERANIUM)

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
            .add(BlocksRegistry.POTTED_ALSTROEMERIA)
            .add(BlocksRegistry.POTTED_HYDRANGEA)
            .add(BlocksRegistry.POTTED_PURPLE_CORNFLOWER)
            .add(BlocksRegistry.POTTED_PETUNIA)
            .add(BlocksRegistry.POTTED_BEGONIA)
            .add(BlocksRegistry.POTTED_SNAPDRAGON)
            .add(BlocksRegistry.BLACK_EYED_SUSAN)
            .add(BlocksRegistry.POTTED_COREOPSIS)
            .add(BlocksRegistry.POTTED_DAHLIA)
            .add(BlocksRegistry.POTTED_LAVENDER)
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