package net.bbb13.friendsforgermod.entity.custom;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<DiscProjectileEntity> DISC_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(FriendsForgerMod.MOD_ID, "disc_projectile"), EntityType.Builder.<DiscProjectileEntity>create( DiscProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build());
}
