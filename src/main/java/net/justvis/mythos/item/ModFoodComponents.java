package net.justvis.mythos.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {

    public static FoodComponent CELESTIAL_BERRIES = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), 1)
            .build();
    public static FoodComponent PUMPKIN_SOUP = new FoodComponent.Builder()
            .hunger(6).saturationModifier(1.25f).build();
    public static FoodComponent BUTTER = new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.25f).build();
    public static FoodComponent VEGETABLE_STEW = new FoodComponent.Builder()
            .hunger(8).saturationModifier(1.6f).build();
    public static FoodComponent HERB_BUTTER = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.45f).build();
    public static FoodComponent HERB_COOKED_STEAK = new FoodComponent.Builder()
            .hunger(10).saturationModifier(2f).build();
    public static FoodComponent HERB_COOKED_MUTTON = new FoodComponent.Builder()
            .hunger(10).saturationModifier(2f).build();
}
