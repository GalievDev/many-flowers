package net.valion.manyflowers.registry

import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import net.valion.manyflowers.ManyFlowers.MOD_ID
import net.valion.manyflowers.entity.DreadpetalEntity

object EntitiesTypeRegistry {
    val DREADPETAL_ENTITY: EntityType<DreadpetalEntity> = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(MOD_ID, "dreadpetal_entity"),
        EntityType.Builder.create(::DreadpetalEntity, SpawnGroup.MISC)
            .dimensions(0.001F, 0.001F)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, "dreadpetal_entity"))))
}