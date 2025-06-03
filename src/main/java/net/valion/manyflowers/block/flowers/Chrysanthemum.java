package net.valion.manyflowers.block.flowers;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.valion.manyflowers.config.MFConfig;

public class Chrysanthemum extends BaseFlower {
    private final static MapCodec<Chrysanthemum> CODEC = createCodec(Chrysanthemum::new);

    public Chrysanthemum(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<? extends FlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL && MFConfig.HANDLER.instance().regen_chrysanthemum) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isInvulnerableTo((ServerWorld) world, world.getDamageSources().magic())) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 1));
                }
            }

        }
    }
}
