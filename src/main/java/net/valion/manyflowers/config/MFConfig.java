package net.valion.manyflowers.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "many_flowers")
public class MFConfig implements ConfigData {
    public static boolean turn_off_damage_gaillardia = true;
    public static boolean turn_off_damage_hemlock = true;
    public static boolean turn_off_damage_oenothera = true;
    public static boolean turn_off_teleport_ROTW = true;
    public static boolean turn_off_explosion_oriental_poppy = true;
}
