package net.valion.manyflowers.block.flowers;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;

public class BaseFlower extends FlowerBlock {
    public BaseFlower(Settings settings) {
        super(StatusEffects.ABSORPTION, 0F, settings);
    }
}
