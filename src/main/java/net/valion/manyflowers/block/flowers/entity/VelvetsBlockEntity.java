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
    private final int delay = 100;
    private int counter = 0;

    public VelvetsBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.VELVETS_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, VelvetsBlockEntity entity) {
        if (entity.counter < 0) entity.counter = 0;
        if (entity.counter == entity.delay) {
            if (poses.isEmpty()) {
                 if (world.getRegistryKey() == World.OVERWORLD) {
                    for (int x = -2; x <= 2; x++) {
                        for (int y = -1; y <= 1; y++) {
                            for (int z = -2; z <= 2; z++) {
                                var targetPos = blockPos.add(x, y, z);
                                poses.add(targetPos);
                            }
                        }
                    }
                }
            } else {
                setBlock(world, poses);
                entity.counter = 0;
            }
        }
        entity.counter++;
    }

    private static void setBlock(@NotNull World world, @NotNull List<BlockPos> poses) {
        Random random = new Random();
        var randPos = poses.get(random.nextInt(poses.size()));
        ManyFlowers.LOGGER.info("Rand pos: " + randPos);
        var block = world.getBlockState(randPos).getBlock();
        var state = world.getBlockState(randPos);
        ManyFlowers.LOGGER.info("Block: " + block);

        if (state.isOf(Blocks.GRASS_BLOCK)) {
            world.setBlockState(randPos, Blocks.CRIMSON_NYLIUM.getDefaultState());
        } else if (state.isIn(BlockTags.DIRT)) {
            world.setBlockState(randPos, Blocks.NETHERRACK.getDefaultState());
        } else if (state.isIn(BlockTags.BASE_STONE_OVERWORLD)) {
            world.setBlockState(randPos, Blocks.BASALT.getDefaultState());
        } else if (state.isIn(BlockTags.SAND)) {
            world.setBlockState(randPos, Blocks.SOUL_SAND.getDefaultState());
        } else if (state.isOf(Blocks.WATER)) {
            world.setBlockState(randPos, Blocks.LAVA.getDefaultState());
        } else if (state.isIn(BlockTags.TERRACOTTA)) {
            world.setBlockState(randPos, Blocks.SMOOTH_BASALT.getDefaultState());
        } /*else {
            world.addParticle(ParticleTypes.SMOKE, randPos.getX() + 0.1D, randPos.getY() + 0.1D, randPos.getZ() + 0.1D,
                    0.2D, 0.3D, 0.2D);
            world.playSound(randPos.getX(), randPos.getY(), randPos.getZ(), SoundEvents.BLOCK_FIRE_AMBIENT,
                    SoundCategory.BLOCKS, 1F, 0.0F, true);
        }*/
    }
}
