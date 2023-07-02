package net.valion.manyflowers.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.valion.manyflowers.client.screen.BookScreen;

public class Encyclopedia extends Item {
    public Encyclopedia() {
        super(new Settings().maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            MinecraftClient.getInstance().setScreen(new BookScreen());
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
