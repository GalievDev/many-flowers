package net.valion.manyflowers.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Arm;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.valion.manyflowers.registry.EntitiesTypeRegistry;

public class DreadpetalEntity extends LivingEntity {

    public DreadpetalEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public DreadpetalEntity(World world) {
        this(EntitiesTypeRegistry.INSTANCE.getDREADPETAL_ENTITY(), world);
        noClip = true;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return null;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
    }

    @Override
    public Arm getMainArm() {
        return null;
    }

    @Override
    public void kill(ServerWorld world) {
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }

    public static DefaultAttributeContainer createAttributes() {
        return MobEntity.createMobAttributes().build();
    }
}
