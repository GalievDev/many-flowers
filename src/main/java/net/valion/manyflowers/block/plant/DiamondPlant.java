package net.valion.manyflowers.block.plant;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

import static net.valion.manyflowers.registry.ItemsReg.DIAMOND_SEEDS;

public class DiamondPlant extends CropBlock {
    public DiamondPlant(AbstractBlock.Settings settings) {
        super(settings);
    }

    public ItemConvertible getSeedsItem() {
        return DIAMOND_SEEDS;
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
