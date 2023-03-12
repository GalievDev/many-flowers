package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class ItemGroupSetup {
    public static ItemGroup MANY_FLOWERS;

    public static void registerItemGroups() {
        MANY_FLOWERS = FabricItemGroup.builder(new Identifier(MOD_ID, "flowers"))
                .displayName(Text.literal("Many Flowers"))
                .icon(() -> new ItemStack(Flowers.ALSTROEMERIA_FLOWER)).build();
    }
}
