package net.valion.manyflowers.helpers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.registry.BlockTagsRegistry;

import java.util.ArrayList;
import java.util.List;

public class TagToBlocksHelper {
    public final static List<Block> COMMON_FLOWERS = new ArrayList<>();
    public final static List<Block> UNCOMMON_FLOWERS = new ArrayList<>();
    public final static List<Block> RARE_FLOWERS = new ArrayList<>();
    public final static List<Block> EPIC_FLOWERS = new ArrayList<>();
    public final static List<Block> ORE_FLOWERS = new ArrayList<>();

    public static void init() {
        for (Block block : Registries.BLOCK) {
            if (block.getDefaultState().isIn(BlockTagsRegistry.INSTANCE.getCOMMON_FLOWERS())) {
                COMMON_FLOWERS.add(block);
            } else if (block.getDefaultState().isIn(BlockTagsRegistry.INSTANCE.getUNCOMMON_FLOWERS())) {
                UNCOMMON_FLOWERS.add(block);
            } else if (block.getDefaultState().isIn(BlockTagsRegistry.INSTANCE.getRARE_FLOWERS())) {
                RARE_FLOWERS.add(block);
            } else if (block.getDefaultState().isIn(BlockTagsRegistry.INSTANCE.getEPIC_FLOWERS())) {
                EPIC_FLOWERS.add(block);
            } else if (block.getDefaultState().isIn(BlockTagsRegistry.INSTANCE.getORE_FLOWERS())) {
                ORE_FLOWERS.add(block);
            }
        }
    }

    public static ItemStack getRandomCommonFlower() {
        return COMMON_FLOWERS.get(
                ManyFlowers.INSTANCE.getRANDOM().nextInt(0, COMMON_FLOWERS.size() - 1)
        ).asItem().getDefaultStack();
    }

    public static ItemStack getRandomUncommonFlower() {
        return UNCOMMON_FLOWERS.get(
                ManyFlowers.INSTANCE.getRANDOM().nextInt(0, UNCOMMON_FLOWERS.size() - 1)
        ).asItem().getDefaultStack();
    }

    public static ItemStack getRandomRareFlower() {
        return RARE_FLOWERS.get(
                ManyFlowers.INSTANCE.getRANDOM().nextInt(0, RARE_FLOWERS.size() - 1)
        ).asItem().getDefaultStack();
    }

    public static ItemStack getRandomEpicFlower() {
        return EPIC_FLOWERS.get(
                ManyFlowers.INSTANCE.getRANDOM().nextInt(0, EPIC_FLOWERS.size() - 1)
        ).asItem().getDefaultStack();
    }

    public static ItemStack getRandomOreFlower() {
        return ORE_FLOWERS.get(
                ManyFlowers.INSTANCE.getRANDOM().nextInt(0, ORE_FLOWERS.size() - 1)
        ).asItem().getDefaultStack();
    }
}
