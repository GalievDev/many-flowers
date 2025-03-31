package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers

object ItemGroupRegistry {
    val MANY_FLOWERS: RegistryKey<ItemGroup> = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(ManyFlowers.MOD_ID))

    init {
        Registry.register(
            Registries.ITEM_GROUP, MANY_FLOWERS,
            FabricItemGroup.builder()
                .icon{
                    CommonFlowerRegistry.ALSTROEMERIA.asItem().defaultStack
                }
                .displayName(Text.of("Many Flowers"))
                .build()
        )
    }
}