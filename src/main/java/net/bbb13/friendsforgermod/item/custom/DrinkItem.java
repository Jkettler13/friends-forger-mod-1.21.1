package net.bbb13.friendsforgermod.item.custom;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.UseAction;

import java.util.List;

public class DrinkItem extends Item {

    public DrinkItem(Settings settings) {
        super(settings);
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.friendsforgermod.energy_drink.tooltip").formatted(Formatting.YELLOW));
    }
}
