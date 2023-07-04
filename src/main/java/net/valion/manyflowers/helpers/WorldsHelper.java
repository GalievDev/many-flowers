package net.valion.manyflowers.helpers;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class WorldsHelper {
    private static final Random random = new Random();
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
        return random.nextInt(bound);
    }

    public static void teleportToSafeZone(ServerPlayerEntity player) {
        ServerWorld serverWorld = getRandomWorld();
        BlockPos.Mutable blockPos = new BlockPos.Mutable();

        getRandomSafePosition(serverWorld, blockPos);

        player.teleport(serverWorld, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, player.getYaw(), player.getPitch());
    }

    private static void getRandomSafePosition(World world, BlockPos.Mutable blockPos) {
        int rangeX = 10000;
        int rangeZ = 10000;

        int x = random.nextInt(rangeX * 2 + 1) - rangeX;
        int z = random.nextInt(rangeZ * 2 + 1) - rangeZ;

        blockPos.set(x, 70, z);

        while (!isSafe(world, blockPos)) {
            blockPos.setY(blockPos.getY() + 1);

            if (blockPos.getY() > 120 && world.getRegistryKey() == World.NETHER) {
                blockPos.setY(70);
                x = random.nextInt(rangeX * 2 + 1) - rangeX;
                z = random.nextInt(rangeZ * 2 + 1) - rangeZ;
                blockPos.set(x, 70, z);
            } else if (blockPos.getY() > 200) {
                blockPos.setY(70);
                x = random.nextInt(rangeX * 2 + 1) - rangeX;
                z = random.nextInt(rangeZ * 2 + 1) - rangeZ;
                blockPos.set(x, 70, z);
            }
        }
    }

    private static boolean isSafe(World world, BlockPos pos) {
        return !world.isAir(pos.down()) && world.isAir(pos);
    }
}
