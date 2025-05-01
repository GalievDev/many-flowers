package net.valion.manyflowers.util

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.valion.manyflowers.ManyFlowers.MOD_ID
import net.valion.manyflowers.registry.ItemGroupRegistry.MANY_FLOWERS

object RegistryUtil {
    inline fun <reified T : Item> registerItem(
        name: String,
        crossinline factory: (Item.Settings) -> T,
        settingsBuilder: Item.Settings.() -> Unit = {}
    ): T {
        val settings = Item.Settings().apply(settingsBuilder)
        val item = Items.register(
            RegistryKey.of(
                RegistryKeys.ITEM, Identifier.of(MOD_ID, name)
            ), { factory(settings) }, settings
        ) as T

        ItemGroupEvents.modifyEntriesEvent(MANY_FLOWERS).register {
            it.add(item)
        }

        return item
    }

    inline fun <reified T : Block> registerBlock(
        name: String,
        rarity: Rarity,
        crossinline factory: (AbstractBlock.Settings) -> T,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): T {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        val block = Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name)),
            { factory(settings) },
            settings

        ) as T

        Items.register(block) { blockItemSettings: Item.Settings ->
            blockItemSettings.rarity(rarity)
        }

        ItemGroupEvents.modifyEntriesEvent(MANY_FLOWERS).register {
            it.add(block)
        }

        return block
    }

    inline fun <reified T: Block> registerBlock(
        name: String,
        crossinline factory: (AbstractBlock.Settings) -> T,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): T {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        val block = Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name)),
            { factory(settings) },
            settings
        ) as T

        Items.register(block)

        ItemGroupEvents.modifyEntriesEvent(MANY_FLOWERS).register {
            it.add(block)
        }

        return block
    }

    inline fun <reified T: Block> registerBlockWithoutItem(
        name: String,
        crossinline factory: (AbstractBlock.Settings) -> T,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): T {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        return Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name)),
            { factory(settings) },
            settings
        ) as T
    }

    fun registerSound(id: String?): SoundEvent {
        val identifier = Identifier.of(MOD_ID, id)
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier))
    }
}
