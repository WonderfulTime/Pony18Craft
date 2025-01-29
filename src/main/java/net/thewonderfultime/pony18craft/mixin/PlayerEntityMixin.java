package net.thewonderfultime.pony18craft.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;

import net.thewonderfultime.pony18craft.effects.ModEffects;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {


    @Inject(method = "getDimensions", at = @At("HEAD"), cancellable = true)
    private void modifyPlayerDimensions(EntityPose pose, CallbackInfoReturnable<EntityDimensions> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (player.hasStatusEffect(ModEffects.BOSS_KFC)) {
            int amplifier = player.getStatusEffect(ModEffects.BOSS_KFC).getAmplifier();

            // Базовые размеры
            float newWidth = 0.6F * (1.0f + (amplifier + 1 + 5) * 0.5f);
            float newHeight = 1.8F; // Если надо менять, можешь поменять

            // Возвращаем новые размеры
            cir.setReturnValue(EntityDimensions.changing(newWidth, newHeight));
        }
    }



    @Inject(method = "tick", at = @At("HEAD"))
    private void forceUpdateDimensions(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.hasStatusEffect(ModEffects.BOSS_KFC)) {
            player.calculateDimensions(); // Принудительное обновление размеров
        }

        if (player.hasStatusEffect(ModEffects.BOSS_KFC) ||
                player.age % 20 == 0) { // Периодическая проверка для сброса размера
            player.calculateDimensions();
        }
    }



}



