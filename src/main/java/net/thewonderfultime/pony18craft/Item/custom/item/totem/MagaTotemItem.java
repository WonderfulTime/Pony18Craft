package net.thewonderfultime.pony18craft.Item.custom.item.totem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.animatable.client.RenderProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.RenderUtils;
import java.util.UUID;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MagaTotemItem extends Item implements GeoItem {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    private boolean isActivated = false;
    private LivingEntity activeEntity = null;
    private UUID activeItemUUID = null;  // Используем UUID для отслеживания конкретного предмета

    public MagaTotemItem(Settings settings) {
        super(settings);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private final MagaTotemRenderer renderer = new MagaTotemRenderer();

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public double getTick(Object itemStack) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (isActivated) {
            AnimationController<?> controller = tAnimationState.getController();

            if (controller.hasAnimationFinished()) {
                applyTotemEffects();
                isActivated = false;
                controller.setAnimation(RawAnimation.begin().then("animation.maga_totem.idle", Animation.LoopType.LOOP));
            } else {
                controller.setAnimation(RawAnimation.begin().then("animation.maga_totem.dance", Animation.LoopType.PLAY_ONCE));
            }
        } else {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.maga_totem.idle", Animation.LoopType.LOOP));
        }

        return PlayState.CONTINUE;
    }

    private void applyTotemEffects() {
        if (activeEntity != null && !activeEntity.getWorld().isClient && activeItemUUID != null) {
            World world = activeEntity.getWorld();

            // Применяем эффекты
            activeEntity.setHealth(10.0F);
            activeEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
            activeEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));

            // Ищем и удаляем конкретный предмет в мире
            if (world instanceof ServerWorld) {
                // Проверяем инвентарь игрока
                if (activeEntity instanceof PlayerEntity player) {
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        ItemStack stack = player.getInventory().getStack(i);
                        if (isMatchingTotem(stack)) {
                            stack.setCount(0);
                            break;
                        }
                    }
                }

                // Если предмет был выброшен, ищем его в мире
                ((ServerWorld) world).getEntitiesByType(net.minecraft.entity.EntityType.ITEM,
                                entity -> isMatchingTotem(entity.getStack()))
                        .forEach(itemEntity -> itemEntity.discard());
            }

            // Очищаем ссылки
            activeEntity = null;
            activeItemUUID = null;
        }
    }

    private boolean isMatchingTotem(ItemStack stack) {
        if (!stack.isEmpty() && stack.getItem() instanceof MagaTotemItem) {
            UUID stackUUID = getItemUUID(stack);
            return stackUUID != null && stackUUID.equals(activeItemUUID);
        }
        return false;
    }

    private UUID getItemUUID(ItemStack stack) {
        if (stack.getNbt() != null && stack.getNbt().contains("TotemUUID")) {
            return stack.getNbt().getUuid("TotemUUID");
        }
        return null;
    }

    private void setItemUUID(ItemStack stack) {
        if (!stack.hasNbt()) {
            stack.setNbt(new net.minecraft.nbt.NbtCompound());
        }
        if (!stack.getNbt().contains("TotemUUID")) {
            stack.getNbt().putUuid("TotemUUID", UUID.randomUUID());
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public static void activateTotem(LivingEntity entity, ItemStack stack) {
        World world = entity.getWorld();

        // Воспроизводим звук
        world.playSound(null, entity.getBlockPos(), ModSounds.MAGA_TOTEM_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);

        // Активируем анимацию и сохраняем данные для последующего применения эффектов
        if (stack.getItem() instanceof MagaTotemItem totem) {
            // Убеждаемся, что у предмета есть UUID
            totem.setItemUUID(stack);

            totem.isActivated = true;
            totem.activeEntity = entity;
            totem.activeItemUUID = totem.getItemUUID(stack);
        }
    }
}