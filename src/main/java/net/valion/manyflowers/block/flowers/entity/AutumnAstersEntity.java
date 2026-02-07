package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.AirBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.block.flowers.AutumnAsters;
import net.valion.manyflowers.config.MFConfig;
import net.valion.manyflowers.registry.BlocksEntitiesRegistry;

import java.util.ArrayList;
import java.util.List;

public class AutumnAstersEntity extends BlockEntity {
    public static List<ItemStack> stacks = new ArrayList<>();
    public static final int delay = 300;
    public static int counter = 0;

    public AutumnAstersEntity(BlockPos pos, BlockState state) {
        super(BlocksEntitiesRegistry.INSTANCE.getAUTUMN_ASTERS_ENTITY(), pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, AutumnAstersEntity entity) {
        if (world.isClient) return;
        if (!MFConfig.HANDLER.instance().still_asters) return;
        if (counter < 0) counter = 0;
        List<ItemEntity> items = world.getEntitiesByClass(
                ItemEntity.class,
                new Box(blockPos).expand(5),
                item -> item instanceof ItemEntity && !(item.getStack().getItem() instanceof AirBlockItem)
        );

        if (counter == delay) {
            if (stacks.size() < 10) {
                for (var item : items) {
                    stacks.add(item.getStack());
                    item.remove(Entity.RemovalReason.KILLED);
                }
            }
            AutumnAsters.canStill = true;
            counter = 0;
        } else counter++;
    }

    @Override
    protected void writeData(WriteView view) {
        view.putInt("mf.counter", counter);
        stacks.forEach(itemStack -> {
            view.putInt("mf.id", Item.getRawId(itemStack.getItem()));
            view.putInt("mf.count", itemStack.getCount());
        });
        super.writeData(view);
    }

    @Override
    protected void readData(ReadView view) {
        var savedCounter = view.getInt("mf.counter", 0);
        var savedItemId = view.getInt("mf.id", 0);
        var savedItemCount = view.getInt("mf.count", 0);

        counter = savedCounter;
        if (savedItemId != 0 && savedItemCount != 0) {
            stacks.add(new ItemStack(
                    Item.byRawId(savedItemId),
                    savedItemCount
            ));
        }
        super.readData(view);
    }
}
