package net.thewonderfultime.pony18craft.Item.custom.food;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CustomFoodWithEffects {

    public static final FoodComponent REGENERATION_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .hunger(4)
            .saturationModifier(2.0f)
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6 * 20, 1), 1.0f)
            .build();

    public static final FoodComponent RAW_ORESHEK = new FoodComponent.Builder()
            .snack()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 5 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20 * 20, 2), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE,  1, 0), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 5 * 20, 1), 1.0f)
            .build();



    public static final FoodComponent CHASHUSHULI = new FoodComponent.Builder()
            .snack()
            .hunger(10)
            .saturationModifier(10.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 40 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 80 * 20, 0), 1.0f)
            .build();

}
