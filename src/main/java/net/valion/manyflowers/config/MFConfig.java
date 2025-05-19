package net.valion.manyflowers.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.TickBoxControllerBuilderImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
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

    public static Screen createScreen(Screen parent) {
        return YetAnotherConfigLib.create(HANDLER, ((defaults, config, builder) -> builder
                .title(Text.of("Many Flowers"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Flowers configuration"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Uncommon flowers"))
                                .description(OptionDescription.of(Text.literal("Configure flowers with simple effects")))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Damage from Gaillardia"))
                                        .binding(true, () -> config.damage_gaillardia, newVal -> config.damage_gaillardia = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Oriental Poppy explosion"))
                                        .binding(true, () -> config.explosion_oriental_poppy, newVal -> config.explosion_oriental_poppy = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Poison from Water Hemlock"))
                                        .binding(true, () -> config.damage_hemlock, newVal -> config.damage_hemlock = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Damage from Oenothera"))
                                        .binding(true, () -> config.damage_oenothera, newVal -> config.damage_oenothera = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Healing from Chrysanthemum"))
                                        .binding(true, () -> config.regen_chrysanthemum, newVal -> config.regen_chrysanthemum = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Sounds from Autumn Crocus"))
                                        .binding(true, () -> config.sound_crocus, newVal -> config.sound_crocus = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Rare flowers"))
                                .description(OptionDescription.of(Text.literal("Configure flowers with specific abilities")))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Nether infection from Velvets"))
                                        .binding(true, () -> config.nether_velvets, newVal -> config.nether_velvets = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Stealing items from Autumn Crocus"))
                                        .binding(true, () -> config.still_asters, newVal -> config.still_asters = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Epic flowers"))
                                .description(OptionDescription.of(Text.literal("Configure most strength flowers")))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.literal("Teleport to random world Root Of The Worlds"))
                                        .binding(true, () -> config.teleport_ROTW, newVal -> config.teleport_ROTW = newVal)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .build()))).generateScreen(parent);
    }
}
