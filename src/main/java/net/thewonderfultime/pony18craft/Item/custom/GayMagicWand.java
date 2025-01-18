package net.thewonderfultime.pony18craft.Item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

/**
 * Этот кастомный итем позволяет превращать врагов в дружелюбных существ-гей-гномиков
 *
 */
public class GayMagicWand extends Item {
    public GayMagicWand(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        /**
         * проверка происходит ли действие на сервере
         *
         */
        if(!user.getWorld().isClient() && hand == Hand.MAIN_HAND){
            /**
             * потом заменить на превращение в гей-гномика
             */
            entity.setCustomName(Text.literal("Dinnerbone"));


            stack.damage(1, user, e -> e.sendToolBreakStatus(hand));
        }

        return ActionResult.PASS;
    }
}
