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
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.entity.BlindblossomEntity;
import net.valion.manyflowers.registry.EntitiesTypeRegistry;
import org.jetbrains.annotations.Nullable;

public class Blindblossom extends FlowerWithEntity {
    public Blindblossom(Settings settings) {
        super(settings, EntitiesTypeRegistry.INSTANCE.getBLINDBLOSSOM_ENTITY());
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        var entity = getEntityType().create(world, SpawnReason.TRIGGERED);
        if (!world.isClient && entity != null && ManyFlowers.INSTANCE.getCONFIG().blindblossom_attraction) {
            entity.setPos(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(entity);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (pos != null) {
            removeBlindblossomEntities(world, pos);
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        if (world.getBlockState(pos.down()).isOf(Blocks.AIR)) {
            removeBlindblossomEntities(world, pos);
        }
        super.neighborUpdate(state, world, pos, sourceBlock, wireOrientation, notify);
    }

    private void removeBlindblossomEntities(World world, BlockPos pos) {
        var entities = world.getEntitiesByClass(
                BlindblossomEntity.class,
                new Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0),
                blindblossomEntity -> true
        );
        if (entities != null) {
            for (var entity : entities) {
                entity.remove(Entity.RemovalReason.DISCARDED);
                entity.emitGameEvent(GameEvent.ENTITY_DIE);
            }
        }
    }
}
