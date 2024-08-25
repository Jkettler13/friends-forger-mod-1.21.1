package net.bbb13.friendsforgermod.datagen;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHEESE_BLOCK);
        addDrop(ModBlocks.MEDICINE_BLOCK);
        addDrop(ModBlocks.GRADIENT_BLOCK);

        addDrop(ModBlocks.MARBLE_BLOCK);
        addDrop(ModBlocks.MARBLE_STAIRS);
        addDrop(ModBlocks.MARBLE_WALL);
        addDrop(ModBlocks.MARBLE_SLAB,slabDrops(ModBlocks.MARBLE_SLAB));
    }
}
