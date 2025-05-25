package net.valion.manyflowers.block.flowers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.valion.manyflowers.config.MFConfig;
import net.valion.manyflowers.entity.DreadpetalEntity;
import net.valion.manyflowers.registry.EntitiesTypeRegistry;
import org.jetbrains.annotations.Nullable;

public class Dreadpetal extends FlowerWithEntity {
    public Dreadpetal(Settings settings) {
        super(settings, EntitiesTypeRegistry.INSTANCE.getDREADPETAL_ENTITY());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        var entity = getEntityType().create(world, SpawnReason.TRIGGERED);
        if (!world.isClient && entity != null && MFConfig.HANDLER.instance().dreadpetal_flee) {
            entity.setPos(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(entity);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (pos != null) {
            removeDreadpetalEntities(world, pos);
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (world.getBlockState(pos.down()).isOf(Blocks.AIR)) {
            removeDreadpetalEntities(world, pos);
        }
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }

    private void removeDreadpetalEntities(World world, BlockPos pos) {
        var entities = world.getEntitiesByClass(
                DreadpetalEntity.class,
                new Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0),
                fleeDreadpetalEntity -> true
        );
        if (entities != null) {
            for (var entity : entities) {
                entity.remove(Entity.RemovalReason.DISCARDED);
                entity.emitGameEvent(GameEvent.ENTITY_DIE);
            }
        }
    }
}
