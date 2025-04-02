package net.valion.manyflowers.block.plant;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.valion.manyflowers.registry.ItemsRegistry;

public class GoldPlant extends CropBlock {
    private final static MapCodec<GoldPlant> CODEC = createCodec(GoldPlant::new);

    public GoldPlant(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends CropBlock> getCodec() {
        return CODEC;
    }

    public ItemConvertible getSeedsItem() {
        return ItemsRegistry.INSTANCE.getGOLD_SEEDS();
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getGrowthAmount(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return false;
    }
}
