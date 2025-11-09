package net.bbb13.friendsforgermod.item.custom;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.entity.custom.ModEntityAttributes;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ModElytraItem extends ElytraItem implements Equipment, FabricElytraItem {
    public ModElytraItem(Item.Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }
    @Override
    public boolean useCustomElytra(LivingEntity entity, ItemStack chestStack, boolean tickElytra) {
        if (tickElytra) {
            FabricElytraItem.super.doVanillaElytraTick(entity, chestStack);
        }
        return true;
    }

    public static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.SILK);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return this.equipAndSwap(this, world, user, hand);
    }

    @Override
    public RegistryEntry<SoundEvent> getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA;
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.CHEST;
    }

    public static AttributeModifiersComponent createDefaultAttributes() {
        var builder = AttributeModifiersComponent.builder();
        var armor = new EntityAttributeModifier(Identifier.of(FriendsForgerMod.MOD_ID,"lexs_wings_armor_protection"), 5.0F, EntityAttributeModifier.Operation.ADD_VALUE);
        var toughness = new EntityAttributeModifier(Identifier.of(FriendsForgerMod.MOD_ID,"lexs_wings_armor_toughness"), 3.0F, EntityAttributeModifier.Operation.ADD_VALUE);
        var speed = new EntityAttributeModifier(Identifier.of(FriendsForgerMod.MOD_ID,"lexs_wings_speed_bonus"), 0.08F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        var rocketSpeedBonus = new EntityAttributeModifier(Identifier.of(FriendsForgerMod.MOD_ID,"lexs_wings_rocket_speed_bonus"), 0.20F, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
        builder.add(EntityAttributes.GENERIC_ARMOR, armor, AttributeModifierSlot.CHEST);
        builder.add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, toughness, AttributeModifierSlot.CHEST);
        builder.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, speed, AttributeModifierSlot.CHEST);
        builder.add(ModEntityAttributes.ELYTRA_ROCKET_SPEED, rocketSpeedBonus, AttributeModifierSlot.CHEST);
        return builder.build();
    }
}

