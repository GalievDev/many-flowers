package net.valion.manyflowers.entity.goal;

import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.valion.manyflowers.entity.BlindblossomEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class BlindblossomGoal extends Goal {
    protected final PathAwareEntity mob;
    private final double speed;
    @Nullable
    protected BlindblossomEntity closestBlindblossom;
    protected final float lureDistance;
    private final TargetPredicate rangePredicate;
    private boolean active;

    public BlindblossomGoal(PathAwareEntity mob, double speed, float lureDistance) {
        this.mob = mob;
        this.speed = speed;
        this.lureDistance = lureDistance;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
        this.rangePredicate = TargetPredicate.createAttackable()
                .setBaseMaxDistance(lureDistance)
                .setPredicate((entity, world) -> EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.test(entity));
    }

    @Override
    public boolean canStart() {
        this.closestBlindblossom = getServerWorld(this.mob)
                .getClosestEntity(
                        this.mob
                                .getWorld()
                                .getEntitiesByClass(BlindblossomEntity.class, this.mob.getBoundingBox().expand(this.lureDistance, 3.0, this.lureDistance), livingEntity -> true),
                        this.rangePredicate,
                        this.mob,
                        this.mob.getX(),
                        this.mob.getY(),
                        this.mob.getZ()
                );
        return closestBlindblossom != null;
    }

    @Override
    public boolean shouldContinue() {
        return this.canStart();
    }

    @Override
    public void start() {
        this.active = true;
    }

    @Override
    public void stop() {
        this.closestBlindblossom = null;
        this.mob.getNavigation().stop();
        this.active = false;
    }

    @Override
    public void tick() {
        this.mob.getLookControl().lookAt(this.closestBlindblossom, this.mob.getMaxHeadRotation() + 20, this.mob.getMaxLookPitchChange());
        if (this.mob.squaredDistanceTo(this.closestBlindblossom) < 1.25) {
            this.mob.getNavigation().stop();
        } else {
            this.mob.getNavigation().startMovingTo(this.closestBlindblossom, this.speed);
        }
    }

    public boolean isActive() {
        return this.active;
    }
}
