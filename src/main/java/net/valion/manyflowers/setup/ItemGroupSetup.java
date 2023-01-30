package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.valion.manyflowers.ManyFlowers;

public class ItemGroupSetup {
    public static final ItemGroup MANY_FLOWERS = FabricItemGroupBuilder.build(new Identifier(ManyFlowers.MOD_ID, "flowers"),
            () -> new ItemStack(Flowers.ALSTROEMERIA_FLOWER));
}
