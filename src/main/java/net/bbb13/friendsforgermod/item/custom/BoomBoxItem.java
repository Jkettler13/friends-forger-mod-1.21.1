package net.bbb13.friendsforgermod.item.custom;

import net.bbb13.friendsforgermod.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class BoomBoxItem extends Item {
    public BoomBoxItem(Settings settings) {
        super(settings);
    }
    public boolean isPlayingSong = false;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (hand == Hand.MAIN_HAND && !isPlayingSong){
            world.playSoundFromEntity(user, ModSounds.MARKEE_SONG_MUSIC_DISC, SoundCategory.PLAYERS,1,1);
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.friendsforgermod.cre8ives_boox_box.tooltip").formatted(Formatting.AQUA));
    }

}
