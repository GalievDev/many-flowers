package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.helpers.SoundsHelper;
import net.valion.manyflowers.setup.BlockEntitiesReg;

import java.util.HashMap;
import java.util.Map;

public class AutumnCrocusEntity extends BlockEntity {
    public static Map<String, Integer> ids = new HashMap<>();
    public static final int delay = 1000;
    public static int counter = 0;
    public AutumnCrocusEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.AUTUMN_CROCUS_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AutumnCrocusEntity entity) {
        if (world.isClient) return;
        if (counter < 0) counter = 0;

        if (counter == delay) {
            if (!SoundsHelper.sounds.isEmpty()) {
                world.playSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundsHelper.getRandSound(), SoundCategory.HOSTILE, 2F, 0F, true);
            }
            counter = 0;
        } else counter++;
    }
}
