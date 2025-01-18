package net.thewonderfultime.pony18craft.Item.custom.trinkets;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;

public class FlyAmuletTrinket extends TrinketItem {

    public FlyAmuletTrinket(Settings settings) {
        super(settings);
    }

    @Override
    public void onEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onEquip(stack, slot, entity);

        if (!entity.world.isClient) {
            // Добавляем эффект левитации
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 160, 0, false, false));
        }
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        super.onUnequip(stack, slot, entity);

        if (!entity.world.isClient) {
            // Убираем эффект левитации
            entity.removeStatusEffect(StatusEffects.LEVITATION);
        }
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!entity.world.isClient && entity.age % 100 == 0) { // Каждые 5 секунд
            // Обновляем эффект
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 160, 0, false, false));
        }
    }
}
