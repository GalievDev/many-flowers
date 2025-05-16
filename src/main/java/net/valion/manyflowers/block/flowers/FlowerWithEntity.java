package net.valion.manyflowers.block.flowers;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

public class FlowerWithEntity extends BaseFlower {
    private final EntityType<? extends LivingEntity> entityType;

    public FlowerWithEntity(Settings settings, EntityType<? extends LivingEntity> entity) {
        super(settings);
        entityType = entity;
    }

    public EntityType<? extends LivingEntity> getEntityType() {
        return entityType;
    }
}
