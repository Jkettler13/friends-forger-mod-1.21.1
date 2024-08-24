package net.bbb13.friendsforgermod.item;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {

    public static final ItemGroup FRIEND_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FriendsForgerMod.MOD_ID, "friends_items"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.friends_items"))
                    .icon(() -> new ItemStack(ModItems.JONATHANS_BLACK_BELT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.JONATHANS_BLACK_BELT);
                        entries.add(ModItems.JONATHANS_RUBIKS_CUBE);

                        entries.add(ModBlocks.MEDICINE_BLOCK);
                        entries.add(ModBlocks.CHEESE_BLOCK);
                        entries.add(ModBlocks.GRADIANT_BLOCK);
                        entries.add(ModBlocks.MARBLE_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        FriendsForgerMod.LOGGER.info("Registering Item Groups for " + FriendsForgerMod.MOD_ID);
    }
}
