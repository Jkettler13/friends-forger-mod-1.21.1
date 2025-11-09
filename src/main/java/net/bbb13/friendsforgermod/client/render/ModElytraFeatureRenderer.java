package net.bbb13.friendsforgermod.client.render;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.item.ModItems;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class ModElytraFeatureRenderer<T extends LivingEntity, M extends net.minecraft.client.render.entity.model.EntityModel<T>>
        extends FeatureRenderer<T, M> {
        private final ModelPart leftWing;
        private final ModelPart rightWing;
        private static final Identifier TEXTURE =
                Identifier.of(FriendsForgerMod.MOD_ID, "textures/entity/elytra/lexs_wings.png");

        public ModElytraFeatureRenderer(FeatureRendererContext<T, M> context, ModelPart modelPart) {
            super(context);

            this.leftWing = modelPart.getChild("left_wing");
            this.rightWing = modelPart.getChild("right_wing");
        }
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
                       T entity, float limbAngle, float limbDistance, float tickDelta,
                       float animationProgress, float headYaw, float headPitch) {

        if (!entity.isInvisible() &&
                entity.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.LEXS_WINGS)) {

            matrices.push();

            // Align to player body
            if (this.getContextModel() instanceof net.minecraft.client.render.entity.model.PlayerEntityModel<?> playerModel) {
                this.leftWing.copyTransform(playerModel.body);
                this.rightWing.copyTransform(playerModel.body);
            }
            updateWingAngles(entity, animationProgress, limbDistance);

            // Render
            VertexConsumer vertexConsumer =
                    vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));

            leftWing.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
            rightWing.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

            matrices.pop();
        }

    }
    private void updateWingAngles(T entity, float animationProgress, float limbDistance) {
        float pitch = (float) (Math.PI / 12);
        float roll = (float) (Math.PI / 36);
        float pivotY = 0.0F;
        float yaw = 0.0F;

        boolean isSneaking = entity.isInSneakingPose();
        boolean isFlying = entity.isFallFlying();


        if (isFlying) {
            pitch = (float) Math.toRadians(20);
            roll = (float) Math.toRadians(-100);
        }

        else if (isSneaking) {
            pitch = (float) Math.toRadians(40);
            roll  = (float) Math.toRadians(25);
            pivotY = 4.0F;
            yaw   = 0.08726646F;
        } else {
            float sway = (float) Math.sin(animationProgress * 0.067F) * 0.03F;

            float movementSpread = limbDistance * 0.1F;
            pitch += movementSpread;
            roll -= sway - movementSpread;
            yaw  += sway * 0.75F;
        }

        if (entity instanceof AbstractClientPlayerEntity player) {
            player.elytraPitch += (pitch - player.elytraPitch) * 0.1F;
            player.elytraYaw   += (yaw - player.elytraYaw) * 0.1F;
            player.elytraRoll  += (roll - player.elytraRoll) * 0.1F;

            leftWing.pitch = player.elytraPitch;
            leftWing.yaw   = player.elytraYaw;
            leftWing.roll  = player.elytraRoll;
        } else {
            leftWing.pitch = pitch;
            leftWing.yaw   = yaw;
            leftWing.roll  = roll;
        }
            rightWing.pitch  = leftWing.pitch;
            rightWing.roll   = -leftWing.roll;
            rightWing.yaw    = -leftWing.yaw;
            rightWing.pivotY = pivotY;
            leftWing.pivotY  = pivotY;
        }
    }



