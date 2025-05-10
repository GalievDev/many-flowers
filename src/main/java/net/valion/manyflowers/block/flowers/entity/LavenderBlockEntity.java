package net.valion.manyflowers.block.flowers.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.valion.manyflowers.registry.BlocksEntitiesRegistry;

public class LavenderBlockEntity extends BlockEntity {
    public LavenderBlockEntity(BlockPos pos, BlockState state) {
        super(BlocksEntitiesRegistry.INSTANCE.getLAVENDER_ENTITY(), pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, LavenderBlockEntity blockEntity) {
        if (world.isClient) return;

        var livingEntities = world.getEntitiesByClass(
                LivingEntity.class,
                new Box(blockPos).expand(10),
                entity -> entity instanceof LivingEntity
        );

        if (!livingEntities.isEmpty()) {
            for (var livingEntity : livingEntities) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 150, 1));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 150, 1));
            }
        }
    }
}
