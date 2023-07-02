package net.valion.manyflowers.client.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;

public class BookScreenHandler extends ScreenHandler {
    public BookScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return player.getMainHandStack();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
