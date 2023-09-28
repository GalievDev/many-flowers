package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.valion.manyflowers.block.flowers.entity.AutumnCrocusEntity;
import net.valion.manyflowers.setup.BlockEntitiesReg;
import org.jetbrains.annotations.Nullable;

public class AutumnCrocus extends ExtendedFlower {
    protected AutumnCrocus(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.BASE_STONE_OVERWORLD);
    }

    //Block entity
    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AutumnCrocusEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntitiesReg.AUTUMN_CROCUS_ENTITY, AutumnCrocusEntity::tick);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
