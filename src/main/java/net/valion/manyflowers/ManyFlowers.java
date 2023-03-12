package net.valion.manyflowers;

import dev.syoritohatsuki.duckyupdater.DuckyUpdater;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.valion.manyflowers.config.MFConfig;
import net.valion.manyflowers.helpers.WorldsHelper;
import net.valion.manyflowers.particle.FlowerParticles;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.ItemGroupSetup;
import net.valion.manyflowers.setup.ItemsReg;
import net.valion.manyflowers.setup.OreFlowers;
import net.valion.manyflowers.world.feature.ModConfiguredFeatures;
import net.valion.manyflowers.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManyFlowers implements ModInitializer {
    public static final String MOD_ID = "many_flowers";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemsReg.registerModItems();
        Flowers.registerModBlocks();
        OreFlowers.registerModBlocks();
        FlowerParticles.registerParticles();
        ItemGroupSetup.registerItemGroups();

        AutoConfig.register(MFConfig.class, GsonConfigSerializer::new);

        ModConfiguredFeatures.registerConfiguredFeatures();

        ModWorldGen.generateModWorldGen();

        ServerLifecycleEvents.SERVER_STARTED.register(server ->
                server.getWorlds().forEach(WorldsHelper::putWorld)
        );

        DuckyUpdater.checkForUpdate("QUH6A4xu", MOD_ID);
    }
}
