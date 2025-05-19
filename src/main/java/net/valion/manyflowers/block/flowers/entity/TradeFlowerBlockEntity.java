package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.AirBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.registry.BlocksEntitiesRegistry;
import net.valion.manyflowers.registry.ItemsRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static net.valion.manyflowers.helpers.TagToBlocksHelper.*;

public class TradeFlowerBlockEntity extends BlockEntity {
    @Nullable
    public static ItemStack stack;
    public static final int delay = 200;
    public static int counter = 0;

    public TradeFlowerBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksEntitiesRegistry.INSTANCE.getTRADE_FLOWER_ENTITY(), pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, TradeFlowerBlockEntity blockEntity) {
        if (world.isClient) return;
        if (counter < 0) counter = 0;
        if (!ManyFlowers.INSTANCE.getCONFIG().trades_trade_flower) return;

        Optional<ItemEntity> optionalItemEntity = world.getEntitiesByClass(
                ItemEntity.class,
                new Box(blockPos).expand(2),
                item -> item instanceof ItemEntity && !(item.getStack().getItem() instanceof AirBlockItem)
        ).stream().findFirst();

        optionalItemEntity.ifPresent(itemEntity -> stack = itemEntity.getStack());

        if (counter == delay) {
            if (stack != null) {
                int chance = ManyFlowers.INSTANCE.getRANDOM().nextInt(0, 100);
                ItemEntity entity = null;
                if (stack.isOf(Items.BONE_MEAL)) {
                    if (chance <= 50) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomCommonFlower());
                    } else if (chance <= 80) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomUncommonFlower());
                    } else if (chance <= 95) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomRareFlower());
                    } else if (chance <= 99) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomEpicFlower());
                    } else {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomOreFlower());
                    }
                } else if (stack.isOf(ItemsRegistry.INSTANCE.getFLORAL_MEAL())) {
                    if (chance <= 20) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomCommonFlower());
                    } else if (chance <= 40) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomUncommonFlower());
                    } else if (chance <= 60) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomRareFlower());
                    } else if (chance <= 80) {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomEpicFlower());
                    } else {
                        entity = new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), getRandomOreFlower());
                    }
                }
                if (entity != null) {
                    world.spawnEntity(entity);
                    optionalItemEntity.ifPresent(itemEntity -> itemEntity.remove(Entity.RemovalReason.DISCARDED));
                    stack = null;
                }
            }
            counter = 0;
        } else counter++;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        nbt.putInt("mf.tradeCount", counter);
        if (stack != null) {
            nbt.putInt("mf.stack", Item.getRawId(stack.getItem()));
        } else {
            nbt.putInt("mf.stack", 0);
        }
        super.writeNbt(nbt, registries);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        var itemId = nbt.getInt("mf.stack");
        if (itemId != 0) {
            stack = new ItemStack(Item.byRawId(itemId));
        }
        counter = nbt.getInt("mf.tradeCount");
        super.readNbt(nbt, registries);
    }
}
