package net.valion.manyflowers.config;

import com.mojang.datafixers.util.Pair;
import net.valion.manyflowers.ManyFlowers;

public class MFConfig {
    public static SimpleConfig CONFIG;
    private static MFConfigProvider configProvider;

    public static boolean turn_off_damage_gaillardia;
    public static boolean turn_off_damage_hemlock;
    public static boolean turn_off_damage_oenothera;
    public static boolean turn_off_teleport_ROTW;
    public static boolean turn_off_explosion_oriental_poppy;

    public static void registerConfigs() {
        configProvider = new MFConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(ManyFlowers.MOD_ID + "config").provider(configProvider).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configProvider.addKeyValuePair(new Pair<>("turn_off_damage.gaillardia", false), "boolean");
        configProvider.addKeyValuePair(new Pair<>("turn_off_damage.hemlock", false), "boolean");
        configProvider.addKeyValuePair(new Pair<>("turn_off_damage.oenothera", false), "boolean");
        configProvider.addKeyValuePair(new Pair<>("turn_off_teleport.ROTW", false), "boolean");
        configProvider.addKeyValuePair(new Pair<>("turn_off_explosion.oriental_poppy", false), "boolean");
    }

    private static void assignConfigs() {
        turn_off_damage_gaillardia = CONFIG.getOrDefault("turn_off_damage.gaillardia", false);
        turn_off_damage_hemlock = CONFIG.getOrDefault("turn_off_damage.hemlock", false);
        turn_off_damage_oenothera = CONFIG.getOrDefault("turn_off_damage.hemlock", false);
        turn_off_teleport_ROTW = CONFIG.getOrDefault("turn_off_teleport.ROTW", false);
        turn_off_explosion_oriental_poppy = CONFIG.getOrDefault("turn_off_explosion.oriental_poppy", false);
    }
}
