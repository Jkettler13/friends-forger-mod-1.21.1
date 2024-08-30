package net.bbb13.friendsforgermod.datagen;

import com.ibm.icu.text.Normalizer2;
import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Arm;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MEDICINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRADIENT_BLOCK);

        BlockStateModelGenerator.BlockTexturePool marblePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARBLE_BLOCK);
        marblePool.slab(ModBlocks.MARBLE_SLAB);
        marblePool.stairs(ModBlocks.MARBLE_STAIRS);
        marblePool.wall(ModBlocks.MARBLE_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.JONATHANS_RUBIKS_CUBE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JONATHANS_BLACK_BELT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLADERS_CONTROLLER, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENERGY_DRINK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRE8IVES_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRE8IVES_SKATEBOARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MARKEE_SONG_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRE8VIES_BOOM_BOX, Models.GENERATED);

        itemModelGenerator.register(ModItems.WEB_GUN, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.NET_AMMO, Models.GENERATED);

        itemModelGenerator.register(ModItems.LONSDALEITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAT_ZOE, Models.GENERATED);

        itemModelGenerator.register(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LONSDALEITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LONSDALEITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LONSDALEITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LONSDALEITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LONSDALEITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.LONSDALEITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LONSDALEITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LONSDALEITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.LONSDALEITE_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILK_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILK_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILK_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SILK_BOOTS);

        itemModelGenerator.register(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMERALD_BOOTS);

    }
}
