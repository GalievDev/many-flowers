package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.block.TallPlantBlock
import net.minecraft.block.enums.DoubleBlockHalf
import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.BlockStatePropertyLootCondition
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.predicate.StatePredicate
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.valion.manyflowers.block.plant.*
import net.valion.manyflowers.registry.BlocksRegistry
import net.valion.manyflowers.registry.ItemsRegistry
import java.util.concurrent.CompletableFuture

class ModLootTablesProvider(
    dataOutput: FabricDataOutput,
    registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricBlockLootTableProvider(dataOutput, registryLookup) {

    override fun generate() {
        val enchantmentWrapper = registries.getOrThrow(RegistryKeys.ENCHANTMENT)

        addDrop(BlocksRegistry.ALSTROEMERIA)
        addDrop(BlocksRegistry.HYDRANGEA)
        addDrop(BlocksRegistry.MARIGOLD)
        addDrop(BlocksRegistry.DAISIES)
        addDrop(BlocksRegistry.ZINNIA) { block ->
            dropsWithProperty(
                block,
                TallPlantBlock.HALF,
                DoubleBlockHalf.LOWER
            )
        }

        addDrop(BlocksRegistry.SWEET_ALYSSUM)
        addDrop(BlocksRegistry.GAILLARDIA)
        addDrop(BlocksRegistry.ORIENTAL_POPPY)
        addDrop(BlocksRegistry.WATER_HEMLOCK)
        addDrop(BlocksRegistry.OENOTHERA) { block ->
            dropsWithProperty(
                block,
                TallPlantBlock.HALF,
                DoubleBlockHalf.LOWER
            )
        }

        addDrop(BlocksRegistry.CHRYSANTHEMUM)
        addDrop(BlocksRegistry.AUTUMN_CROCUS)
        addDrop(BlocksRegistry.VELVETS)
        addDrop(BlocksRegistry.AUTUMN_ASTERS) { block ->
            dropsWithProperty(
                block,
                TallPlantBlock.HALF,
                DoubleBlockHalf.LOWER
            )
        }

        addDrop(BlocksRegistry.COAL_FLOWER)
        addDrop(BlocksRegistry.COPPER_FLOWER)
        addDrop(BlocksRegistry.IRON_FLOWER)
        addDrop(BlocksRegistry.GOLD_FLOWER)
        addDrop(BlocksRegistry.DIAMOND_FLOWER)
        addDrop(BlocksRegistry.EMERALD_FLOWER)

        addDrop(BlocksRegistry.JACK_FLOWER)
        addDrop(BlocksRegistry.ROOT_OF_THE_WORLDS)

        addPottedPlantDrops(BlocksRegistry.POTTED_ALSTROEMERIA)
        addPottedPlantDrops(BlocksRegistry.POTTED_HYDRANGEA)
        addPottedPlantDrops(BlocksRegistry.POTTED_MARIGOLD)
        addPottedPlantDrops(BlocksRegistry.POTTED_DAISES)
        addPottedPlantDrops(BlocksRegistry.POTTED_SWEET_ALYSSUM)
        addPottedPlantDrops(BlocksRegistry.POTTED_GAILLARDIA)
        addPottedPlantDrops(BlocksRegistry.POTTED_ORIENTAL_POPPY)
        addPottedPlantDrops(BlocksRegistry.POTTED_WATER_HEMLOCK)
        addPottedPlantDrops(BlocksRegistry.POTTED_CHRYSANTHEMUM)
        addPottedPlantDrops(BlocksRegistry.POTTED_AUTUMN_CROCUS)
        addPottedPlantDrops(BlocksRegistry.POTTED_ROOT_OF_THE_WORLDS)

        addCropLoot(
            BlocksRegistry.COAL_PLANT,
            ItemsRegistry.COAL_SEEDS,
            ItemsRegistry.COAL_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.COAL_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(CoalPlant.AGE, 7))
        )
        addCropLoot(
            BlocksRegistry.COPPER_PLANT,
            ItemsRegistry.COPPER_SEEDS,
            ItemsRegistry.COPPER_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.COPPER_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(CopperPlant.AGE, 7))
        )
        addCropLoot(
            BlocksRegistry.IRON_PLANT,
            ItemsRegistry.IRON_SEEDS,
            ItemsRegistry.IRON_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.IRON_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(IronPlant.AGE, 7))
        )
        addCropLoot(
            BlocksRegistry.GOLD_PLANT,
            ItemsRegistry.GOLD_SEEDS,
            ItemsRegistry.GOLD_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.GOLD_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(GoldPlant.AGE, 7))
        )
        addCropLoot(
            BlocksRegistry.DIAMOND_PLANT,
            ItemsRegistry.DIAMOND_SEEDS,
            ItemsRegistry.DIAMOND_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.DIAMOND_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(DiamondPlant.AGE, 7))
        )
        addCropLoot(
            BlocksRegistry.EMERALD_PLANT,
            ItemsRegistry.EMERALD_SEEDS,
            ItemsRegistry.EMERALD_PETAL,
            enchantmentWrapper,
            BlockStatePropertyLootCondition.builder(BlocksRegistry.EMERALD_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(EmeraldPlant.AGE, 7))
        )

        addDrop(BlocksRegistry.COAL_PETAL_BLOCK)
        addDrop(BlocksRegistry.COPPER_PETAL_BLOCK)
        addDrop(BlocksRegistry.IRON_PETAL_BLOCK)
        addDrop(BlocksRegistry.GOLD_PETAL_BLOCK)
        addDrop(BlocksRegistry.DIAMOND_PETAL_BLOCK)
        addDrop(BlocksRegistry.EMERALD_PETAL_BLOCK)
    }

    private fun addCropLoot(
        crop: Block,
        seeds: Item,
        drop: Item,
        enchantmentWrapper: RegistryWrapper.Impl<Enchantment>,
        propertyLootCondition: BlockStatePropertyLootCondition.Builder
    ) {
        addDrop(crop, applyExplosionDecay(
            crop,
            LootTable.builder()
                .pool(
                    LootPool.builder()
                        .with(ItemEntry.builder(seeds))
                )
                .pool(
                    LootPool.builder()
                        .conditionally(propertyLootCondition)
                        .with(ItemEntry.builder(drop).apply(
                            ApplyBonusLootFunction.binomialWithBonusCount(
                                enchantmentWrapper.getOrThrow(Enchantments.FORTUNE), 0.2F, 1
                            )
                        ))
                )
                .pool(
                    LootPool.builder()
                        .conditionally(propertyLootCondition)
                        .with(ItemEntry.builder(seeds)
                            .conditionally(RandomChanceLootCondition.builder(0.02F))
                        )
                )
        ))
    }
}