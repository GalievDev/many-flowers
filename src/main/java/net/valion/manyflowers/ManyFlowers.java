package net.valion.manyflowers;

import dev.syoritohatsuki.duckyupdater.DuckyUpdater;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.config.MFConfig;
import net.valion.manyflowers.helpers.WorldsHelper;
import net.valion.manyflowers.particle.FlowerParticles;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.ItemGroupSetup;
import net.valion.manyflowers.setup.ItemsReg;
import net.valion.manyflowers.setup.OreFlowers;
import net.valion.manyflowers.world.gen.ModWorldGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ManyFlowers implements ModInitializer {
    public static MFConfig CONFIG;
    public static final String MOD_ID = "many_flowers";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Map<BlockPos, Integer> blockChanges = new HashMap<>();

    @Override
    public void onInitialize() {
        ItemGroupSetup.registerItemGroups();
        ItemsReg.registerModItems();
        Flowers.registerModBlocks();
        OreFlowers.registerModBlocks();
        FlowerParticles.registerParticles();

        AutoConfig.register(MFConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(MFConfig.class).getConfig();

        ModWorldGen.generateModWorldGen();

        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            server.getWorlds().forEach(WorldsHelper::putWorld);
            var world = server.getWorld(World.OVERWORLD);

            for (Map.Entry<BlockPos, Integer> entry : blockChanges.entrySet()) {
                var pos = entry.getKey();
                var ticksRemaining = entry.getValue();
                assert world != null;
                var block = world.getBlockState(pos).getBlock();

                if (ticksRemaining <= 0) {
                    if (block == Blocks.GRASS_BLOCK) {
                        world.setBlockState(pos, Blocks.CRIMSON_NYLIUM.getDefaultState());
                    } else if (block == Blocks.DIRT) {
                        world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
                    } else if (block == Blocks.STONE) {
                        world.setBlockState(pos, Blocks.BASALT.getDefaultState());
                    }
                    blockChanges.remove(pos);
                } else {
                    entry.setValue(ticksRemaining - 1);
                }
            }
        });
        DuckyUpdater.checkForUpdate("QUH6A4xu", MOD_ID);
    }
}
