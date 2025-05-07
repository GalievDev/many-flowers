package net.valion.manyflowers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class DreadpetalEntity extends NonRepulsiveEntity {

    public DreadpetalEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
    }

    public static DefaultAttributeContainer createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.KNOCKBACK_RESISTANCE, 10.0F).build();
    }
}
