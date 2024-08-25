package net.bbb13.friendsforgermod.datagen;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MEDICINE_BLOCK, 1)
                .pattern("DDD")
                .pattern("DRD")
                .pattern("DDD")
                .input('D', Items.DIAMOND_BLOCK)
                .input('R', ModItems.JONATHANS_RUBIKS_CUBE)
                .criterion(hasItem(ModItems.JONATHANS_RUBIKS_CUBE),conditionsFromItem(ModItems.JONATHANS_RUBIKS_CUBE))
                .criterion(hasItem(Items.DIAMOND_BLOCK),conditionsFromItem(Items.DIAMOND_BLOCK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MEDICINE_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JONATHANS_RUBIKS_CUBE, 1)
                .pattern("YRG")
                .pattern("XXX")
                .pattern("WOB")
                .input('Y', Items.YELLOW_WOOL)
                .input('R', Items.RED_WOOL)
                .input('G', Items.GREEN_WOOL)
                .input('X', Items.BLACK_WOOL)
                .input('W', Items.WHITE_WOOL)
                .input('O', Items.ORANGE_WOOL)
                .input('B', Items.BLUE_WOOL)
                .criterion(hasItem(Items.WHITE_WOOL),conditionsFromItem(Items.WHITE_WOOL))
                .criterion(hasItem(Items.YELLOW_WOOL),conditionsFromItem(Items.YELLOW_WOOL))
                .criterion(hasItem(Items.RED_WOOL),conditionsFromItem(Items.RED_WOOL))
                .criterion(hasItem(Items.GREEN_WOOL),conditionsFromItem(Items.GREEN_WOOL))
                .criterion(hasItem(Items.BLACK_WOOL),conditionsFromItem(Items.BLACK_WOOL))
                .criterion(hasItem(Items.ORANGE_WOOL),conditionsFromItem(Items.ORANGE_WOOL))
                .criterion(hasItem(Items.BLUE_WOOL),conditionsFromItem(Items.BLUE_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.JONATHANS_RUBIKS_CUBE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.JONATHANS_BLACK_BELT, 1)
                .pattern("XXX")
                .pattern(" X ")
                .pattern("X X")
                .input('X', Items.BLACK_WOOL)
                .criterion(hasItem(Items.BLACK_WOOL),conditionsFromItem(Items.BLACK_WOOL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.JONATHANS_BLACK_BELT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRADIENT_BLOCK, 3)
                .pattern("LAL")
                .pattern("LAL")
                .pattern("LAL")
                .input('L', Items.LAPIS_LAZULI)
                .input('A', Items.AMETHYST_SHARD)
                .criterion(hasItem(Items.LAPIS_LAZULI),conditionsFromItem(Items.LAPIS_LAZULI))
                .criterion(hasItem(Items.AMETHYST_SHARD),conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GRADIENT_BLOCK)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ENERGY_DRINK, 1)
                .input(Items.SUGAR)
                .input(Items.WATER_BUCKET)
                .criterion(hasItem(Items.SUGAR),conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.WATER_BUCKET),conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.ENERGY_DRINK)));
    }
}
