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
                        entries.add(ModItems.ENERGY_DRINK);

                        entries.add(ModItems.SLADERS_CONTROLLER);

                        entries.add(ModItems.CRE8IVES_DISC);
                        entries.add(ModItems.CRE8IVES_SKATEBOARD);
                        entries.add(ModItems.CRE8VIES_BOOM_BOX);
                        entries.add(ModItems.MARKEE_SONG_MUSIC_DISC);
                        entries.add(ModBlocks.MEDIA_BLOCK);

                        entries.add(ModItems.CAT_ZOE);
                        entries.add(ModItems.CAT_OLIVE);
                        entries.add(ModItems.LEXS_WINGS);

                        entries.add(ModItems.WEB_GUN);
                        entries.add(ModItems.NET_AMMO);
                        entries.add(ModItems.SILK);
                        entries.add(ModItems.SILK_HELMET);
                        entries.add(ModItems.SILK_CHESTPLATE);
                        entries.add(ModItems.SILK_LEGGINGS);
                        entries.add(ModItems.SILK_BOOTS);

                        entries.add(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.LONSDALEITE);
                        entries.add(ModItems.LONSDALEITE_SWORD);
                        entries.add(ModItems.LONSDALEITE_PICKAXE);
                        entries.add(ModItems.LONSDALEITE_AXE);
                        entries.add(ModItems.LONSDALEITE_SHOVEL);
                        entries.add(ModItems.LONSDALEITE_HOE);

                        entries.add(ModItems.LONSDALEITE_HELMET);
                        entries.add(ModItems.LONSDALEITE_CHESTPLATE);
                        entries.add(ModItems.LONSDALEITE_LEGGINGS);
                        entries.add(ModItems.LONSDALEITE_BOOTS);

                        entries.add(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.EMERALD_HELMET);
                        entries.add(ModItems.EMERALD_CHESTPLATE);
                        entries.add(ModItems.EMERALD_LEGGINGS);
                        entries.add(ModItems.EMERALD_BOOTS);

                        entries.add(ModBlocks.MEDICINE_BLOCK);
                        entries.add(ModBlocks.CHEESE_BLOCK);
                        entries.add(ModBlocks.GRADIENT_BLOCK);
                        entries.add(ModBlocks.MARBLE_BLOCK);
                        entries.add(ModBlocks.MARBLE_STAIRS);
                        entries.add(ModBlocks.MARBLE_SLAB);
                        entries.add(ModBlocks.MARBLE_WALL);
                    }).build());

    public static void registerItemGroups() {
        FriendsForgerMod.LOGGER.info("Registering Item Groups for " + FriendsForgerMod.MOD_ID);
    }
}
