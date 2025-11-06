package net.bbb13.friendsforgermod.item.custom;

import net.bbb13.friendsforgermod.item.ModItems;
import net.bbb13.friendsforgermod.sound.ModSounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;

import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


import java.util.List;


public class WebGunItem extends BowItem {
    public WebGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            ItemStack itemStack = playerEntity.getProjectileType(stack);
            if (!itemStack.isEmpty()) {
                int i = this.getMaxUseTime(stack, user) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = load(stack, itemStack, playerEntity);
                    if (world instanceof ServerWorld serverWorld && !list.isEmpty()) {
                        this.shootAll(serverWorld, playerEntity, playerEntity.getActiveHand(), stack, list, f * 3.0F, 1.0F, f == 1.0F, null);
                    }

                    world.playSound(
                            null,
                            playerEntity.getX(),
                            playerEntity.getY(),
                            playerEntity.getZ(),
                            ModSounds.WEB_GUN_HIT,
                            SoundCategory.PLAYERS,
                            1.0F,
                            1.0F
                    );
                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                }
            }
        }
    }


    public boolean getArrow(ItemStack stack) {
        // Check if the item stack is your custom arrow
        return stack.getItem() == ModItems.NET_AMMO;
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
