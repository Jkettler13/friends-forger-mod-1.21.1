package net.bbb13.friendsforgermod.item;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.item.custom.*;
import net.bbb13.friendsforgermod.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;

import java.util.List;


public class ModItems {

    public static final Item JONATHANS_BLACK_BELT = registerItem("jonathans_black_belt", new Item( new Item.Settings()));
    public static final Item JONATHANS_RUBIKS_CUBE = registerItem("jonathans_rubiks_cube", new Item( new Item.Settings()));
    public static final Item SLADERS_CONTROLLER = registerItem("sladers_controller", new ControllerItem(new Item.Settings().maxDamage(1).rarity(Rarity.EPIC)));
    public static final Item ENERGY_DRINK = registerItem("energy_drink", new DrinkItem( new Item.Settings().food(ModFoodComponents.ENERGY_DRINK)));
    public static final Item CRE8IVES_DISC = registerItem("cre8ives_disc", new DiscItem(new Item.Settings()));
    public static final Item CRE8IVES_SKATEBOARD = registerItem("cre8ives_skateboard", new SkateboardItem(new Item.Settings().maxCount(1)));
    public static final Item CRE8VIES_BOOM_BOX = registerItem("cre8ives_boom_box", new BoomBoxItem(new Item.Settings().maxCount(1).rarity(Rarity.RARE)));
    public static final Item MARKEE_SONG_MUSIC_DISC = registerItem("markee_song_music_disc", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE).jukeboxPlayable(ModSounds.MARKEE_SONG)));
    public static final Item CAT_ZOE = registerItem("cat_zoe", new Item( new Item.Settings()));
    public static final Item CAT_OLIVE = registerItem("cat_olive", new Item(new Item.Settings()));

    public static final Item WEB_GUN = registerItem("web_gun", new WebGunItem(new Item.Settings().maxCount(1)));
    public static final Item NET_AMMO = registerItem("net_ammo", new NetAmmoItem(new Item.Settings()));

    public static final Item LEXS_WINGS = registerItem("lexs_wings", new ModElytraItem(new Item.Settings().maxCount(1).maxDamage(432).rarity(Rarity.UNCOMMON)));
    public static final Item SILK = registerItem("silk", new Item(new Item.Settings()));
    public static final Item SILK_HELMET = registerItem("silk_helmet", new ModArmorItem(ModArmorMaterial.SILK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(25))));
    public static final Item SILK_CHESTPLATE = registerItem("silk_chestplate", new ModArmorItem(ModArmorMaterial.SILK, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));
    public static final Item SILK_LEGGINGS = registerItem("silk_leggings", new ModArmorItem(ModArmorMaterial.SILK, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));
    public static final Item SILK_BOOTS = registerItem("silk_boots", new ModArmorItem(ModArmorMaterial.SILK, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));


    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.ofVanilla("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = Identifier.ofVanilla("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = Identifier.ofVanilla("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.ofVanilla("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.ofVanilla("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE = Identifier.ofVanilla("item/empty_slot_ingot");

    private static final Text LONSDALEITE_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.lonsdaleite_upgrade.applies_to"))
            )
            .formatted(Formatting.BLUE);
    private static final Text LONSDALEITE_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.lonsdaleite_upgrade.ingredients"))
            )
            .formatted(Formatting.BLUE);
    private static final Text LONSDALEITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.lonsdaleite_upgrade.base_slot_description"))
    );
    private static final Text LONSDALEITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.lonsdaleite_upgrade.additions_slot_description"))
    );
    private static final Text LONSDALEITE_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of("friendsforgermod","lonsdaleite_upgrade")))
            .formatted(Formatting.GRAY);

    private static List<Identifier> getLonsdaleiteUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_SLOT_SWORD_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_SLOT_PICKAXE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_SLOT_AXE_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE,
                EMPTY_SLOT_HOE_TEXTURE,
                EMPTY_SLOT_SHOVEL_TEXTURE
        );
    }

    private static List<Identifier> getEmeraldUpgradeEmptyBaseSlotTextures() {
        return List.of(
                EMPTY_ARMOR_SLOT_HELMET_TEXTURE,
                EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE,
                EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE,
                EMPTY_ARMOR_SLOT_BOOTS_TEXTURE
        );
    }

    private static List<Identifier> getUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    public static final Item LONSDALEITE_UPGRADE_SMITHING_TEMPLATE = registerItem("lonsdaleite_upgrade_smithing_template", new SmithingTemplateItem(
            LONSDALEITE_UPGRADE_APPLIES_TO_TEXT,
            LONSDALEITE_UPGRADE_INGREDIENTS_TEXT,
            LONSDALEITE_UPGRADE_TEXT,
            LONSDALEITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            LONSDALEITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            getLonsdaleiteUpgradeEmptyBaseSlotTextures(),
            getUpgradeEmptyAdditionsSlotTextures()));

    public static final Item LONSDALEITE = registerItem("lonsdaleite", new Item(new Item.Settings()));
    public static final Item LONSDALEITE_SWORD = registerItem("lonsdaleite_sword", new SwordItem(ModToolMaterial.LONSDALEITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.LONSDALEITE,3,-2.4f))));
    public static final Item LONSDALEITE_PICKAXE = registerItem("lonsdaleite_pickaxe", new PickaxeItem(ModToolMaterial.LONSDALEITE,new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.LONSDALEITE,1.0f,-2.8f))));
    public static final Item LONSDALEITE_AXE = registerItem("lonsdaleite_axe", new AxeItem(ModToolMaterial.LONSDALEITE,new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.LONSDALEITE,5.0f,-3.0f))));
    public static final Item LONSDALEITE_SHOVEL = registerItem("lonsdaleite_shovel", new ShovelItem(ModToolMaterial.LONSDALEITE,new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.LONSDALEITE,1.5f,-3.0f))));
    public static final Item LONSDALEITE_HOE = registerItem("lonsdaleite_hoe", new HoeItem(ModToolMaterial.LONSDALEITE,new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.LONSDALEITE,-4,0.0f))));

    public static final Item LONSDALEITE_HELMET = registerItem("lonsdaleite_helmet", new ModArmorItem(ModArmorMaterial.LONSDALEITE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item LONSDALEITE_CHESTPLATE = registerItem("lonsdaleite_chestplate", new ModArmorItem(ModArmorMaterial.LONSDALEITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item LONSDALEITE_LEGGINGS = registerItem("lonsdaleite_leggings", new ModArmorItem(ModArmorMaterial.LONSDALEITE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item LONSDALEITE_BOOTS = registerItem("lonsdaleite_boots", new ModArmorItem(ModArmorMaterial.LONSDALEITE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));


    private static final Text EMERALD_UPGRADE_APPLIES_TO_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.emerald_upgrade.applies_to"))
            )
            .formatted(Formatting.BLUE);
    private static final Text EMERALD_UPGRADE_INGREDIENTS_TEXT = Text.translatable(
                    Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.emerald_upgrade.ingredients"))
            )
            .formatted(Formatting.BLUE);
    private static final Text EMERALD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.emerald_upgrade.base_slot_description"))
    );
    private static final Text EMERALD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(
            Util.createTranslationKey("item", Identifier.of("friendsforgermod","smithing_template.emerald_upgrade.additions_slot_description"))
    );
    private static final Text EMERALD_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of("friendsforgermod","emerald_upgrade")))
            .formatted(Formatting.GRAY);


    public static final Item EMERALD_UPGRADE_SMITHING_TEMPLATE = registerItem("emerald_upgrade_smithing_template", new SmithingTemplateItem(
            EMERALD_UPGRADE_APPLIES_TO_TEXT,
            EMERALD_UPGRADE_INGREDIENTS_TEXT,
            EMERALD_UPGRADE_TEXT,
            EMERALD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            EMERALD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            getEmeraldUpgradeEmptyBaseSlotTextures(),
            getUpgradeEmptyAdditionsSlotTextures()));


    public static final Item EMERALD_HELMET = registerItem("emerald_helmet", new ModArmorItem(ModArmorMaterial.EMERALD, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(28))));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate", new ModArmorItem(ModArmorMaterial.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(28))));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings", new ModArmorItem(ModArmorMaterial.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(28))));
    public static final Item EMERALD_BOOTS = registerItem("emerald_boots", new ModArmorItem(ModArmorMaterial.EMERALD, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(28))));




    private static void addItemsToToolTabItemGroup(FabricItemGroupEntries entries){entries.add(MARKEE_SONG_MUSIC_DISC);}

    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ENERGY_DRINK);
    }
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(JONATHANS_RUBIKS_CUBE);
        entries.add(LONSDALEITE);
        entries.add(SILK);
    }
    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(JONATHANS_BLACK_BELT);
        entries.add(CRE8IVES_DISC);
        entries.add(LONSDALEITE_SWORD);
        entries.add(LONSDALEITE_AXE);
        entries.add(LONSDALEITE_HELMET);
        entries.add(LONSDALEITE_CHESTPLATE);
        entries.add(LONSDALEITE_LEGGINGS);
        entries.add(LONSDALEITE_BOOTS);
        entries.add(WEB_GUN);
        entries.add(SILK_HELMET);
        entries.add(SILK_CHESTPLATE);
        entries.add(SILK_LEGGINGS);
        entries.add(SILK_BOOTS);
        entries.add(EMERALD_HELMET);
        entries.add(EMERALD_CHESTPLATE);
        entries.add(EMERALD_LEGGINGS);
        entries.add(EMERALD_BOOTS);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FriendsForgerMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FriendsForgerMod.LOGGER.info("Registering Mod items for " + FriendsForgerMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolTabItemGroup);
    }

}
