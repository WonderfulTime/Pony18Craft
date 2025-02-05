package net.thewonderfultime.pony18craft.Item.custom.item;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.block.ModBlocks;

import javax.swing.text.html.parser.Entity;

public class SkewerItem extends Item {
    public SkewerItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PigEntity) {
            if (!attacker.world.isClient) {  // Проверка, чтобы код выполнялся только на сервере
                target.kill();               // Удаление свиньи

                ItemStack newItem = new ItemStack(ModBlocks.SKEWER_WITH_PIG);

                if (attacker instanceof PlayerEntity player) {
                    boolean added = player.getInventory().insertStack(newItem);  // Сначала добавляем предмет

                    if (!added) {
                        // Если инвентарь полон, выбрасываем предмет рядом
                        player.dropItem(newItem, false);
                    }
                } else {
                    // Для не-игроков выбрасываем предмет в мир
                    attacker.world.spawnEntity(new ItemEntity(attacker.world, attacker.getX(), attacker.getY(), attacker.getZ(), newItem));
                }

                stack.decrement(1);  // Уменьшаем стек ПОСЛЕ добавления предмета
            }
        }
        return super.postHit(stack, target, attacker);
    }






}
