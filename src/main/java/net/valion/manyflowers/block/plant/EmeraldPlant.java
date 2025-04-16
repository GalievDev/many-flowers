package net.valion.manyflowers.block.plant;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.valion.manyflowers.registry.ItemsRegistry;

public class EmeraldPlant extends OrePlant {
    private final static MapCodec<EmeraldPlant> CODEC = createCodec(EmeraldPlant::new);

    public EmeraldPlant(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends CropBlock> getCodec() {
        return CODEC;
    }

    public ItemConvertible getSeedsItem() {
        return ItemsRegistry.INSTANCE.getEMERALD_SEEDS();
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }
}
