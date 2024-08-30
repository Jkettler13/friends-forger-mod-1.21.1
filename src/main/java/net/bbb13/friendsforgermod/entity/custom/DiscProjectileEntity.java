package net.bbb13.friendsforgermod.entity.custom;

import net.bbb13.friendsforgermod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.Objects;

public class DiscProjectileEntity extends ThrownItemEntity {
    public DiscProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public DiscProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.DISC_PROJECTILE,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CRE8IVES_DISC;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return super.createSpawnPacket(entityTrackerEntry);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if(!this.getWorld().isClient()){
            entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 10);
            entityHitResult.getEntity().dropStack(this.getStack(), (float) 1);

        }
        super.onEntityHit(entityHitResult);
    }

}
