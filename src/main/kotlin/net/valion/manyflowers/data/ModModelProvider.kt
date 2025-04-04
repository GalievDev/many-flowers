package net.valion.manyflowers.data

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Block
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.BlockStateModelGenerator.CrossType
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Models
import net.minecraft.state.property.Properties
import net.valion.manyflowers.registry.BlocksRegistry
import net.valion.manyflowers.registry.ItemsRegistry

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {

    override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ALSTROEMERIA, BlocksRegistry.POTTED_ALSTROEMERIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.HYDRANGEA, BlocksRegistry.POTTED_HYDRANGEA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.MARIGOLD, BlocksRegistry.POTTED_MARIGOLD, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.DAISIES, BlocksRegistry.POTTED_DAISIES, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.ZINNIA, CrossType.NOT_TINTED)

        generator.registerFlowerPotPlantAndItem(BlocksRegistry.SWEET_ALYSSUM, BlocksRegistry.POTTED_SWEET_ALYSSUM, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.GAILLARDIA, BlocksRegistry.POTTED_GAILLARDIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ORIENTAL_POPPY, BlocksRegistry.POTTED_ORIENTAL_POPPY, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.OENOTHERA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.CHRYSANTHEMUM, BlocksRegistry.POTTED_CHRYSANTHEMUM, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.VELVETS, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.AUTUMN_ASTERS, CrossType.NOT_TINTED)

        registerFlowerWithItem(generator, BlocksRegistry.COAL_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.COPPER_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.IRON_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.GOLD_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.DIAMOND_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.EMERALD_FLOWER, CrossType.NOT_TINTED)

        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ROOT_OF_THE_WORLDS, BlocksRegistry.POTTED_ROOT_OF_THE_WORLDS, CrossType.NOT_TINTED)

        generator.registerCrop(BlocksRegistry.COAL_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)
        generator.registerCrop(BlocksRegistry.COPPER_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)
        generator.registerCrop(BlocksRegistry.IRON_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)
        generator.registerCrop(BlocksRegistry.GOLD_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)
        generator.registerCrop(BlocksRegistry.DIAMOND_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)
        generator.registerCrop(BlocksRegistry.EMERALD_PLANT, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7)

        generator.registerSimpleCubeAll(BlocksRegistry.COAL_PETAL_BLOCK)
        generator.registerSimpleCubeAll(BlocksRegistry.COPPER_PETAL_BLOCK)
        generator.registerSimpleCubeAll(BlocksRegistry.IRON_PETAL_BLOCK)
        generator.registerSimpleCubeAll(BlocksRegistry.GOLD_PETAL_BLOCK)
        generator.registerSimpleCubeAll(BlocksRegistry.DIAMOND_PETAL_BLOCK)
        generator.registerSimpleCubeAll(BlocksRegistry.EMERALD_PETAL_BLOCK)
    }

    override fun generateItemModels(generator: ItemModelGenerator) {
        generator.register(ItemsRegistry.COAL_PETAL, Models.GENERATED)
        generator.register(ItemsRegistry.COPPER_PETAL, Models.GENERATED)
        generator.register(ItemsRegistry.IRON_PETAL, Models.GENERATED)
        generator.register(ItemsRegistry.GOLD_PETAL, Models.GENERATED)
        generator.register(ItemsRegistry.DIAMOND_PETAL, Models.GENERATED)
        generator.register(ItemsRegistry.EMERALD_PETAL, Models.GENERATED)
    }

    private fun registerFlowerWithItem(generator: BlockStateModelGenerator, block: Block, crossType: CrossType) {
        generator.registerTintableCrossBlockState(block, crossType)
        generator.registerItemModel(block.asItem(), crossType.registerItemModel(generator, block))
    }
}