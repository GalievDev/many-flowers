package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.advancement.criterion.TickCriterion
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers
import net.valion.manyflowers.registry.BlocksRegistry
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ModAdvancementProvider(
    output: FabricDataOutput,
    registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricAdvancementProvider(output, registryLookup) {

    override fun generateAdvancement(
        wrapperLookup: RegistryWrapper.WrapperLookup?,
        consumer: Consumer<AdvancementEntry?>?
    ) {
        val root = Advancement.Builder.create()
            .display(
                BlocksRegistry.ALSTROEMERIA,
                Text.literal("Many Flowers"),
                Text.translatable("advancement.mf.first_join"),
                Identifier.ofVanilla("block/dirt"),
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("joint_world", TickCriterion.Conditions.createTick())
            .build(consumer, ManyFlowers.MOD_ID + ":join_world")

        Advancement.Builder.create()
            .parent(root)
            .display(
                BlocksRegistry.HYDRANGEA,
                Text.translatable("advancement.mf.common_flowers.title"),
                Text.translatable("advancement.mf.common_flowers.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_common_flowers", InventoryChangedCriterion.Conditions.items(
                BlocksRegistry.ALSTROEMERIA,
                BlocksRegistry.HYDRANGEA,
                BlocksRegistry.MARIGOLD,
                BlocksRegistry.DAISIES,
                BlocksRegistry.ZINNIA,
                BlocksRegistry.COSMOS,
                BlocksRegistry.PURPLE_CORNFLOWER,
                BlocksRegistry.PETUNIA,
                BlocksRegistry.GERANIUM,
                BlocksRegistry.BEGONIA,
                BlocksRegistry.SNAPDRAGON
            ))
            .build(consumer, ManyFlowers.MOD_ID + ":get_common_flowers")

        val uncommonFlowers = Advancement.Builder.create()
            .parent(root)
            .display(
                BlocksRegistry.COREOPSIS,
                Text.translatable("advancement.mf.uncommon_flowers.title"),
                Text.translatable("advancement.mf.uncommon_flowers.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("give_uncommon_flowers", TickCriterion.Conditions.createTick())
            .build(consumer, ManyFlowers.MOD_ID + ":gave_uncommon_flowers")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.SWEET_ALYSSUM,
                Text.translatable("block.many_flowers.sweet_alyssum"),
                Text.translatable("advancement.mf.sweet_alyssum"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_sweet_alyssum", InventoryChangedCriterion.Conditions.items(BlocksRegistry.SWEET_ALYSSUM))
            .build(consumer, ManyFlowers.MOD_ID + ":get_sweet_alyssum")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.GAILLARDIA,
                Text.translatable("block.many_flowers.gaillardia"),
                Text.translatable("advancement.mf.gaillardia"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_gaillardia", InventoryChangedCriterion.Conditions.items(BlocksRegistry.GAILLARDIA))
            .build(consumer, ManyFlowers.MOD_ID + ":get_gaillardia")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.ORIENTAL_POPPY,
                Text.translatable("block.many_flowers.oriental_poppy"),
                Text.translatable("advancement.mf.oriental_poppy"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_oriental_poppy", InventoryChangedCriterion.Conditions.items(BlocksRegistry.ORIENTAL_POPPY))
            .build(consumer, ManyFlowers.MOD_ID + ":get_oriental_poppy")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.WATER_HEMLOCK,
                Text.translatable("block.many_flowers.water_hemlock"),
                Text.translatable("advancement.mf.water_hemlock"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_water_hemlock", InventoryChangedCriterion.Conditions.items(BlocksRegistry.WATER_HEMLOCK))
            .build(consumer, ManyFlowers.MOD_ID + ":get_water_hemlock")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.OENOTHERA,
                Text.translatable("block.many_flowers.oenothera"),
                Text.translatable("advancement.mf.oenothera"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_oenothera", InventoryChangedCriterion.Conditions.items(BlocksRegistry.OENOTHERA))
            .build(consumer, ManyFlowers.MOD_ID + ":get_oenothera")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.CHRYSANTHEMUM,
                Text.translatable("block.many_flowers.chrysanthemum"),
                Text.translatable("advancement.mf.chrysanthemum"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_chrysanthemum", InventoryChangedCriterion.Conditions.items(BlocksRegistry.CHRYSANTHEMUM))
            .build(consumer, ManyFlowers.MOD_ID + ":get_chrysanthemum")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.AUTUMN_CROCUS,
                Text.translatable("block.many_flowers.autumn_crocus"),
                Text.translatable("advancement.mf.autumn_crocus"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_autumn_crocus", InventoryChangedCriterion.Conditions.items(BlocksRegistry.AUTUMN_CROCUS))
            .build(consumer, ManyFlowers.MOD_ID + ":get_autumn_crocus")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.BLACK_EYED_SUSAN,
                Text.translatable("block.many_flowers.black_eyed_susan"),
                Text.translatable("advancement.mf.black_eyed_susan"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_black_eyed_susan", InventoryChangedCriterion.Conditions.items(BlocksRegistry.BLACK_EYED_SUSAN))
            .build(consumer, ManyFlowers.MOD_ID + ":get_black_eyed_susan")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.COREOPSIS,
                Text.translatable("block.many_flowers.coreopsis"),
                Text.translatable("advancement.mf.coreopsis"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_coreopsis", InventoryChangedCriterion.Conditions.items(BlocksRegistry.COREOPSIS))
            .build(consumer, ManyFlowers.MOD_ID + ":get_coreopsis")

        Advancement.Builder.create()
            .parent(uncommonFlowers)
            .display(
                BlocksRegistry.LAVENDER,
                Text.translatable("block.many_flowers.lavender"),
                Text.translatable("advancement.mf.lavender"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_lavender", InventoryChangedCriterion.Conditions.items(BlocksRegistry.LAVENDER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_lavender")

        val rareFlowers = Advancement.Builder.create()
            .parent(root)
            .display(
                BlocksRegistry.VELVETS,
                Text.translatable("advancement.mf.rare_flowers.title"),
                Text.translatable("advancement.mf.rare_flowers.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("give_rare_flowers", TickCriterion.Conditions.createTick())
            .build(consumer, ManyFlowers.MOD_ID + ":gave_rare_flowers")

        Advancement.Builder.create()
            .parent(rareFlowers)
            .display(
                BlocksRegistry.VELVETS,
                Text.translatable("block.many_flowers.velvets"),
                Text.translatable("advancement.mf.velvets"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_velvets", InventoryChangedCriterion.Conditions.items(BlocksRegistry.VELVETS))
            .build(consumer, ManyFlowers.MOD_ID + ":get_velvets")

        Advancement.Builder.create()
            .parent(rareFlowers)
            .display(
                BlocksRegistry.AUTUMN_ASTERS,
                Text.translatable("block.many_flowers.autumn_asters"),
                Text.translatable("advancement.mf.autumn_asters"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_autumn_asters", InventoryChangedCriterion.Conditions.items(BlocksRegistry.AUTUMN_ASTERS))
            .build(consumer, ManyFlowers.MOD_ID + ":get_autumn_asters")

        Advancement.Builder.create()
            .parent(rareFlowers)
            .display(
                BlocksRegistry.BONE_FLOWER,
                Text.translatable("block.many_flowers.bone_flower"),
                Text.translatable("advancement.mf.bone_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_bone_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.BONE_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_bone_flower")

        Advancement.Builder.create()
            .parent(rareFlowers)
            .display(
                BlocksRegistry.TRADE_FLOWER,
                Text.translatable("block.many_flowers.trade_flower"),
                Text.translatable("advancement.mf.trade_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_trade_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.TRADE_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_trade_flower")

        val oreFlowers = Advancement.Builder.create()
            .parent(root)
            .display(
                BlocksRegistry.GOLD_FLOWER,
                Text.translatable("advancement.mf.ore_flowers.title"),
                Text.translatable("advancement.mf.ore_flowers.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("give_ore_flowers", TickCriterion.Conditions.createTick())
            .build(consumer, ManyFlowers.MOD_ID + ":gave_ore_flowers")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.COAL_FLOWER,
                Text.translatable("block.many_flowers.coal_flower"),
                Text.translatable("advancement.mf.coal_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_coal_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.COAL_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_coal_flower")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.COPPER_FLOWER,
                Text.translatable("block.many_flowers.copper_flower"),
                Text.translatable("advancement.mf.copper_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_copper_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.COPPER_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_copper_flower")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.IRON_FLOWER,
                Text.translatable("block.many_flowers.iron_flower"),
                Text.translatable("advancement.mf.iron_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_iron_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.IRON_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_iron_flower")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.GOLD_FLOWER,
                Text.translatable("block.many_flowers.gold_flower"),
                Text.translatable("advancement.mf.gold_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_gold_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.GOLD_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_gold_flower")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.DIAMOND_FLOWER,
                Text.translatable("block.many_flowers.diamond_flower"),
                Text.translatable("advancement.mf.diamond_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_diamond_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.DIAMOND_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_diamond_flower")

        Advancement.Builder.create()
            .parent(oreFlowers)
            .display(
                BlocksRegistry.EMERALD_FLOWER,
                Text.translatable("block.many_flowers.emerald_flower"),
                Text.translatable("advancement.mf.emerald_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_emerald_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.EMERALD_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_emerald_flower")

        val epicFlowers = Advancement.Builder.create()
            .parent(root)
            .display(
                BlocksRegistry.ETHEREAL_ORCHID,
                Text.translatable("advancement.mf.epic_flowers.title"),
                Text.translatable("advancement.mf.epic_flowers.description"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("give_epic_flowers", TickCriterion.Conditions.createTick())
            .build(consumer, ManyFlowers.MOD_ID + ":gave_epic_flowers")

        Advancement.Builder.create()
            .parent(epicFlowers)
            .display(
                BlocksRegistry.JACK_FLOWER,
                Text.translatable("block.many_flowers.jack_flower"),
                Text.translatable("advancement.mf.jack_flower"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_jack_flower", InventoryChangedCriterion.Conditions.items(BlocksRegistry.JACK_FLOWER))
            .build(consumer, ManyFlowers.MOD_ID + ":get_jack_flower")

        Advancement.Builder.create()
            .parent(epicFlowers)
            .display(
                BlocksRegistry.ROOT_OF_THE_WORLDS,
                Text.translatable("block.many_flowers.root_of_the_worlds"),
                Text.translatable("advancement.mf.root_of_the_worlds"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_root_of_the_worlds", InventoryChangedCriterion.Conditions.items(BlocksRegistry.ROOT_OF_THE_WORLDS))
            .build(consumer, ManyFlowers.MOD_ID + ":get_root_of_the_worlds")

        Advancement.Builder.create()
            .parent(epicFlowers)
            .display(
                BlocksRegistry.ETHEREAL_ORCHID,
                Text.translatable("block.many_flowers.ethereal_orchid"),
                Text.translatable("advancement.mf.ethereal_orchid"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_ethereal_orchid", InventoryChangedCriterion.Conditions.items(BlocksRegistry.ETHEREAL_ORCHID))
            .build(consumer, ManyFlowers.MOD_ID + ":get_ethereal_orchid")

        Advancement.Builder.create()
            .parent(epicFlowers)
            .display(
                BlocksRegistry.DREADPETAL,
                Text.translatable("block.many_flowers.dreadpetal"),
                Text.translatable("advancement.mf.dreadpetal"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_dreadpetal", InventoryChangedCriterion.Conditions.items(BlocksRegistry.DREADPETAL))
            .build(consumer, ManyFlowers.MOD_ID + ":get_dreadpetal")

        Advancement.Builder.create()
            .parent(epicFlowers)
            .display(
                BlocksRegistry.BLINDBLOSSOM,
                Text.translatable("block.many_flowers.blindblossom"),
                Text.translatable("advancement.mf.blindblossom"),
                null,
                AdvancementFrame.TASK,
                true,
                false,
                false
            )
            .criterion("got_blindblossom", InventoryChangedCriterion.Conditions.items(BlocksRegistry.BLINDBLOSSOM))
            .build(consumer, ManyFlowers.MOD_ID + ":get_blindblossom")
    }
}