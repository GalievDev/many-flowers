package net.valion.manyflowers.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.plant.OrePlant;

import java.util.Map;

public class FloralMeal extends Item {

    public FloralMeal(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        if (useOnOreCrop(context.getStack(), world, blockPos)) {
            if (!world.isClient()) {
                context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, blockPos, 15);
            }
            return ActionResult.SUCCESS;
        } else {
            if (world.getBlockState(blockPos) == Blocks.GRASS_BLOCK.getDefaultState()) {
                if (!world.isClient) {
                    useOnGrass(context.getStack(), (ServerWorld) world, blockPos);
                    context.getPlayer().emitGameEvent(GameEvent.ITEM_INTERACT_FINISH);
                    world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, blockPos, 15);
                }
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public static boolean useOnOreCrop(ItemStack stack, World world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof OrePlant plant) {
            if (world instanceof ServerWorld serverWorld) {
                if (plant.canGrow(world, world.random, pos, blockState)) {
                    plant.grow(serverWorld, world.random, pos, blockState);
                }
                stack.decrement(1);
            }
            return true;
        } else {
            return false;
        }
    }

    public static void useOnGrass(ItemStack stack, ServerWorld world, BlockPos pos) {
        for (BlockPos growingPos: BlockPos.iterate(pos.add(1, 0, 1), pos.add(-1, 0, -1))) {
            BlockPos blockPos = growingPos.up();
            if (world.getBlockState(blockPos.down()).isOf(Blocks.GRASS_BLOCK) || world.getBlockState(blockPos).isFullCube(world, blockPos)) {
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.isAir()) {
                    var flowers = world.getRegistryManager()
                            .getOrThrow(RegistryKeys.CONFIGURED_FEATURE)
                            .getEntrySet().stream()
                            .filter(entry -> entry.getKey().getValue().getNamespace().equals(ManyFlowers.MOD_ID))
                            .map(Map.Entry::getValue)
                            .filter(feature -> feature.feature() == Feature.FLOWER)
                            .filter(configuredFeature -> configuredFeature.config() instanceof RandomPatchFeatureConfig)
                            .toList();
                    if (flowers.isEmpty()) {
                        continue;
                    }
                    if (ManyFlowers.INSTANCE.getRANDOM().nextInt(0, 10) >= 5) {
                        ((RandomPatchFeatureConfig) flowers.get(ManyFlowers.INSTANCE.getRANDOM().nextInt(0, flowers.size() / 2 - 1)).config()).feature().value()
                                .generateUnregistered(world, world.getChunkManager().getChunkGenerator(), world.random, blockPos);
                    }
                }
            }
        }
        stack.decrement(1);
    }
}
