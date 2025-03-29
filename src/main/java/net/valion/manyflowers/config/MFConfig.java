package net.valion.manyflowers.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.valion.manyflowers.ManyFlowers;

public class MFConfig {
    public static ConfigClassHandler<MFConfig> HANDLER = ConfigClassHandler.createBuilder(MFConfig.class)
            .id(Identifier.of(ManyFlowers.MOD_ID, "many_flowers"))
                    .serializer(config -> GsonConfigSerializerBuilder.create(config)
                            .setPath(FabricLoader.getInstance().getConfigDir().resolve("many_flowers.json5"))
                            .setJson5(true)
                            .build())
                    .build();

    @SerialEntry
    public boolean damage_gaillardia = true;
    @SerialEntry
    public boolean damage_hemlock = true;
    @SerialEntry
    public boolean damage_oenothera = true;
    @SerialEntry
    public boolean teleport_ROTW = true;
    @SerialEntry
    public boolean explosion_oriental_poppy = true;
    @SerialEntry
    public boolean regen_chrysanthemum = true;
    @SerialEntry
    public boolean still_asters = true;
    @SerialEntry
    public boolean sound_crocus = true;
    @SerialEntry
    public boolean nether_velvets = true;
}
