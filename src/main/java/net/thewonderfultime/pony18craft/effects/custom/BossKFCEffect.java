package net.thewonderfultime.pony18craft.effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;


public class BossKFCEffect extends StatusEffect {
    private static final float BASE_SIZE = 0.6F; // Стандартная ширина игрока
    private float currentWidthMultiplier = 1.0F;

    public BossKFCEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // Фиксированный множитель размера на основе уровня эффекта
            float widthMultiplier = 1.0f + (amplifier + 1 + 5) * 0.5f;

            if (currentWidthMultiplier != widthMultiplier) {
                // Обновляем хитбокс только при изменении размера
                float width = BASE_SIZE * widthMultiplier;
                float halfWidth = width / 2.0F;

                Box newBox = new Box(
                        player.getX() - halfWidth,
                        player.getY(),
                        player.getZ() - halfWidth,
                        player.getX() + halfWidth,
                        player.getY() + player.getHeight(),
                        player.getZ() + halfWidth
                );

                player.setBoundingBox(newBox);
                currentWidthMultiplier = widthMultiplier;
            }
        }
    }



    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            // Возвращаем стандартный размер хитбокса
            float halfWidth = BASE_SIZE / 2.0F;
            Box originalBox = new Box(
                    player.getX() - halfWidth,
                    player.getY(),
                    player.getZ() - halfWidth,
                    player.getX() + halfWidth,
                    player.getY() + player.getHeight(),
                    player.getZ() + halfWidth
            );

            player.setBoundingBox(originalBox);
            player.calculateDimensions(); // Принудительное обновление размеров
            currentWidthMultiplier = 1.0F;
        }
        super.onRemoved(entity, attributes, amplifier);
    }
}