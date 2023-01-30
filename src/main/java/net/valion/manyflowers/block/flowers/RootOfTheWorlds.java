package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.config.MFConfig;

import static net.valion.manyflowers.helpers.WorldsHelper.*;

public class RootOfTheWorlds extends FlowerBlock {
    public RootOfTheWorlds(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals() && entity.isPlayer() && !MFConfig.turn_off_teleport_ROTW) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) entity;
            ServerWorld serverWorld = getRandomWorld();
            int x = getRandInt(100000);
            int y = 50;
            int z = getRandInt(100000);

            BlockPos.Mutable blockPos = new BlockPos.Mutable(x, y, z);

            if (serverPlayer.isPlayer() && entity.isPlayer()) {
                safeCheck(serverWorld, blockPos, y);
                if (isSafe(serverWorld, blockPos)) {
                    serverPlayer.teleport(serverWorld, blockPos.getX(), blockPos.getY(), blockPos.getZ(), serverPlayer.bodyYaw, serverPlayer.prevPitch);
                    ManyFlowers.LOGGER.info("World: " + serverWorld + " x: " + x + " y: " + y + " z: " + z);
                }
            }
            if (!entity.isPlayer()) {
                entity.kill();
            }
        }
    }

    @Override
    public void randomDisplayTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        float chance = 0.35f;
        if(chance < rand.nextFloat()) {
            worldIn.addParticle(ParticleTypes.PORTAL, pos.getX() + 0.5D,
                    pos.getY() + 0.5D, pos.getZ() + 0.5D,
                    0.2d,0.1d,0.3d);
        }
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.END_STONE) || super.canPlantOnTop(floor, world, pos);
    }
}
