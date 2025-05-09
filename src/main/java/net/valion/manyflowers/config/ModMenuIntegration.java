package net.valion.manyflowers.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.valion.manyflowers.ManyFlowers;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> ManyFlowers.INSTANCE.getCONFIG().createScreen().generateScreen(parentScreen);
    }
}
