package net.bbb13.friendsforgermod.datagen;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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
        itemModelGenerator.register(ModItems.ENERGY_DRINK, Models.GENERATED);
    }
}
