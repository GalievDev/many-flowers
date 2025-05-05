package net.valion.manyflowers.block.flowers;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.entity.FleeDreadpetalEntity;
import net.valion.manyflowers.registry.EntitiesTypeRegistry;
import org.jetbrains.annotations.Nullable;

public class Dreadpetal extends BaseFlower {
    public Dreadpetal(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        var entity = EntitiesTypeRegistry.INSTANCE.getDREADPETAL_ENTITY().create(world, SpawnReason.TRIGGERED);
        if (!world.isClient && entity != null) {
            entity.setPos(pos.getX(), pos.getY(), pos.getZ());
            world.spawnEntity(entity);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (pos != null) {
            var entities = world.getEntitiesByClass(
                    FleeDreadpetalEntity.class,
                    new Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0),
                    fleeDreadpetalEntity -> fleeDreadpetalEntity.noClip
            );
            if (entities != null) {
                for (Entity entity : entities) {
                    entity.remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }

        return super.onBreak(world, pos, state, player);
    }
}
