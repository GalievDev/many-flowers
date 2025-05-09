package net.valion.manyflowers.event

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.server.MinecraftServer
import net.valion.manyflowers.helpers.SoundsHelper
import net.valion.manyflowers.helpers.TagToBlocksHelper
import net.valion.manyflowers.helpers.WorldsHelper

object ServerStartEvent: ServerLifecycleEvents.ServerStarted {
    override fun onServerStarted(server: MinecraftServer) {
        server.worlds.forEach(WorldsHelper::putWorld)
        SoundsHelper.putSounds()
        TagToBlocksHelper.init()
    }
}