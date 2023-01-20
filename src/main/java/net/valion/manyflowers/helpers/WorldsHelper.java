package net.valion.manyflowers.helpers;

import net.minecraft.server.world.ServerWorld;

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

    public static int getRandInt(){
        Random random = new Random();
        return random.nextInt();
    }
}
