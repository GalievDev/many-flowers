package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.registry.BlocksEntitiesRegistry;

public class DahliaBlockEntity extends BlockEntity {

    public DahliaBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksEntitiesRegistry.INSTANCE.getDAHLIA_ENTITY(), pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, DahliaBlockEntity blockEntity) {
        if (world.isClient) return;

        var players = world.getEntitiesByClass(
                PlayerEntity.class,
                new Box(blockPos).expand(10),
                entity -> entity instanceof ServerPlayerEntity
        );

        if (!players.isEmpty()) {
            var hostiles = world.getEntitiesByClass(
                    HostileEntity.class,
                    new Box(blockPos).expand(10),
                    entity -> entity instanceof HostileEntity
            );

            if (!hostiles.isEmpty()) {
                for (var player : players) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 50, 1));
                }
            }
        }
    }
}
