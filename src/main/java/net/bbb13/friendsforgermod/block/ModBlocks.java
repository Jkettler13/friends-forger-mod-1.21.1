package net.bbb13.friendsforgermod.block;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MEDICINE_BLOCK = registerBlock("medicine_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block CHEESE_BLOCK = registerBlock("cheese_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM_BLOCK)));

    public static final Block GRADIANT_BLOCK = registerBlock("gradiant_block",
            new Block(AbstractBlock.Settings.copy(Blocks.SCULK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FriendsForgerMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(FriendsForgerMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FriendsForgerMod.LOGGER.info("Registering ModBlocks for " + FriendsForgerMod.MOD_ID);
    }

}
