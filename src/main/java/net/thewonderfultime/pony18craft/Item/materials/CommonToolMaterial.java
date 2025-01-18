package net.thewonderfultime.pony18craft.Item.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.thewonderfultime.pony18craft.Item.ModItems;

public class CommonToolMaterial implements ToolMaterial {

    /**
     * ToolMaterial не должен быть зарегистрирован. Хороший способ передать их инструментам,
     * которые в них нуждаются, - это сохранить где-нибудь экземпляр
     * (а затем ссылаться на него, когда он вам понадобится).
     * В этом случае мы поместим наш экземпляр в начало класса ToolMaterial:
     */
    public static final CommonToolMaterial INSTANCE = new CommonToolMaterial();


    // Новое свойство: дальность атаки
    private final float attackRange = 10.0f;
    @Override
    public int getDurability() {
        return 1000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 12;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }


    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.ORESHEK);
    }

    // Метод для получения дальности атаки
    public float getAttackRange() {
        return attackRange;
    }

}
