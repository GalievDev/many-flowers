package net.valion.manyflowers.registry

import net.minecraft.item.BlockItem
import net.valion.manyflowers.util.RegistryUtil.registerItem

object ItemRegistry {

    val COAL_SEEDS = registerItem("coal_seeds", {
        BlockItem(BlockRegistry.COAL_PLANT, it)
    })

    val COPPER_SEEDS = registerItem("copper_seeds", {
        BlockItem(BlockRegistry.COPPER_PLANT, it)
    })

    val IRON_SEEDS = registerItem("iron_seeds", {
        BlockItem(BlockRegistry.IRON_PLANT, it)
    })

    val GOLD_SEEDS = registerItem("gold_seeds", {
        BlockItem(BlockRegistry.GOLD_PLANT, it)
    })

    val DIAMOND_SEEDS = registerItem("diamond_seeds", {
        BlockItem(BlockRegistry.DIAMOND_PLANT, it)
    })

    val EMERALD_SEEDS = registerItem("emerald_seeds", {
        BlockItem(BlockRegistry.EMERALD_PLANT, it)
    })
}