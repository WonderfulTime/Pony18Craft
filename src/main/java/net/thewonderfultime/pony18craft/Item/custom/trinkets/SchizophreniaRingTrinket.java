package net.thewonderfultime.pony18craft.Item.custom.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.thewonderfultime.pony18craft.effects.ModEffects;

public class SchizophreniaRingTrinket extends TrinketItem {
    public SchizophreniaRingTrinket(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        if (!entity.world.isClient) {
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.SCHIZOPHRENIA, 426*20, 0, false, false));
            System.out.println("[DEBUG] Schizophrenia effect applied!");
        }
    }


    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.world.isClient && entity.age % 100 == 0) { // Каждые 5 секунд (100 тиков)
            // Обновляем эффект
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.SCHIZOPHRENIA, 426*20, 0, false, false));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);

        if (!entity.world.isClient) {
            entity.removeStatusEffect(ModEffects.SCHIZOPHRENIA);
            System.out.println("[DEBUG] Schizophrenia effect removed!");
        }
    }


}
