package net.valion.manyflowers.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "many_flowers")
public class MFConfig implements ConfigData {
    public boolean damage_gaillardia = true;
    public boolean damage_hemlock = true;
    public boolean damage_oenothera = true;
    public boolean teleport_ROTW = false;
    public boolean explosion_oriental_poppy = true;
    public boolean regen_chrysanthemum = true;
    public boolean still_asters = true;
    public boolean sound_crocus = true;
    public boolean nether_velvets = true;
}
