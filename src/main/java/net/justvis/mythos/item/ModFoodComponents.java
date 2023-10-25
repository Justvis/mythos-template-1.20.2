package net.justvis.mythos.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {

    public static FoodComponent CELESTIAL_BERRIES = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.25f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200), 1)
            .build();
}