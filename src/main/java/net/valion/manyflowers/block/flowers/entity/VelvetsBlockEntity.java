package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.setup.BlockEntitiesReg;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VelvetsBlockEntity extends BlockEntity {
    public static ArrayList<BlockPos> poses = new ArrayList<>();
    private final int delay = 20;
    private int counter = 0;

    public VelvetsBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.VELVETS_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, VelvetsBlockEntity entity) {
        if (world.isClient) return;
        if (entity.counter < 0) entity.counter = 0;
        if (entity.counter == entity.delay) {
            if (poses.isEmpty()) {
                if (world.getRegistryKey() == World.OVERWORLD) {
                    for (int x = blockPos.getX() - 1 ; x <= blockPos.getX() + 1; x++) {
                        for (int y = blockPos.getY() - 2; y <= blockPos.getY() - 1; y++) {
                            for (int z = blockPos.getZ() - 1; z <= blockPos.getZ() + 1; z++) {
                                var pos = new BlockPos(x, y, z);
                                poses.add(pos);
                            }
                        }
                    }
                    for (int x = blockPos.getX() - 2 ; x <= blockPos.getX() + 2; x++) {
                        for (int y = blockPos.getY() - 3; y <= blockPos.getY() - 2; y++) {
                            for (int z = blockPos.getZ() - 2; z <= blockPos.getZ() + 2; z++) {
                                var pos = new BlockPos(x, y, z);
                                poses.add(pos);
                            }
                        }
                    }
                }
            } else {
                setBlock(world, poses);
                entity.counter = 0;
            }
        } else entity.counter++;
    }

    private static void setBlock(@NotNull World world, @NotNull List<BlockPos> poses) {
        Random random = new Random(System.currentTimeMillis());
        var pos = poses.get(random.nextInt(poses.size()));
        ManyFlowers.LOGGER.info("Rand pos: " + pos);
        var block = world.getBlockState(pos).getBlock();
        var state = world.getBlockState(pos);
        ManyFlowers.LOGGER.info("Block: " + block);

        if (state.isOf(Blocks.GRASS_BLOCK)) {
            world.setBlockState(pos, Blocks.CRIMSON_NYLIUM.getDefaultState());
        } else if (state.isIn(BlockTags.DIRT)) {
            world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
        } else if (state.isIn(BlockTags.BASE_STONE_OVERWORLD)) {
            world.setBlockState(pos, Blocks.BASALT.getDefaultState());
        } else if (state.isIn(BlockTags.SAND)) {
            world.setBlockState(pos, Blocks.SOUL_SAND.getDefaultState());
        } else if (state.isOf(Blocks.WATER)) {
            world.setBlockState(pos, Blocks.LAVA.getDefaultState());
        } else if (state.isIn(BlockTags.TERRACOTTA)) {
            world.setBlockState(pos, Blocks.SMOOTH_BASALT.getDefaultState());
        } else if (state.isIn(BlockTags.LOGS)) {
            world.setBlockState(pos, Blocks.CRIMSON_STEM.getDefaultState());
        } else if (state.isIn(BlockTags.LEAVES)) {
            world.setBlockState(pos, Blocks.NETHER_WART.getDefaultState());
        }
        poses.clear();
    }
}
