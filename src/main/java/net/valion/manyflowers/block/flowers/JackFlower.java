package net.valion.manyflowers.block.flowers;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.function.ToIntFunction;

public class JackFlower extends FlowerBlock implements Fertilizable {
    public static final BooleanProperty LIT = Properties.LIT;
    public JackFlower() {
        super(StatusEffects.FIRE_RESISTANCE, 0, FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).nonOpaque()
                .noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(createLightLevelFromLitBlockState(15)));
        this.setDefaultState(this.getDefaultState().with(LIT, false));
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT);
    }

    private void updateState(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (world.getTimeOfDay() >= 10000) {
            if (!state.get(LIT)) {
                updateState(state, world, pos);
            }
        } else if (state.get(LIT)) {
            updateState(state, world, pos);
        }
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
        super.appendProperties(builder);
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
    }
}
