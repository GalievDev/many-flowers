package net.valion.manyflowers.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.valion.manyflowers.block.flowers.EtherealOrchid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "findRespawnPosition", at = @At("HEAD"), cancellable = true)
    private static void findEtherealOrchidSpawn(ServerWorld world, ServerPlayerEntity.Respawn respawn, boolean bl, CallbackInfoReturnable<Optional<ServerPlayerEntity.RespawnPos>> cir) {
        BlockState blockState = world.getBlockState(respawn.pos());
        Block block = blockState.getBlock();
        if (block instanceof EtherealOrchid && (respawn.forced() || blockState.get(EtherealOrchid.CHARGES) > 0)) {
            var spawnPoses = EtherealOrchid.findRespawnPosition(EntityType.PLAYER, world, respawn.pos());
            if (!respawn.forced() && bl && spawnPoses.isPresent()) {
                world.setBlockState(respawn.pos(), blockState.with(EtherealOrchid.CHARGES, blockState.get(EtherealOrchid.CHARGES) - 1), 3);
            }
            cir.setReturnValue(spawnPoses.map((respawnPos) -> ServerPlayerEntity.RespawnPos.fromCurrentPos(respawnPos, respawn.pos())));
        }
    }
}
