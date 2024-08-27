package net.bbb13.friendsforgermod.datagen;

import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.LONSDALEITE_HELMET, ModItems.LONSDALEITE_CHESTPLATE, ModItems.LONSDALEITE_LEGGINGS, ModItems.LONSDALEITE_BOOTS);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.LONSDALEITE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.LONSDALEITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.LONSDALEITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.LONSDALEITE_HOE);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.LONSDALEITE_SWORD);

        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.MARKEE_SONG_MUSIC_DISC);

    }
}
