package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.block.flowers.AutumnAsters;
import net.valion.manyflowers.setup.BlockEntitiesReg;

import java.util.List;

public class AutumnAstersEntity extends BlockEntity {
    int delay = 100;
    int counter = 0;
    public AutumnAstersEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.AUTUMN_ASTERS_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AutumnAstersEntity entity) {
        if (world.isClient) return;
        if (entity.counter < 0) entity.counter = 0;
        List<ItemEntity> items = world.getEntitiesByClass(ItemEntity.class, new Box(blockPos).expand(5), item -> item instanceof ItemEntity);

        if (entity.counter == entity.delay) {
            if (AutumnAsters.items.size() < 10) {
                for (var item : items) {
                    AutumnAsters.items.put(item.getStack().getItem().getTranslationKey(), item.getStack().getCount());
                    item.remove(Entity.RemovalReason.KILLED);
                }
            }
            entity.counter = 0;
        } else entity.counter++;
    }
}
