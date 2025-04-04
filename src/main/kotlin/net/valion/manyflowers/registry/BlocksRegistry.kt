package net.valion.manyflowers.registry

import net.minecraft.block.*
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Rarity
import net.valion.manyflowers.block.flowers.*
import net.valion.manyflowers.block.plant.*
import net.valion.manyflowers.util.RegistryUtil

object BlocksRegistry {

    // Common Flowers

    val ALSTROEMERIA = RegistryUtil.registerBlock("alstroemeria", Rarity.COMMON, ::BaseFlower, createFlowerSettings())

    val HYDRANGEA = RegistryUtil.registerBlock("hydrangea", Rarity.COMMON, ::BaseFlower, createFlowerSettings())

    val MARIGOLD = RegistryUtil.registerBlock("marigold", Rarity.COMMON, ::BaseFlower, createFlowerSettings())

    val DAISIES = RegistryUtil.registerBlock("daisies", Rarity.COMMON, ::BaseFlower, createFlowerSettings())

    val ZINNIA = RegistryUtil.registerBlock("zinnia", Rarity.COMMON, ::TallFlowerBlock, createFlowerSettings())

    // Uncommon Flowers

    val SWEET_ALYSSUM = RegistryUtil.registerBlock("sweet_alyssum", Rarity.UNCOMMON, ::SweetAlyssum, createFlowerSettings())

    val GAILLARDIA = RegistryUtil.registerBlock("gaillardia", Rarity.UNCOMMON, ::Gaillardia, createFlowerSettings())

    val ORIENTAL_POPPY = RegistryUtil.registerBlock("oriental_poppy", Rarity.UNCOMMON, ::OrientalPoppy, createFlowerSettings())

    val WATER_HEMLOCK = RegistryUtil.registerBlock("water_hemlock", Rarity.UNCOMMON, ::WaterHemlock, createFlowerSettings())

    val OENOTHERA = RegistryUtil.registerBlock("oenothera", Rarity.UNCOMMON, ::Oenothera, createFlowerSettings())

    val CHRYSANTHEMUM = RegistryUtil.registerBlock("chrysanthemum", Rarity.UNCOMMON, ::Chrysanthemum, createFlowerSettings())

    val AUTUMN_CROCUS = RegistryUtil.registerBlock("autumn_crocus", Rarity.UNCOMMON, ::AutumnCrocus, createFlowerSettings())

    val VELVETS = RegistryUtil.registerBlock("velvets", Rarity.RARE, ::Velvets, createFlowerSettings())

    val AUTUMN_ASTERS = RegistryUtil.registerBlock("autumn_asters", Rarity.RARE, ::AutumnAsters, createFlowerSettings())

    // Ore Flowers

