package net.thewonderfultime.pony18craft.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class WoodDudeEntity extends PathAwareEntity implements GeoEntity {

    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache( this);

    public WoodDudeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

//    @Override
//    protected Identifier getLootTableId() {
//        //добавление таблицы лута к мобу
//        return ModEntities.IRON_ORE_DUDE.getLootTableId();
//    }

    @Override
    protected void initGoals() {


        // Добавляем цель "гулять по миру"
        this.goalSelector.add(2, new WanderAroundGoal(this, 1.0));
    }

    // Определяем базовые атрибуты
    public static DefaultAttributeContainer.Builder setAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 0.5) // Здоровье
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3) // Скорость передвижения
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0); // Дальность видимости
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()){

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.wood_dude.run",
                    Animation.LoopType.LOOP));

            return PlayState.CONTINUE;
        }



        return PlayState.CONTINUE;
    }


    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        // Возвращаем false, чтобы отключить урон от падения
        return false;
    }





    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

