package net.valion.manyflowers.registry

import net.minecraft.block.TallFlowerBlock
import net.minecraft.util.Rarity
import net.valion.manyflowers.block.flowers.*
import net.valion.manyflowers.util.RegistryUtil.registerFlower

object FlowerRegistry {

    // Common Flowers

    val ALSTROEMERIA = registerFlower("alstroemeria", Rarity.COMMON, ::BaseFlower)

    val HYDRANGEA = registerFlower("hydrangea", Rarity.COMMON, ::BaseFlower)

    val MARIGOLD = registerFlower("hydrangea", Rarity.COMMON, ::BaseFlower)

    val DAISES = registerFlower("daises", Rarity.COMMON, ::BaseFlower)

    val ZINNIA = registerFlower("zinnia", Rarity.COMMON, ::TallFlowerBlock)

    // Uncommon Flowers

    val SWEET_ALYSSUM = registerFlower("sweet_alyssum", Rarity.UNCOMMON, ::SweetAlyssum)

    val GAILLARDIA = registerFlower("gaillardia", Rarity.UNCOMMON, ::Gaillardia)

    val ORIENTAL_POPPY = registerFlower("oriental_poppy", Rarity.UNCOMMON, ::OrientalPoppy)

    val WATER_HEMLOCK = registerFlower("water_hemlock", Rarity.UNCOMMON, ::WaterHemlock)

    val OENOTHERA = registerFlower("oenothera", Rarity.UNCOMMON, ::Oenothera)

    val CHRYSANTHEMUM = registerFlower("chrysanthemum", Rarity.UNCOMMON, ::Chrysanthemum)

    val AUTUMN_CROCUS = registerFlower("autumn_crocus", Rarity.UNCOMMON, ::AutumnCrocus)

    val VELVETS = registerFlower("velvets", Rarity.RARE, ::Velvets)

    val AUTUMN_ASTERS = registerFlower("autumn_asters", Rarity.RARE, ::AutumnAsters)

    // Ore Flowers

    val COAL_FLOWER = registerFlower("coal_flower", Rarity.RARE, ::BaseFlower)

    val IRON_FLOWER = registerFlower("iron_flower", Rarity.RARE, ::BaseFlower)

    val COPPER_FLOWER = registerFlower("copper_flower", Rarity.RARE, ::BaseFlower)

    val GOLD_FLOWER = registerFlower("gold_flower", Rarity.RARE, ::BaseFlower)

    val DIAMOND_FLOWER = registerFlower("diamond_flower", Rarity.RARE, ::BaseFlower)

    val EMERALD_FLOWER = registerFlower("emerald_flower", Rarity.RARE, ::BaseFlower)

    // Epic Flowers

    val JACK_FLOWER = registerFlower("jack_flower", Rarity.EPIC, ::JackFlower)

    val ROOT_OF_THE_WORLDS = registerFlower("root_of_the_worlds", Rarity.EPIC, ::RootOfTheWorlds)

}