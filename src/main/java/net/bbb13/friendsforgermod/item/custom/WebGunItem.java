package net.bbb13.friendsforgermod.item.custom;

import net.bbb13.friendsforgermod.sound.ModSounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;

import net.minecraft.text.Text;

import net.minecraft.util.Formatting;


import java.util.List;

public class WebGunItem extends Item {
    public WebGunItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.playSound(ModSounds.WEB_GUN_HIT, 100.0f, 1.0f);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,40, 255));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 40, 255));

        if (attacker instanceof PlayerEntity){
            attacker.sendMessage(Text.of(attacker.getName().getString() + " stunned " + target.getName().getString() + "!"));
        }


        return false;
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.friendsforgermod.web_gun.tooltip").formatted(Formatting.GOLD));
    }


}
