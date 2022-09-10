package net.valion.manyflowers;

import net.fabricmc.api.ModInitializer;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.OreFlowers;
import net.valion.manyflowers.setup.ItemsReg;
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

        ModConfiguredFeatures.registerConfiguredFeatures();

        ModWorldGen.generateModWorldGen();
    }
}
