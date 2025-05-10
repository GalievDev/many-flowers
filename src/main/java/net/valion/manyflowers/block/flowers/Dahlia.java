package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.block.flowers.entity.DahliaBlockEntity;
import net.valion.manyflowers.registry.BlocksEntitiesRegistry;
import org.jetbrains.annotations.Nullable;

public class Dahlia extends ExtendedFlower {
    private final static MapCodec<Dahlia> CODEC = createCodec(Dahlia::new);

    public Dahlia(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends ExtendedFlower> getCodec() {
        return CODEC;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isIn(BlockTags.BASE_STONE_OVERWORLD);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DahliaBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BlocksEntitiesRegistry.INSTANCE.getDAHLIA_ENTITY(), DahliaBlockEntity::tick);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
