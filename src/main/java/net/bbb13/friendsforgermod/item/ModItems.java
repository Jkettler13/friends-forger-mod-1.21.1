package net.bbb13.friendsforgermod.item;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.item.custom.DrinkItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModItems {
    public static final Item JONATHANS_BLACK_BELT = registerItem("jonathans_black_belt", new Item( new Item.Settings()));
    public static final Item JONATHANS_RUBIKS_CUBE = registerItem("jonathans_rubiks_cube", new Item( new Item.Settings()));
    public static final Item ENERGY_DRINK = registerItem("energy_drink", new DrinkItem( new Item.Settings().food(ModFoodComponents.ENERGY_DRINK)));
    public static final Item CRE8IVES_DISC = registerItem("cre8ives_disc", new Item(new Item.Settings()));
    public static final Item LONSDALEITE = registerItem("lonsdaleite", new Item(new Item.Settings()));

    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENERGY_DRINK);
    }
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(JONATHANS_RUBIKS_CUBE);
        entries.add(LONSDALEITE);
    }
    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(JONATHANS_BLACK_BELT);
        entries.add(CRE8IVES_DISC);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FriendsForgerMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FriendsForgerMod.LOGGER.info("Registering Mod items for " + FriendsForgerMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
    }

}
