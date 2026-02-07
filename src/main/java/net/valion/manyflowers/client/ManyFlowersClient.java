package net.valion.manyflowers.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.Frustum;
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

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getALSTROEMERIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getHYDRANGEA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getMARIGOLD(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getDAISIES(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getZINNIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOSMOS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPURPLE_CORNFLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPETUNIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getGERANIUM(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getBEGONIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getSNAPDRAGON(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getSWEET_ALYSSUM(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getGAILLARDIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getORIENTAL_POPPY(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getWATER_HEMLOCK(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getOENOTHERA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCHRYSANTHEMUM(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getAUTUMN_CROCUS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getBLACK_EYED_SUSAN(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOREOPSIS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getDAHLIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getLAVENDER(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getVELVETS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getAUTUMN_ASTERS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getBONE_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getTRADE_FLOWER(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ALSTROEMERIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_HYDRANGEA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_MARIGOLD(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_PURPLE_CORNFLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_PETUNIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_BEGONIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_SNAPDRAGON(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_BLACK_EYED_SUSAN(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_COREOPSIS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_DAHLIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_LAVENDER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_DAISIES(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_SWEET_ALYSSUM(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_GAILLARDIA(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ORIENTAL_POPPY(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_CHRYSANTHEMUM(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getPOTTED_ROOT_OF_THE_WORLDS(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOAL_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOAL_PLANT(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOPPER_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getCOPPER_PLANT(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getIRON_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getIRON_PLANT(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getGOLD_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getGOLD_PLANT(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getDIAMOND_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getDIAMOND_PLANT(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getEMERALD_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getEMERALD_PLANT(), BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getJACK_FLOWER(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getROOT_OF_THE_WORLDS(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getETHEREAL_ORCHID(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getDREADPETAL(), BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(BlocksRegistry.INSTANCE.getBLINDBLOSSOM(), BlockRenderLayer.CUTOUT);

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
