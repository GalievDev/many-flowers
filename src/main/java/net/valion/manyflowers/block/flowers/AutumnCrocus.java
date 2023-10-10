package net.valion.manyflowers.block.flowers;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.helpers.SoundsHelper;

public class AutumnCrocus extends FlowerBlock {
    public static final int delay = 700;
    public static int counter = 0;
    public AutumnCrocus() {
        super(StatusEffects.ABSORPTION, 0, FabricBlockSettings.copy(Blocks.DANDELION));
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (counter < 0) counter = 0;
        if (counter == delay) {
            ManyFlowers.LOGGER.info("2");
            if (!SoundsHelper.sounds.isEmpty()) {
                ManyFlowers.LOGGER.info("3");
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundsHelper.getRandSound(), SoundCategory.HOSTILE, 2F, 0F, true);
            } else {
                SoundsHelper.putSounds();
                ManyFlowers.LOGGER.info("4");
            }
            counter = 0;
        } else counter++;
    }
}
