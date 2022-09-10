package net.valion.manyflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.valion.manyflowers.setup.Flowers;
import net.valion.manyflowers.setup.OreFlowers;

@Environment(EnvType.CLIENT)
public class ManyFlowersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Flowers.ALSTROEMERIA_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Flowers.HYDRANGEA_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Flowers.MARIGOLD_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.DIAMOND_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.DIAMOND_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.COAL_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.COAL_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.IRON_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.IRON_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.GOLD_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.GOLD_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.EMERALD_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.EMERALD_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.COPPER_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(OreFlowers.COPPER_PLANT, RenderLayer.getCutout());
    }
}
