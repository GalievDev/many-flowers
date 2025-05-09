package net.valion.manyflowers

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.valion.manyflowers.config.MFConfig
import net.valion.manyflowers.event.EntityLoadEvent
import net.valion.manyflowers.event.ServerStartEvent
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
        EntityAttributesRegistry

        ServerEntityEvents.ENTITY_LOAD.register(EntityLoadEvent)
        ServerLifecycleEvents.SERVER_STARTED.register(ServerStartEvent)

        MFConfig.HANDLER.load()
        MFConfig.HANDLER.save()

        ModWorldGeneration.generateModWorldGen()
    }
}