package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers.MOD_ID
import net.valion.manyflowers.block.flowers.entity.AutumnAstersEntity
import net.valion.manyflowers.block.flowers.entity.DahliaBlockEntity
import net.valion.manyflowers.block.flowers.entity.LavenderBlockEntity
import net.valion.manyflowers.block.flowers.entity.TradeFlowerBlockEntity
import net.valion.manyflowers.block.flowers.entity.VelvetsBlockEntity

object BlocksEntitiesRegistry {

    val VELVETS_ENTITY: BlockEntityType<VelvetsBlockEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "velvets_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::VelvetsBlockEntity, BlocksRegistry.VELVETS
        ).build()
    )

    val AUTUMN_ASTERS_ENTITY: BlockEntityType<AutumnAstersEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "autumn_asters_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::AutumnAstersEntity, BlocksRegistry.AUTUMN_ASTERS
        ).build()
    )

    val TRADE_FLOWER_ENTITY: BlockEntityType<TradeFlowerBlockEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "trade_flower_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::TradeFlowerBlockEntity, BlocksRegistry.TRADE_FLOWER
        ).build()
    )

    val DAHLIA_ENTITY: BlockEntityType<DahliaBlockEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "dahlia_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::DahliaBlockEntity, BlocksRegistry.DAHLIA
        ).build()
    )

    val LAVENDER_ENTITY: BlockEntityType<LavenderBlockEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "lavender_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::LavenderBlockEntity, BlocksRegistry.LAVENDER
        ).build()
    )
}