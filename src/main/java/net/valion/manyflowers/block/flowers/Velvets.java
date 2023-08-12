package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Velvets extends FlowerBlock {
    public Velvets(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getRegistryKey() == World.OVERWORLD) {
            for (BlockPos gPos : BlockPos.iterate(pos.add(-2, -1, -2), pos.add(2, 1, 2))) {
                for (BlockPos xPos : BlockPos.iterate(pos.add(-4, -1, -1), pos.add(4, 1, 2))) {
                    for (BlockPos zPos : BlockPos.iterate(pos.add(-1, -1, -4), pos.add(1, 1, 4))) {
                        var gBlocks = world.getBlockState(gPos).getBlock();
                        var xBlocks = world.getBlockState(xPos).getBlock();
                        var zBLocks = world.getBlockState(zPos).getBlock();

                        if (gBlocks == Blocks.GRASS_BLOCK) {
                            world.setBlockState(gPos, Blocks.CRIMSON_NYLIUM.getDefaultState());
                            world.setBlockState(xPos, Blocks.CRIMSON_PLANKS.getDefaultState());
                            world.setBlockState(zPos, Blocks.ACACIA_PLANKS.getDefaultState());
                        } else if (gBlocks == Blocks.DIRT) {
                            world.setBlockState(gPos, Blocks.NETHERRACK.getDefaultState());
                            world.setBlockState(xPos, Blocks.CHERRY_PLANKS.getDefaultState());
                            world.setBlockState(zPos, Blocks.JUNGLE_PLANKS.getDefaultState());
                        } else if (gBlocks == Blocks.STONE) {
                            world.setBlockState(gPos, Blocks.BASALT.getDefaultState());
                            world.setBlockState(xPos, Blocks.COBBLESTONE.getDefaultState());
                            world.setBlockState(zPos, Blocks.BOOKSHELF.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isIn(BlockTags.NETHER_CARVER_REPLACEABLES) || floor.isIn(BlockTags.SAND);
    }
}
