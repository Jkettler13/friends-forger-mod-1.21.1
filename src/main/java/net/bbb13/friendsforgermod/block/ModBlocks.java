package net.bbb13.friendsforgermod.block;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.bbb13.friendsforgermod.block.custom.MedicineBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MEDICINE_BLOCK = registerBlock("medicine_block",
            new MedicineBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).luminance(state -> 8).requiresTool()));
    public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final Block GRADIENT_BLOCK = registerBlock("gradient_block",
            new Block(AbstractBlock.Settings.copy(Blocks.SCULK)));
    public static final Block MARBLE_BLOCK = registerBlock("marble_block",
            new Block(AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool()));


    public static final Block MARBLE_STAIRS = registerBlock("marble_stairs",
            new StairsBlock(ModBlocks.MARBLE_BLOCK.getDefaultState(), AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool()));
    public static final Block MARBLE_SLAB = registerBlock("marble_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool()));
    public static final Block MARBLE_WALL = registerBlock("marble_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.CALCITE).requiresTool()));

    private static void addItemsToNaturalBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.MARBLE_BLOCK);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FriendsForgerMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FriendsForgerMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FriendsForgerMod.LOGGER.info("Registering ModBlocks for " + FriendsForgerMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addItemsToNaturalBlocksItemGroup);
    }

}
