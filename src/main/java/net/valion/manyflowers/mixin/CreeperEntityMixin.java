package net.valion.manyflowers.mixin;

import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.valion.manyflowers.setup.Flowers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.valion.manyflowers.utils.FindFear.isWarpedFlowerAround;


@Mixin(CreeperEntity.class)
public class CreeperEntityMixin {
    private CreeperEntity creeper;
    private BlockPos pos;
    WorldView world;

    @Inject(at = @At("HEAD"), method = "tick")
    public float FearFlower (CallbackInfo ci){
        if (isWarpedFlowerAround(creeper, pos)) {
            return -1.0F;
        } else {
            return world.getBlockState(pos.down()).isOf(Flowers.CREEPER_FEAR) ? 10.0F : 0.0F;
        }
    }
}
