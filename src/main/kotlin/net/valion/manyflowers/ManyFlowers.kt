package net.valion.manyflowers

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarted
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.minecraft.entity.Entity
import net.minecraft.entity.ai.goal.FleeEntityGoal
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.server.MinecraftServer
import net.minecraft.server.world.ServerWorld
import net.valion.manyflowers.config.MFConfig
import net.valion.manyflowers.entity.DreadpetalEntity
import net.valion.manyflowers.helpers.SoundsHelper
import net.valion.manyflowers.helpers.WorldsHelper
import net.valion.manyflowers.mixin.MobEntityAccessor
import net.valion.manyflowers.registry.*
import net.valion.manyflowers.world.gen.ModWorldGeneration
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import kotlin.random.Random


object ManyFlowers: ModInitializer {
    const val MOD_ID: String = "many_flowers"
    val CONFIG: MFConfig = MFConfig.HANDLER.instance()
    val LOGGER: Logger = LogManager.getLogger(MOD_ID)
    val RANDOM: Random = Random(System.currentTimeMillis())

    override fun onInitialize() {
        ItemsRegistry
        BlocksRegistry
        BlocksEntitiesRegistry
        ParticlesRegistry
        FeaturesRegistry
        SoundsRegistry
        EntitiesTypeRegistry

        FabricDefaultAttributeRegistry.register(EntitiesTypeRegistry.DREADPETAL_ENTITY, DreadpetalEntity.createAttributes())

        ServerEntityEvents.ENTITY_LOAD.register(ServerEntityEvents.Load { entity: Entity?, world: ServerWorld? ->
            if (entity is HostileEntity) {
                (entity as MobEntityAccessor).goalSelector.add(1, FleeEntityGoal(entity,
                    DreadpetalEntity::class.java, 5.0f, 1.2, 1.5))
            }
        })

        MFConfig.HANDLER.load()
        MFConfig.HANDLER.save()

        ModWorldGeneration.generateModWorldGen()

        ServerLifecycleEvents.SERVER_STARTED.register(ServerStarted { server: MinecraftServer ->
            SoundsHelper.putSounds()
            server.worlds.forEach(WorldsHelper::putWorld)
        })
    }
}