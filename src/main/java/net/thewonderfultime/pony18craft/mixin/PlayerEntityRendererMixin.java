package net.thewonderfultime.pony18craft.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.thewonderfultime.pony18craft.effects.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {


    @Inject(method = "scale", at = @At("TAIL"))
    private void scalePlayerModel(AbstractClientPlayerEntity player, MatrixStack matrices, float amount, CallbackInfo ci) {
        if (player.hasStatusEffect(ModEffects.BOSS_KFC)) {
            int amplifier = player.getStatusEffect(ModEffects.BOSS_KFC).getAmplifier();
            float scale = 1.0f + (amplifier + 1 + 5) * 0.5f;

            // Применяем масштабирование ко всем осям
            matrices.scale(scale, 1.0f, scale);
        }
    }
}