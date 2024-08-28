package net.bbb13.friendsforgermod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.bbb13.friendsforgermod.item.ModArmorMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterial.LONSDALEITE.value(), new StatusEffectInstance(StatusEffects.SPEED, -1, 0,
                            false, false, true))
                    .put(ModArmorMaterial.SILK.value(), new StatusEffectInstance(StatusEffects.SLOW_FALLING , -1, 0,
                            false, false, true)).build();


    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player ){
                evaluateArmorEffects(player);
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            } else if (player.hasStatusEffect(mapStatusEffect.getEffectType())) {
                player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
                player.removeStatusEffect(mapStatusEffect.getEffectType());
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, StatusEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.getEffectType());

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.setStatusEffect(new StatusEffectInstance(mapStatusEffect),player);
            if (mapArmorMaterial.equals(ModArmorMaterial.LONSDALEITE.value())) {
                player.setStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, -1, 0,
                        false, false, true), player);
            }
        } else if (!(hasCorrectArmorOn(mapArmorMaterial, player) && hasPlayerEffect)) {
            player.removeStatusEffect(StatusEffects.HEALTH_BOOST);
            player.removeStatusEffect(mapStatusEffect.getEffectType());
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
        }


    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial().value() == material && breastplate.getMaterial().value() == material &&
                leggings.getMaterial().value() == material && boots.getMaterial().value() == material;

    }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        ArmorItem armorItem = (ArmorItem) stack.getItem();
        if(armorItem.getMaterial() == ModArmorMaterial.LONSDALEITE) {
            tooltip.add(Text.translatable("tooltip.friendsforgermod.mod_armor_item.tooltip").formatted(Formatting.AQUA));
        }
        if(armorItem.getMaterial() == ModArmorMaterial.SILK) {
            tooltip.add(Text.translatable("tooltip.friendsforgermod.mod_armor_item2.tooltip").formatted(Formatting.AQUA));
        }

    }

}

