package net.valion.manyflowers.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "many_flowers")
public class MFConfig implements ConfigData {
    public boolean damage_gaillardia = true;
    public boolean damage_hemlock = true;
    public boolean damage_oenothera = true;
    public boolean teleport_ROTW = true;
    public boolean explosion_oriental_poppy = true;
}
