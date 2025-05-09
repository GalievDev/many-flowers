package net.valion.manyflowers.registry

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.valion.manyflowers.entity.BlindblossomEntity
import net.valion.manyflowers.entity.DreadpetalEntity

object EntityAttributesRegistry {
    init {
        FabricDefaultAttributeRegistry.register(
            EntitiesTypeRegistry.DREADPETAL_ENTITY,
            DreadpetalEntity.createAttributes()
        )
        FabricDefaultAttributeRegistry.register(
            EntitiesTypeRegistry.BLINDBLOSSOM_ENTITY,
            BlindblossomEntity.createAttributes()
        )
    }
}