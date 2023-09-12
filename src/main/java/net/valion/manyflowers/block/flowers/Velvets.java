package net.valion.manyflowers.block.flowers;

import blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Velvets extends FlowerBlock implements BlockEntityProvider {
    private final int delay = 100;
    private int counter = 0;
    public Velvets(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onPlaced(@NotNull World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getRegistryKey() == World.OVERWORLD) {
            ArrayList<BlockPos> poses = new ArrayList<>();
            for (BlockPos gPos : BlockPos.iterate(pos.add(-2, -1, -2), pos.add(2, 1, 2))) {
                for (BlockPos xPos : BlockPos.iterate(pos.add(-4, -2, -1), pos.add(4, 1, 2))) {
                    for (BlockPos zPos : BlockPos.iterate(pos.add(-1, -1, -4), pos.add(1, 1, 4))) {
                        poses.add(gPos);
                        poses.add(xPos);
                        poses.add(zPos);
                    }
                }
            }
            setBlock(world, poses);
        }
    }

    private void setBlock(@NotNull World world, @NotNull List<BlockPos> poses) {
        Random random = new Random();
        if (counter <= delay) {
            ManyFlowers.LOGGER.info("Ticks: " + counter);
            var randPos = poses.get(random.nextInt(poses.size()));
            ManyFlowers.LOGGER.info("Rand pos: " + randPos);
            var block = world.getBlockState(randPos).getBlock();
            ManyFlowers.LOGGER.info("Block: " + block);

            if (block == Blocks.GRASS_BLOCK) {
                world.setBlockState(randPos, Blocks.CRIMSON_NYLIUM.getDefaultState());
            } else if (block == Blocks.DIRT) {
                world.setBlockState(randPos, Blocks.NETHERRACK.getDefaultState());
            } else if (block == Blocks.STONE) {
                world.setBlockState(randPos, Blocks.BASALT.getDefaultState());
            }
            counter = 0;
        } else {
            counter++;
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isIn(BlockTags.NETHER_CARVER_REPLACEABLES) || floor.isIn(BlockTags.SAND);
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return BlockEntityProvider.super.getTicker(world, state, type);
    }
}
