package net.valion.manyflowers.helpers;

import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class WorldsHelper {
    private static final ArrayList<ServerWorld> dims = new ArrayList<>();

    public static void putWorld(ServerWorld serverWorld){
        dims.add(serverWorld);
    }

    public static ServerWorld getRandomWorld(){
        Random random = new Random();
        return dims.get(random.nextInt(dims.size()));
    }

    public static void clearWorlds(){
        dims.clear();
    }

    public static int getRandInt(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static void tpSafeZone(ServerPlayerEntity player, ServerWorld serverWorld, BlockPos.Mutable blockPos) {
        if (isSafe(serverWorld, blockPos)) {
            player.setSpawnPoint(serverWorld.getRegistryKey(), blockPos, player.getSpawnAngle(), true, false);
            player.teleport(serverWorld, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, player.bodyYaw, player.prevPitch);
        } else {
            blockPos.setX(getRandInt(1000));
            blockPos.setZ(getRandInt(1500));
            safeCheck(serverWorld, blockPos);
            tpSafeZone(player, serverWorld, blockPos);
        }
    }

    public static void safeCheck(ServerWorld serverWorld, BlockPos.Mutable blockPos) {
        int y = blockPos.getY();
        while (!isSafe(serverWorld, blockPos)) {
            y++;
            blockPos.setY(y);
            if (blockPos.getY() >= 120 && serverWorld.getRegistryKey() == World.NETHER) {
                blockPos.setY(70);
                blockPos.setX(getRandInt(1000));
                blockPos.setZ(getRandInt(1000));
                safeCheck(serverWorld, blockPos);
            } else if (blockPos.getY() >= 200) {
                blockPos.setY(70);
                blockPos.setX(getRandInt(2000));
                blockPos.setZ(getRandInt(2000));
                safeCheck(serverWorld, blockPos);
            }
        }
    }

    public static boolean isSafe(ServerWorld world, BlockPos mutableBlockPos) {
        return isEmpty(world, mutableBlockPos) && !isDangerBlocks(world, mutableBlockPos);
    }

    public static boolean isEmpty(ServerWorld world, BlockPos mutableBlockPos) {
        return world.isAir(mutableBlockPos.add(0, 1, 0)) && world.isAir(mutableBlockPos);
    }

    public static boolean isDangerBlocks(ServerWorld world, BlockPos mutableBlockPos) {
        if(isDangerBlock(world, mutableBlockPos) && isDangerBlock(world, mutableBlockPos.add(0, 1, 0)) &&
                isDangerBlock(world, mutableBlockPos.add(0, -1, 0))) {
            return true;
        }
        return world.getBlockState(mutableBlockPos.add(0, -1, 0)).getBlock() == Blocks.AIR;
    }

    public static boolean isDangerBlock(ServerWorld world, BlockPos mutableBlockPos) {
        return world.getBlockState(mutableBlockPos).getBlock() instanceof FluidBlock;
    }
}
