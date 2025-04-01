package net.valion.manyflowers.registry

import net.minecraft.block.Block
import net.minecraft.sound.BlockSoundGroup
import net.valion.manyflowers.block.plant.*
import net.valion.manyflowers.util.RegistryUtil.registerBlock
import net.valion.manyflowers.util.RegistryUtil.registerCropBlock

object BlockRegistry {

    val COAL_PLANT = registerCropBlock("coal_plant", ::CoalPlant)

    val COPPER_PLANT = registerCropBlock("copper_plant", ::CopperPlant)

    val IRON_PLANT = registerCropBlock("iron_plant", ::IronPlant)

    val GOLD_PLANT = registerCropBlock("gold_plant", ::GoldPlant)

    val DIAMOND_PLANT = registerCropBlock("diamond_plant", ::DiamondPlant)

    val EMERALD_PLANT = registerCropBlock("emerald_plant", ::EmeraldPlant)

    val COAL_PETAL_BLOCK = registerBlock("coal_petal_block", ::Block) {
        sounds(BlockSoundGroup.STONE)
    }

    val COPPER_PETAL_BLOCK = registerBlock("copper_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val IRON_PETAL_BLOCK = registerBlock("iron_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val GOLD_PETAL_BLOCK = registerBlock("gold_petal_block", ::Block) {
        sounds(BlockSoundGroup.METAL)
    }

    val DIAMOND_PETAL_BLOCK = registerBlock("diamond_petal_block", ::Block) {
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }

    val EMERALD_PETAL_BLOCK = registerBlock("emerald_petal_block", ::Block) {
        sounds(BlockSoundGroup.AMETHYST_BLOCK)
    }
}