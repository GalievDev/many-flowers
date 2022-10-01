package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.flowers.Hemlock;
import net.valion.manyflowers.block.flowers.Oenothera;
import net.valion.manyflowers.block.flowers.SweetAlyssum;
import net.valion.manyflowers.block.flowers.WaterHemlock;

import javax.annotation.Nullable;
import java.util.List;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class Flowers {

    public static final Block ALSTROEMERIA_FLOWER = registerBlock("alstroemeria_flower",
            new FlowerBlock(StatusEffects.SATURATION, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()));

    public static final Block HYDRANGEA_FLOWER = registerBlock("hydrangea_flower",
            new FlowerBlock(StatusEffects.WATER_BREATHING, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()));

    public static final Block MARIGOLD_FLOWER = registerBlock("marigold_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()));

    public static final Block SWEET_ALYSSUM = registerBlock("sweet_alyssum",
            new SweetAlyssum(StatusEffects.ABSORPTION, 3,
                    FabricBlockSettings.of(Material.PLANT).nonOpaque().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).luminance(5)));

    public static final Block WATER_HEMLOCK = registerBlock("water_hemlock",
            new WaterHemlock(AbstractBlock.Settings.of(Material.UNDERWATER_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS)));

    public static final Block HEMLOCK = registerBlock("hemlock",
            new Hemlock(StatusEffects.FIRE_RESISTANCE, 3,
                    (AbstractBlock.Settings.of(Material.UNDERWATER_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.WET_GRASS))));

    public static final Block OENOTHERA = registerBlock("oenothera",
            new Oenothera(FabricBlockSettings.copy(Blocks.ROSE_BUSH).nonOpaque()));



    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }

    public static void registerModBlocks() {
        ManyFlowers.LOGGER.info("Registering ModBlocks for " + MOD_ID);
    }
}
