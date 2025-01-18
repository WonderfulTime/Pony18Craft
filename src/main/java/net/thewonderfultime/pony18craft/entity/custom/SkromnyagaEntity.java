package net.thewonderfultime.pony18craft.entity.custom;



import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;


public class SkromnyagaEntity extends PathAwareEntity implements GeoEntity{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache( this);

    public SkromnyagaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Identifier getLootTableId() {
        //добавление таблицы лута к мобу
        return ModEntities.SKROMNYAGA.getLootTableId();
    }

    @Override
    protected void initGoals() {
        // Добавляем цель "убегать от игрока"
        this.goalSelector.add(1, new FleeEntityGoal<>(this, PlayerEntity.class, 5.0f, 1.0, 1.2));

        // Добавляем цель "гулять по миру"
        this.goalSelector.add(2, new WanderAroundGoal(this, 1.0));
    }

    // Определяем базовые атрибуты
    public static DefaultAttributeContainer.Builder setAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10) // Здоровье
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3) // Скорость передвижения
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 4.0); // Дальность видимости
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()){

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.skromnyaga.walk",
                    Animation.LoopType.LOOP));

            return PlayState.CONTINUE;
        }

//        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.GnomeCockThief.idle",
//                Animation.LoopType.LOOP)); добавить idle анимацию


        return PlayState.CONTINUE;
    }


    private long lastAmbientSoundGameTime = 0; // Время последнего воспроизведения
    private int ambientSoundCooldownTicks = 200; // Начальное значение паузы (10 секунд)
    private final Random random = new Random(); // Для генерации случайных значений



    @Override
    protected SoundEvent getAmbientSound() {
        long currentGameTime = this.world.getTime(); // Получаем текущее игровое время в тиках

        // Проверяем, прошло ли достаточно времени с момента последнего звука
        if (currentGameTime - lastAmbientSoundGameTime >= ambientSoundCooldownTicks) {
            // Обновляем время последнего воспроизведения
            lastAmbientSoundGameTime = currentGameTime;

            // Генерируем случайное время для следующего звука (от 10 до 20 секунд)
            ambientSoundCooldownTicks = 200 + random.nextInt(201); // 200 (10 сек) + [0, 200] -> диапазон 200-400 тиков

            // Возвращаем звук для воспроизведения
            return ModSounds.SKROMNYAGA_AMBIENT_SOUND;
        }

        // Если пауза еще не закончилась, ничего не воспроизводим
        return null;
    }








    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}
