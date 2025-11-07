package net.bbb13.friendsforgermod.mixin;


import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useRubiksCubeModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(stack.isOf(ModItems.JONATHANS_RUBIKS_CUBE) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "jonathans_rubiks_cube_3d"), "inventory"));
        }
        if(stack.isOf(ModItems.WEB_GUN) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "web_gun_3d"), "inventory"));
        }
        if(stack.isOf(ModItems.CAT_ZOE)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "cat_zoe_3d"), "inventory"));
        }
        if(stack.isOf(ModItems.CAT_OLIVE)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "cat_olive_3d"), "inventory"));
        }
        if(stack.isOf(ModItems.CRE8VIES_BOOM_BOX) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "cre8ives_boom_box_3d"), "inventory"));
        }
        if(stack.isOf(ModItems.CRE8IVES_DISC) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Identifier.of(FriendsForgerMod.MOD_ID, "cre8ives_disc_3d"), "inventory"));
        }
        return value;
    }
}
