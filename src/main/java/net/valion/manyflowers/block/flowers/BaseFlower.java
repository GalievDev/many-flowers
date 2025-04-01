package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;

public class BaseFlower extends FlowerBlock {
    private final static MapCodec<BaseFlower> CODEC = createCodec(BaseFlower::new);

    public BaseFlower(Settings settings) {
        super(StatusEffects.ABSORPTION, 0F, settings);
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }
}
