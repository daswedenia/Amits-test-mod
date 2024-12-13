package net.kaupenjoe.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    //making it like how minecraft would :sunglasses
    public static final FoodComponent ROTI = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200),0.15f).build();
    public static final FoodComponent BREAD_FLOUR = new FoodComponent.Builder().nutrition(1).saturationModifier(0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100),0.5f).build();

}
