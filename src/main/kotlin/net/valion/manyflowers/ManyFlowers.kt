package net.valion.manyflowers

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarted
import net.minecraft.server.MinecraftServer
import net.valion.manyflowers.config.MFConfig
import net.valion.manyflowers.helpers.SoundsHelper
import net.valion.manyflowers.helpers.WorldsHelper
import net.valion.manyflowers.registry.BlockEntityRegistry
import net.valion.manyflowers.registry.BlockRegistry
import net.valion.manyflowers.registry.FlowerRegistry
import net.valion.manyflowers.registry.ItemRegistry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object ManyFlowers: ModInitializer {
    const val MOD_ID: String = "many_flowers"
    val CONFIG: MFConfig = MFConfig.HANDLER.instance()
    val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    override fun onInitialize() {
        ItemRegistry
        FlowerRegistry
        BlockRegistry
        BlockEntityRegistry

        MFConfig.HANDLER.load()
        MFConfig.HANDLER.save()

        ServerLifecycleEvents.SERVER_STARTED.register(ServerStarted { server: MinecraftServer ->
            SoundsHelper.putSounds()
            server.worlds.forEach(WorldsHelper::putWorld)
        })
    }
}