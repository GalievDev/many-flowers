package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.flowers.AutumnAsters;
import net.valion.manyflowers.setup.BlockEntitiesReg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutumnAstersEntity extends BlockEntity {
    public static Map<String, Integer> ids = new HashMap<>();
    public static final int delay = 300;
    public static int counter = 0;
    public AutumnAstersEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesReg.AUTUMN_ASTERS_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AutumnAstersEntity entity) {
        if (world.isClient) return;
        if (!ManyFlowers.CONFIG.still_asters) return;
        if (counter < 0) counter = 0;
        List<ItemEntity> items = world.getEntitiesByClass(ItemEntity.class, new Box(blockPos).expand(5), item -> item instanceof ItemEntity);

        if (counter == delay) {
            if (ids.size() < 10) {
                for (var item : items) {
                    ids.put(item.getStack().getItem().toString(), item.getStack().getCount());
                    item.remove(Entity.RemovalReason.KILLED);
                }
            }
            AutumnAsters.canStill = true;
            counter = 0;
        } else counter++;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("mf.counter", counter);
        ids.forEach((id, count) -> {
            nbt.putString("mf.id", id);
            nbt.putInt("mf.count", count);
        });
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        nbt.getInt("mf.counter");
        nbt.getString("mf.id");
        nbt.getInt("mf.count");
        super.readNbt(nbt);
    }
}
