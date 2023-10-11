package net.valion.manyflowers;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.valion.manyflowers.config.MFConfig;
import net.valion.manyflowers.helpers.SoundsHelper;
import net.valion.manyflowers.helpers.WorldsHelper;
import net.valion.manyflowers.particle.FlowerParticles;
import net.valion.manyflowers.setup.BlockEntitiesReg;
import net.valion.manyflowers.setup.ItemGroupSetup;
import net.valion.manyflowers.setup.ItemsReg;
import net.valion.manyflowers.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManyFlowers implements ModInitializer {
    public static MFConfig CONFIG;
    public static final String MOD_ID = "many_flowers";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemGroupSetup.registerItemGroups();
        ItemsReg.registerModItems();
        FlowerParticles.registerParticles();
        BlockEntitiesReg.register();

        AutoConfig.register(MFConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MFConfig.class).getConfig();

        ModWorldGen.generateModWorldGen();

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            SoundsHelper.putSounds();
            server.getWorlds().forEach(WorldsHelper::putWorld);
        });
    }
}
