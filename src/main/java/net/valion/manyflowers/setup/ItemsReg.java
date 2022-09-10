package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.valion.manyflowers.ManyFlowers;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;
import static net.valion.manyflowers.setup.OreFlowers.*;

public class ItemsReg {
    //Seeds//
    public static final Item DIAMOND_SEEDS = registerItem("diamond_seeds",
            new AliasedBlockItem(DIAMOND_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item COAL_SEEDS = registerItem("coal_seeds",
            new AliasedBlockItem(COAL_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item IRON_SEEDS = registerItem("iron_seeds",
            new AliasedBlockItem(IRON_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item GOLD_SEEDS = registerItem("gold_seeds",
            new AliasedBlockItem(GOLD_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item EMERALD_SEEDS = registerItem("emerald_seeds",
            new AliasedBlockItem(EMERALD_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item COPPER_SEEDS = registerItem("copper_seeds",
            new AliasedBlockItem(COPPER_PLANT, new FabricItemSettings().group(ItemGroup.MATERIALS)));

    //Items//
    public static final Item DIAMOND_PETAL = registerItem("diamond_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item COAL_PETAL = registerItem("coal_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item IRON_PETAL = registerItem("iron_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item GOLD_PETAL = registerItem("gold_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item EMERALD_PETAL = registerItem("emerald_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    public static final Item COPPER_PETAL = registerItem("copper_petal",
            new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }

    public static void registerModItems() {
        ManyFlowers.LOGGER.info("Registering Mod Items for " + MOD_ID);
    }
}
