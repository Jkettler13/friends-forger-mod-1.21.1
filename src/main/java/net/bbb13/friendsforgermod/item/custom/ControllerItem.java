package net.bbb13.friendsforgermod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Objects;

public class ControllerItem extends Item {
    public ControllerItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            BlockState state = context.getWorld().getBlockState(positionClicked);
            if(state.isOf(Blocks.SPAWNER)||state.isOf(Blocks.CHEST)){
                assert player != null;
                player.sendMessage(Text.literal("Rerolling " + state.getBlock().getName().getString() + "! Good Luck!"), true);
                context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), EquipmentSlot.MAINHAND);
            }

        }


        return ActionResult.SUCCESS;
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        user.sendMessage(Text.literal(entity.getType().toString()));
        return ActionResult.SUCCESS;
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.friendsforgermod.sladers_controller.tooltip").withColor(6381921));
    }
}
