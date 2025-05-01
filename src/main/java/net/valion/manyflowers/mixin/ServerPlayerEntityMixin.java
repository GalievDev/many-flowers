package net.valion.manyflowers.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.valion.manyflowers.block.flowers.EtherealOrchid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(method = "findRespawnPosition", at = @At("HEAD"), cancellable = true)
    private static void findEtherealOrchidSpawn(ServerWorld world, BlockPos pos, float spawnAngle, boolean spawnForced, boolean alive, CallbackInfoReturnable<Optional<ServerPlayerEntity.RespawnPos>> cir) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block instanceof EtherealOrchid && (spawnForced || blockState.get(EtherealOrchid.CHARGES) > 0)) {
            var spawnPoses = EtherealOrchid.findRespawnPosition(EntityType.PLAYER, world, pos);
            if (!spawnForced && alive && spawnPoses.isPresent()) {
                world.setBlockState(pos, blockState.with(EtherealOrchid.CHARGES, blockState.get(EtherealOrchid.CHARGES) - 1), 3);
            }
            cir.setReturnValue(spawnPoses.map((respawnPos) -> ServerPlayerEntity.RespawnPos.fromCurrentPos(respawnPos, pos)));
        }
    }
}
