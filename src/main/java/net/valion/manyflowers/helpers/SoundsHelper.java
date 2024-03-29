package net.valion.manyflowers.helpers;

import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.ArrayList;
import java.util.Random;

public class SoundsHelper {
    public static ArrayList<SoundEvent> sounds = new ArrayList<>();

    public static SoundEvent getRandSound() {
        return sounds.get(new Random().nextInt(sounds.size()));
    }

    public static void putSounds() {
        sounds.add(SoundEvents.ENTITY_ZOMBIE_AMBIENT);
        sounds.add(SoundEvents.ENTITY_SKELETON_AMBIENT);
        sounds.add(SoundEvents.ENTITY_ENDERMAN_STARE);
        sounds.add(SoundEvents.ENTITY_HOGLIN_ANGRY);
        sounds.add(SoundEvents.ENTITY_CREEPER_PRIMED);
    }
}
