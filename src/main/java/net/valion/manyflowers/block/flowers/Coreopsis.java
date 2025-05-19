package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;

public class Coreopsis extends BaseFlower {
    private final static MapCodec<Coreopsis> CODEC = createCodec(Coreopsis::new);

    public Coreopsis(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!ManyFlowers.INSTANCE.getCONFIG().coreopsis_effect) return;
        if (!world.isClient) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo((ServerWorld) world, world.getDamageSources().magic())) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 150, 1));
                }
            }

        }
    }
}
