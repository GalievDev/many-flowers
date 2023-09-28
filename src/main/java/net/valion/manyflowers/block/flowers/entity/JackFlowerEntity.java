package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.block.flowers.JackFlower;
import net.valion.manyflowers.setup.BlockEntitiesReg;

public class JackFlowerEntity extends BlockEntity {
    public JackFlowerEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.JACK_FLOWER_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, JackFlowerEntity entity) {
        //if (world.isClient) return;

//        var time = world.getTime();
        //  ManyFlowers.LOGGER.info("level " + time);
        //      if (time >= 13000) {
        JackFlower.lightness = 9;
        //    }
    }
}
