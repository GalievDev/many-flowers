package net.valion.manyflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.render.RenderLayer;
import net.valion.manyflowers.particle.FlowerParticles;
import net.valion.manyflowers.particle.custom.SweetAlyssumParticles;
import net.valion.manyflowers.registry.BlockRegistry;
import net.valion.manyflowers.registry.FlowerRegistry;

@Environment(EnvType.CLIENT)
public class ManyFlowersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(FlowerParticles.SWEET_ALYSSUM_PARTICLES, SweetAlyssumParticles.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getALSTROEMERIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getHYDRANGEA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getMARIGOLD(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getDAISES(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getZINNIA(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getSWEET_ALYSSUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getGAILLARDIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getORIENTAL_POPPY(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getWATER_HEMLOCK(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getOENOTHERA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getCHRYSANTHEMUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getAUTUMN_CROCUS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getVELVETS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getAUTUMN_ASTERS(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getCOAL_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getCOAL_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getCOPPER_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getCOPPER_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getIRON_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getIRON_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getGOLD_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getGOLD_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getDIAMOND_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getDIAMOND_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getEMERALD_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.INSTANCE.getEMERALD_PLANT(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getJACK_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(FlowerRegistry.INSTANCE.getROOT_OF_THE_WORLDS(), RenderLayer.getCutout());

    }
}
