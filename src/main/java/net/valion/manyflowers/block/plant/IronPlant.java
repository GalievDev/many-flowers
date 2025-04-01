package net.valion.manyflowers.block.plant;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import static net.valion.manyflowers.registry.ItemsReg.IRON_SEEDS;

public class IronPlant extends CropBlock {
    public IronPlant(Settings settings) {
        super(settings);
    }

    public ItemConvertible getSeedsItem() {
        return IRON_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return false;
    }
}
