package net.thewonderfultime.pony18craft.world.custom_events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.thewonderfultime.pony18craft.Item.custom.item.totem.MagaTotemItem;

public class CustomTotemEventHandler {

    public static void register() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
            if (entity instanceof PlayerEntity player) {
                return handleTotemActivation(player, amount);
            }
            return true;
        });
    }

    private static boolean handleTotemActivation(PlayerEntity player, float damage) {
        //  Проверяем, приведёт ли урон к смерти
        if (player.getHealth() - damage <= 0.0F) {
            for (Hand hand : Hand.values()) {
                ItemStack stack = player.getStackInHand(hand);
                if (stack.getItem() instanceof MagaTotemItem) {
                    //  Активируем тотем
                    MagaTotemItem.activateTotem(player, stack);

                    // Отменяем смертельный урон
                    player.setHealth(10.0F);
//                    stack.decrement(1); // Удаляем использованный тотем
                    return false; // Блокируем смерть
                }
            }
        }
        return true; // Позволяем урону пройти, если тотем не сработал
    }
}