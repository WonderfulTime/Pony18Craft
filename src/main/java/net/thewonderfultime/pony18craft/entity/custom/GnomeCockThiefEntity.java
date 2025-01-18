package net.thewonderfultime.pony18craft.entity.custom;


import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
//import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GnomeCockThiefEntity extends AnimalEntity implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GnomeCockThiefEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);


    }



    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 0.5D, false));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.5f, 1));

        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, ChickenEntity.class, true));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.GNOME_COCK_THIEF.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()){

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.GnomeCockThief.run",
                    Animation.LoopType.LOOP));

            return PlayState.CONTINUE;
        }


        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.GnomeCockThief.idle",
                Animation.LoopType.LOOP));


        return PlayState.CONTINUE;
    }



    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        // Воспроизведение звука шагов
        this.playSound(ModSounds.GNOME_FOOTSTEPS_SOUND, 0.05f, 1.0f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        // Возвращает звук, который воспроизводится, когда сущность "разговаривает"
        return ModSounds.GNOME_LAUGH_SOUND;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        // Возвращает звук, который воспроизводится, когда сущность получает урон
        return ModSounds.GNOME_TAKEN_DAMAGE_SOUND;
    }

    @Override
    protected SoundEvent getDeathSound() {
        // Возвращает звук, который воспроизводится, когда сущность умирает
        return SoundEvents.ENTITY_GENERIC_DEATH;
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
