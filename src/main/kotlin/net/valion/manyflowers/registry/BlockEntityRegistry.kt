package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers.MOD_ID
import net.valion.manyflowers.block.flowers.entity.AutumnAstersEntity
import net.valion.manyflowers.block.flowers.entity.VelvetsBlockEntity

object BlockEntityRegistry {

    val VELVETS_ENTITY: BlockEntityType<VelvetsBlockEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "velvets_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::VelvetsBlockEntity, FlowerRegistry.VELVETS
        ).build()
    )

    val AUTUMN_ASTERS_ENTITY: BlockEntityType<AutumnAstersEntity> = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of(MOD_ID, "autumn_asters_entity"),
        FabricBlockEntityTypeBuilder.create(
            ::AutumnAstersEntity, FlowerRegistry.AUTUMN_ASTERS
        ).build()
    )
}