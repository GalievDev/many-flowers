package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.FluidFillable;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import static net.valion.manyflowers.ManyFlowers.CONFIG;

public class WaterHemlock extends PlantBlock implements Fertilizable, FluidFillable{
    public WaterHemlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL && CONFIG.damage_hemlock) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo(world.getDamageSources().magic())) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 50, 3));
                }
            }

        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStill(false);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) && floor.isIn(BlockTags.DIRT);
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
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {}

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        return false;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        if (fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8) {
            return super.getPlacementState(ctx);
        }
        return null;
    }
}
