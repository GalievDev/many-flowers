package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.valion.manyflowers.config.MFConfig;

import java.util.Random;

public class Oenothera extends TallPlantBlock implements Fertilizable {
    public Oenothera(Settings settings) {
        super(settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL && MFConfig.turn_off_damage_oenothera) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                if (!livingEntity.isInvulnerableTo(DamageSource.MAGIC)) {
                    entity.damage(DamageSource.MAGIC, 1.0f);
                }
            }

        }
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
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
