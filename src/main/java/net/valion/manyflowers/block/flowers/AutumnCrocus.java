package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.helpers.SoundsHelper;

public class AutumnCrocus extends BaseFlower {
    private final static MapCodec<AutumnCrocus> CODEC = createCodec(AutumnCrocus::new);
    public static final int delay = 700;
    public static int counter = 0;

    public AutumnCrocus(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (counter < 0) counter = 0;
        if (!ManyFlowers.CONFIG.sound_crocus) return;
        if (counter == delay) {
            if (!SoundsHelper.sounds.isEmpty() && world.isClient) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundsHelper.getRandSound(), SoundCategory.HOSTILE, 2F, 0F, true);
            } else {
                SoundsHelper.putSounds();
            }
            counter = 0;
        } else counter++;
    }
}
