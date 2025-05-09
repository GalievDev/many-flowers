package net.valion.manyflowers.event

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents
import net.minecraft.entity.Entity
import net.minecraft.entity.ai.goal.FleeEntityGoal
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.server.world.ServerWorld
import net.valion.manyflowers.entity.DreadpetalEntity
import net.valion.manyflowers.entity.goal.BlindblossomGoal
import net.valion.manyflowers.mixin.MobEntityAccessor

object EntityLoadEvent: ServerEntityEvents.Load {
    override fun onLoad(entity: Entity?, world: ServerWorld?) {
        if (entity is HostileEntity) {
            (entity as MobEntityAccessor).goalSelector.add(
                1, FleeEntityGoal(
                    entity,
                    DreadpetalEntity::class.java, 5.0f, 1.2, 1.5
                )
            )
            (entity as MobEntityAccessor).goalSelector.add(
                1, BlindblossomGoal(
                    entity, 1.0, 5.0f
                )
            )
        }
    }
}