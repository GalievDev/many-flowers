package net.valion.manyflowers.data

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Block
import net.minecraft.client.data.*
import net.minecraft.client.data.BlockStateModelGenerator.CrossType
import net.minecraft.client.render.model.json.ModelVariant
import net.minecraft.client.render.model.json.WeightedVariant
import net.minecraft.state.property.Properties
import net.minecraft.util.Identifier
import net.minecraft.util.collection.Pool
import net.valion.manyflowers.block.flowers.EtherealOrchid
import net.valion.manyflowers.registry.BlocksRegistry
import net.valion.manyflowers.registry.ItemsRegistry

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {

    override fun generateBlockStateModels(generator: BlockStateModelGenerator) {
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ALSTROEMERIA, BlocksRegistry.POTTED_ALSTROEMERIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.HYDRANGEA, BlocksRegistry.POTTED_HYDRANGEA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.MARIGOLD, BlocksRegistry.POTTED_MARIGOLD, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.DAISIES, BlocksRegistry.POTTED_DAISIES, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.ZINNIA, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.COSMOS, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.PURPLE_CORNFLOWER, BlocksRegistry.POTTED_PURPLE_CORNFLOWER, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.PETUNIA, BlocksRegistry.POTTED_PETUNIA, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.GERANIUM, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.BEGONIA, BlocksRegistry.POTTED_BEGONIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.SNAPDRAGON, BlocksRegistry.POTTED_SNAPDRAGON, CrossType.NOT_TINTED)

        generator.registerFlowerPotPlantAndItem(BlocksRegistry.SWEET_ALYSSUM, BlocksRegistry.POTTED_SWEET_ALYSSUM, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.GAILLARDIA, BlocksRegistry.POTTED_GAILLARDIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ORIENTAL_POPPY, BlocksRegistry.POTTED_ORIENTAL_POPPY, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.WATER_HEMLOCK, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.OENOTHERA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.CHRYSANTHEMUM, BlocksRegistry.POTTED_CHRYSANTHEMUM, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.AUTUMN_CROCUS, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.BLACK_EYED_SUSAN, BlocksRegistry.POTTED_BLACK_EYED_SUSAN, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.COREOPSIS, BlocksRegistry.POTTED_COREOPSIS, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.DAHLIA, BlocksRegistry.POTTED_DAHLIA, CrossType.NOT_TINTED)
        generator.registerFlowerPotPlantAndItem(BlocksRegistry.LAVENDER, BlocksRegistry.POTTED_LAVENDER, CrossType.NOT_TINTED)

        registerFlowerWithItem(generator, BlocksRegistry.VELVETS, CrossType.NOT_TINTED)
        generator.registerDoubleBlockAndItem(BlocksRegistry.AUTUMN_ASTERS, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.BONE_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.TRADE_FLOWER, CrossType.NOT_TINTED)

        registerFlowerWithItem(generator, BlocksRegistry.COAL_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.COPPER_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.IRON_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.GOLD_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.DIAMOND_FLOWER, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.EMERALD_FLOWER, CrossType.NOT_TINTED)

        generator.registerFlowerPotPlantAndItem(BlocksRegistry.ROOT_OF_THE_WORLDS, BlocksRegistry.POTTED_ROOT_OF_THE_WORLDS, CrossType.NOT_TINTED)
        registerTintableVariantBlock(generator, BlocksRegistry.ETHEREAL_ORCHID, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.DREADPETAL, CrossType.NOT_TINTED)
        registerFlowerWithItem(generator, BlocksRegistry.BLINDBLOSSOM, CrossType.NOT_TINTED)

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
        generator.register(ItemsRegistry.FLORAL_MEAL, Models.GENERATED)
    }

    private fun registerFlowerWithItem(generator: BlockStateModelGenerator, block: Block, crossType: CrossType) {
        generator.registerTintableCrossBlockState(block, crossType)
        generator.registerItemModel(block.asItem(), crossType.registerItemModel(generator, block))
    }

    private fun registerTintableVariantBlock(generator: BlockStateModelGenerator, block: Block, crossType: CrossType) {
        val textureMap = crossType.getTextureMap(block)
        val identifier = crossType.crossModel.upload(block, "", textureMap, generator.modelCollector)
        val identifiers = arrayOfNulls<Identifier>(4)

        for (i in 0..3) {
            if (i == 3) {
                identifiers[i] = identifier
            } else {
                val variantTextureMap = TextureMap().put(TextureKey.CROSS, TextureMap.getSubId(block, "_$i"))
                identifiers[i] =
                    crossType.crossModel.upload(
                        block,
                        "_$i",
                        variantTextureMap,
                        generator.modelCollector
                    )
            }
        }

        generator.blockStateCollector
            .accept(
                VariantsBlockModelDefinitionCreator.of(BlocksRegistry.ETHEREAL_ORCHID)
                    .with(
                        BlockStateVariantMap.models(EtherealOrchid.CHARGES).generate { charges: Int ->
                            WeightedVariant(Pool.of(ModelVariant(identifiers[charges])))
                        }
                    )
            )
        generator.registerItemModel(
            BlocksRegistry.ETHEREAL_ORCHID.asItem(),
            crossType.registerItemModel(
                generator,
                BlocksRegistry.ETHEREAL_ORCHID
            )
        )
    }
}