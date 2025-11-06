package net.bbb13.friendsforgermod;

import net.bbb13.friendsforgermod.entity.custom.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class FriendsForgerModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.DISC_PROJECTILE, FlyingItemEntityRenderer::new);
    }
}