    val COAL_FLOWER = RegistryUtil.registerBlock("coal_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    val COPPER_FLOWER = RegistryUtil.registerBlock("copper_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    val IRON_FLOWER = RegistryUtil.registerBlock("iron_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    val GOLD_FLOWER = RegistryUtil.registerBlock("gold_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    val DIAMOND_FLOWER = RegistryUtil.registerBlock("diamond_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    val EMERALD_FLOWER = RegistryUtil.registerBlock("emerald_flower", Rarity.RARE, ::BaseFlower, createFlowerSettings())

    // Epic Flowers

    val JACK_FLOWER = RegistryUtil.registerBlock("jack_flower", Rarity.EPIC, ::JackFlower, createFlowerSettings())

    val ROOT_OF_THE_WORLDS = RegistryUtil.registerBlock("root_of_the_worlds", Rarity.EPIC, ::RootOfTheWorlds, createFlowerSettings())

    // Potted Flower Blocks

    val POTTED_ALSTROEMERIA = RegistryUtil.registerBlockWithoutItem("potted_alstroemeria", {
        FlowerPotBlock(ALSTROEMERIA, it)
    }, createFlowerPotSettings())

    val POTTED_HYDRANGEA = RegistryUtil.registerBlockWithoutItem("potted_hydrangea", {
        FlowerPotBlock(HYDRANGEA, it)
    }, createFlowerPotSettings())

    val POTTED_MARIGOLD = RegistryUtil.registerBlockWithoutItem("potted_marigold", {
        FlowerPotBlock(MARIGOLD, it)
    }, createFlowerPotSettings())

    val POTTED_DAISIES = RegistryUtil.registerBlockWithoutItem("potted_daisies", {
        FlowerPotBlock(DAISIES, it)
    }, createFlowerPotSettings())

    val POTTED_SWEET_ALYSSUM = RegistryUtil.registerBlockWithoutItem("potted_sweet_alyssum", {
        FlowerPotBlock(SWEET_ALYSSUM, it)
    }, createFlowerPotSettings())

    val POTTED_GAILLARDIA = RegistryUtil.registerBlockWithoutItem("potted_gaillardia", {
        FlowerPotBlock(GAILLARDIA, it)
    }, createFlowerPotSettings())

    val POTTED_ORIENTAL_POPPY = RegistryUtil.registerBlockWithoutItem("potted_oriental_poppy", {
        FlowerPotBlock(ORIENTAL_POPPY, it)
    }, createFlowerPotSettings())

    val POTTED_CHRYSANTHEMUM = RegistryUtil.registerBlockWithoutItem("potted_chrysanthemum", {
        FlowerPotBlock(CHRYSANTHEMUM, it)
    }, createFlowerPotSettings())

    val POTTED_ROOT_OF_THE_WORLDS = RegistryUtil.registerBlockWithoutItem("potted_root_of_the_worlds", {
        FlowerPotBlock(ROOT_OF_THE_WORLDS, it)
    }, createFlowerPotSettings())

    // Flower Plants

    val COAL_PLANT = RegistryUtil.registerBlockWithoutItem("coal_plant", ::CoalPlant, createCropSettings())

    val COPPER_PLANT = RegistryUtil.registerBlockWithoutItem("copper_plant", ::CopperPlant, createCropSettings())

    val IRON_PLANT = RegistryUtil.registerBlockWithoutItem("iron_plant", ::IronPlant, createCropSettings())

    val GOLD_PLANT = RegistryUtil.registerBlockWithoutItem("gold_plant", ::GoldPlant, createCropSettings())

    val DIAMOND_PLANT = RegistryUtil.registerBlockWithoutItem("diamond_plant", ::DiamondPlant, createCropSettings())

    val EMERALD_PLANT = RegistryUtil.registerBlockWithoutItem("emerald_plant", ::EmeraldPlant, createCropSettings())

    // Blocks
    
    val COAL_PETAL_BLOCK = RegistryUtil.registerBlock("coal_petal_block", ::Block) {
        sounds(BlockSoundGroup.STONE)
    }

    val COPPER_PETAL_BLOCK = RegistryUtil.registerBlock("copper_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val IRON_PETAL_BLOCK = RegistryUtil.registerBlock("iron_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val GOLD_PETAL_BLOCK = RegistryUtil.registerBlock("gold_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val DIAMOND_PETAL_BLOCK = RegistryUtil.registerBlock("diamond_petal_block", ::Block) {
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }

    val EMERALD_PETAL_BLOCK = RegistryUtil.registerBlock("emerald_petal_block", ::Block) {
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }

    private fun createFlowerSettings(): Settings.() -> Unit = {
        mapColor(MapColor.DARK_GREEN)
        nonOpaque()
        noCollision()
        breakInstantly()
        sounds(BlockSoundGroup.GRASS)
        offset(AbstractBlock.OffsetType.XZ)
        pistonBehavior(PistonBehavior.DESTROY)
    }

    private fun createCropSettings(): Settings.() -> Unit = {
        nonOpaque()
        noCollision()
        ticksRandomly()
        breakInstantly()
        sounds(BlockSoundGroup.CROP)
        pistonBehavior(PistonBehavior.DESTROY)
    }

    private fun createFlowerPotSettings(): Settings.() -> Unit = {
        breakInstantly()
        nonOpaque()
        pistonBehavior(PistonBehavior.DESTROY)
    }
}