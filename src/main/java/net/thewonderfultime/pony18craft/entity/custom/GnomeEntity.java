package net.thewonderfultime.pony18craft.entity.custom;



import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


public class GnomeEntity extends PathAwareEntity implements GeoEntity{

    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache( this);

    public GnomeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }









    @Override
    protected Identifier getLootTableId() {
        //добавление таблицы лута к мобу
        return ModEntities.GNOME.getLootTableId();
    }

    @Override
    protected void initGoals() {


        // Добавляем цель "гулять по миру"
        this.goalSelector.add(2, new WanderAroundGoal(this, 0.3));
    }

    // Определяем базовые атрибуты
    public static DefaultAttributeContainer.Builder setAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10) // Здоровье
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8) // Скорость передвижения
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0); // Дальность видимости
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }


    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()){

            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.GnomeCockThief.walk",
                    Animation.LoopType.LOOP));

            return PlayState.CONTINUE;
        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.GnomeCockThief.idle",
                Animation.LoopType.LOOP));


        return PlayState.CONTINUE;
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
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }





    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!player.world.isClient && hand == Hand.MAIN_HAND) {
            // Проверяем, что игрок использует пустую руку
            if (player.getStackInHand(hand).isEmpty()) {
                // Создаём предметный стек (замени GNOME_ITEM на свой зарегистрированный предмет)
                ItemStack itemStack = new ItemStack(ModItems.THROWING_GNOME); // Зарегистрируй предмет

                // Удаляем сущность
                this.discard();

                // Спавним предмет на месте сущности
                player.world.spawnEntity(new ItemEntity(player.world, this.getX(), this.getY(), this.getZ(), itemStack));

                // Визуальный эффект (опционально)
//                ((ServerWorld) player.world).spawnParticles(ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 10, 0.2, 0.2, 0.2, 0.02);

                // Звук (опционально)
                player.world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 1.0F, 1.0F);

                return ActionResult.SUCCESS;
            } else {
                // Если игрок держит что-то в руке, можно вернуть сообщение или просто ничего не делать
                player.sendMessage(Text.literal("Освободите руку, чтобы преобразовать существо!"), true);
                return ActionResult.FAIL;
            }
        }

        return super.interactMob(player, hand);
    }











}
