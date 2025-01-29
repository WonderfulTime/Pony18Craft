package net.thewonderfultime.pony18craft.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.effects.custom.BossKFCEffect;
import net.thewonderfultime.pony18craft.effects.custom.SchizophreniaEffect;

public class ModEffects {
    public static final StatusEffect SCHIZOPHRENIA = registerEffect(
            "schizophrenia",
            new SchizophreniaEffect(StatusEffectCategory.HARMFUL, 0x5500AA)  // Цвет эффекта (фиолетовый)
    );


    public static final StatusEffect BOSS_KFC = registerEffect(
            "boss_kfc",
            new BossKFCEffect(StatusEffectCategory.BENEFICIAL, 0xFFD700)
    );

















    public static StatusEffect registerEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier("pony18craft", name), effect);
    }

    public static void registerModEffects() {
        System.out.println("Registering Mod Effects for modid");
    }
}

