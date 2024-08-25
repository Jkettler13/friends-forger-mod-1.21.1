package net.bbb13.friendsforgermod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent ENERGY_DRINK = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 2),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400), 1.0f)
            .build();
}
