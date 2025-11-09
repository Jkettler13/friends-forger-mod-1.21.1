package net.bbb13.friendsforgermod.entity.custom;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEntityAttributes {
    public static final RegistryEntry<EntityAttribute> ELYTRA_ROCKET_SPEED = Registry.registerReference(Registries.ATTRIBUTE, Identifier.of(FriendsForgerMod.MOD_ID, "elytra_rocket_speed") , new ClampedEntityAttribute("attribute.name.generic.friendsforgermod.elytra_rocket_speed", 1, 0, 1024).setTracked(true));
}