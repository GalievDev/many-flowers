package net.valion.manyflowers.registry

import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.valion.manyflowers.util.RegistryUtil.registerItem

object ItemsRegistry {

    val COAL_SEEDS = registerItem("coal_seeds", {
        BlockItem(BlocksRegistry.COAL_PLANT, it)
    })

    val COPPER_SEEDS = registerItem("copper_seeds", {
        BlockItem(BlocksRegistry.COPPER_PLANT, it)
    })

    val IRON_SEEDS = registerItem("iron_seeds", {
        BlockItem(BlocksRegistry.IRON_PLANT, it)
    })

    val GOLD_SEEDS = registerItem("gold_seeds", {
        BlockItem(BlocksRegistry.GOLD_PLANT, it)
    })

    val DIAMOND_SEEDS = registerItem("diamond_seeds", {
        BlockItem(BlocksRegistry.DIAMOND_PLANT, it)
    })

    val EMERALD_SEEDS = registerItem("emerald_seeds", {
        BlockItem(BlocksRegistry.EMERALD_PLANT, it)
    })

    val COAL_PETAL = registerItem("coal_petal", ::Item)

    val COPPER_PETAL = registerItem("copper_petal", ::Item)

    val IRON_PETAL = registerItem("iron_petal", ::Item)

    val GOLD_PETAL = registerItem("gold_petal", ::Item)

    val DIAMOND_PETAL = registerItem("diamond_petal", ::Item)

    val EMERALD_PETAL = registerItem("emerald_petal", ::Item)
}