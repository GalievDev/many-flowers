package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class ItemGroupSetup {
    public static RegistryKey<ItemGroup> MANY_FLOWERS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID));

    public static void registerItemGroups() {
        Registry.register(
                Registries.ITEM_GROUP, MANY_FLOWERS,
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(Flowers.ALSTROEMERIA_FLOWER))
                        .displayName(Text.of("Many Flowers"))
                        .build()
        );
    }
}
