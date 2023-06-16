package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.flowers.*;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class Flowers {

    public static final Block ALSTROEMERIA_FLOWER = registerBlock("alstroemeria_flower",
            new FlowerBlock(StatusEffects.SATURATION, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block HYDRANGEA_FLOWER = registerBlock("hydrangea_flower",
            new FlowerBlock(StatusEffects.WATER_BREATHING, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block MARIGOLD_FLOWER = registerBlock("marigold_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block SWEET_ALYSSUM = registerBlock("sweet_alyssum",
            new SweetAlyssum(StatusEffects.ABSORPTION, 3,
                    FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(5)), ItemGroupSetup.MANY_FLOWERS);

    public static final Block WATER_HEMLOCK = registerBlock("water_hemlock",
            new WaterHemlock(FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS)), ItemGroupSetup.MANY_FLOWERS);

    public static final Block HEMLOCK = registerBlock("hemlock",
            new Hemlock(StatusEffects.FIRE_RESISTANCE, 3,
                    (FabricBlockSettings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS))), ItemGroups.FUNCTIONAL);

    public static final Block OENOTHERA = registerBlock("oenothera",
            new Oenothera(FabricBlockSettings.copy(Blocks.ROSE_BUSH).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block GAILLARDIA = registerBlock("gaillardia",
            new Gaillardia(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block ORIENTAL_POPPY = registerBlock("oriental_poppy",
            new OrientalPoppy(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    public static final Block ROOT_OF_THE_WORLDS = registerBlock("root_of_the_worlds",
            new RootOfTheWorlds(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroupSetup.MANY_FLOWERS);

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(ManyFlowers.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(ManyFlowers.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        ManyFlowers.LOGGER.info("Registering ModBlocks for " + MOD_ID);
    }
}
