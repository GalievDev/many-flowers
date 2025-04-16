package net.valion.manyflowers.registry

import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers.MOD_ID

object BlockTagsRegistry {
    val COMMON_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "common_flowers"))
    val UNCOMMON_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "uncommon_flowers"))
    val RARE_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "rare_flowers"))
    val ORE_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "ore_flowers"))
    val EPIC_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "epic_flowers"))
}