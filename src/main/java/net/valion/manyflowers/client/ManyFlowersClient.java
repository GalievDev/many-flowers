package net.valion.manyflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import net.valion.manyflowers.particle.custom.SweetAlyssumParticles;
import net.valion.manyflowers.registry.BlocksRegistry;
import net.valion.manyflowers.registry.EntitiesTypeRegistry;
import net.valion.manyflowers.registry.ParticlesRegistry;

@Environment(EnvType.CLIENT)
public class ManyFlowersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ParticlesRegistry.INSTANCE.getSWEET_ALYSSUM_PARTICLES(), SweetAlyssumParticles.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getALSTROEMERIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getHYDRANGEA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getMARIGOLD(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getDAISIES(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getZINNIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOSMOS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPURPLE_CORNFLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPETUNIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getGERANIUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getBEGONIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getSNAPDRAGON(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getSWEET_ALYSSUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getGAILLARDIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getORIENTAL_POPPY(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getWATER_HEMLOCK(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getOENOTHERA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCHRYSANTHEMUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getAUTUMN_CROCUS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getBLACK_EYED_SUSAN(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOREOPSIS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getDAHLIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getLAVENDER(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getVELVETS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getAUTUMN_ASTERS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getBONE_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getTRADE_FLOWER(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ALSTROEMERIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_HYDRANGEA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_MARIGOLD(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_PURPLE_CORNFLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_PETUNIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_BEGONIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_SNAPDRAGON(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_BLACK_EYED_SUSAN(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_COREOPSIS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_DAHLIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_LAVENDER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_DAISIES(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_SWEET_ALYSSUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_GAILLARDIA(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ORIENTAL_POPPY(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_CHRYSANTHEMUM(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ROOT_OF_THE_WORLDS(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOAL_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOAL_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOPPER_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getCOPPER_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getIRON_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getIRON_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getGOLD_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getGOLD_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getDIAMOND_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getDIAMOND_PLANT(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getEMERALD_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getEMERALD_PLANT(), RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getJACK_FLOWER(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getROOT_OF_THE_WORLDS(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getETHEREAL_ORCHID(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getDREADPETAL(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlocksRegistry.INSTANCE.getBLINDBLOSSOM(), RenderLayer.getCutout());

        EntityRendererRegistry.register(EntitiesTypeRegistry.INSTANCE.getDREADPETAL_ENTITY(), EmptyRenderer::new);
        EntityRendererRegistry.register(EntitiesTypeRegistry.INSTANCE.getBLINDBLOSSOM_ENTITY(), EmptyRenderer::new);
    }

    private static class EmptyRenderer extends EntityRenderer<Entity, EntityRenderState> {

        protected EmptyRenderer(EntityRendererFactory.Context context) {
            super(context);
        }

        @Override
        public boolean shouldRender(Entity entity, Frustum frustum, double x, double y, double z) {
            return false;
        }

        @Override
        public EntityRenderState createRenderState() {
            return new EntityRenderState();
        }
    }
}
