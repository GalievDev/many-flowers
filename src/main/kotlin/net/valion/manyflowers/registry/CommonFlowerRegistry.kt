package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.*
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.valion.manyflowers.ManyFlowers
import net.valion.manyflowers.registry.ItemGroupRegistry.MANY_FLOWERS

object CommonFlowerRegistry {

    val ALSTROEMERIA = create("alstroemeria", {
        FlowerBlock(StatusEffects.SATURATION, 0F, it)
    })

    val HYDRANGEA = create("hydrangea", {
        FlowerBlock(StatusEffects.WATER_BREATHING, 0F, it)
    })

    val MARIGOLD = create("hydrangea", {
        FlowerBlock(StatusEffects.FIRE_RESISTANCE, 0F, it)
    })

    val DAISES = create("daises", {
        FlowerBlock(StatusEffects.ABSORPTION, 0F, it)
    })

    val ZINNIA = create("zinnia", ::TallFlowerBlock)

    private fun create(
        name: String,
        factory: (AbstractBlock.Settings) -> Block,
        settingsBuilder: AbstractBlock.Settings.() -> Unit = {}
    ): Block {
        val settings = AbstractBlock.Settings.create().apply(settingsBuilder)
        val block = Blocks.register(
            RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ManyFlowers.MOD_ID, name)),
            { factory(settings) },
            settings
                .nonOpaque()
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ)
                .pistonBehavior(PistonBehavior.DESTROY)
        )

        Items.register(
            block, { blockItemSettings: Item.Settings ->
                blockItemSettings.rarity(Rarity.COMMON)
            }
        )

        ItemGroupEvents.modifyEntriesEvent(MANY_FLOWERS).register {
            it.add(block)
        }

        return block
    }
}