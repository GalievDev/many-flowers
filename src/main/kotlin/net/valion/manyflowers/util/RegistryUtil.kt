package net.valion.manyflowers.util

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.*
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
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
        return Items.register(
            RegistryKey.of(
                RegistryKeys.ITEM, Identifier.of(MOD_ID, name)
            ), { factory(settings) }, settings
        ) as T
    }

    inline fun <reified T: Block> registerFlower(
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
                .mapColor(MapColor.DARK_GREEN)
                .nonOpaque()
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY)
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

    fun registerCropBlock(
        name: String,
        factory: (AbstractBlock.Settings) -> CropBlock,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): CropBlock {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        return Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, name)),
            { factory(settings) },
            settings
                .nonOpaque()
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSoundGroup.CROP)
                .pistonBehavior(PistonBehavior.DESTROY)
        ) as CropBlock
    }
}
