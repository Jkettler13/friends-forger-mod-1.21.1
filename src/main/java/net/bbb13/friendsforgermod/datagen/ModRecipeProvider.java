package net.bbb13.friendsforgermod.datagen;

import net.bbb13.friendsforgermod.block.ModBlocks;
import net.bbb13.friendsforgermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
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

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.MARBLE_SLAB, Ingredient.ofItems(ModBlocks.MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.MARBLE_BLOCK),conditionsFromItem(ModBlocks.MARBLE_BLOCK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARBLE_SLAB)));

        createStairsRecipe(ModBlocks.MARBLE_STAIRS, Ingredient.ofItems(ModBlocks.MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.MARBLE_BLOCK),conditionsFromItem(ModBlocks.MARBLE_BLOCK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARBLE_STAIRS)));

        getWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_WALL, Ingredient.ofItems(ModBlocks.MARBLE_BLOCK))
                .criterion(hasItem(ModBlocks.MARBLE_BLOCK),conditionsFromItem(ModBlocks.MARBLE_BLOCK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARBLE_WALL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WEB_GUN, 1)
                .pattern(" S ")
                .pattern("GLG")
                .input('S', Items.SPIDER_EYE)
                .input('G', Items.GOLD_BLOCK)
                .input('L', Items.CROSSBOW)
                .criterion(hasItem(Items.SPIDER_EYE),conditionsFromItem(Items.SPIDER_EYE))
                .criterion(hasItem(Items.GOLD_BLOCK),conditionsFromItem(Items.GOLD_BLOCK))
                .criterion(hasItem(Items.CROSSBOW),conditionsFromItem(Items.CROSSBOW))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WEB_GUN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NET_AMMO, 3)
                .pattern(" T ")
                .pattern("#S#")
                .pattern(" T ")
                .input('T', Items.STRING)
                .input('#', Items.STICK)
                .input('S', ModItems.SILK)
                .criterion(hasItem(Items.STRING),conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.STICK),conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.SILK),conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.NET_AMMO)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRE8VIES_BOOM_BOX, 1)
                .pattern(" B ")
                .pattern("IJI")
                .pattern(" C ")
                .input('B', Items.BLAZE_ROD)
                .input('I', Items.IRON_BLOCK)
                .input('J', Items.JUKEBOX)
                .input('C', Items.GRAY_CARPET)
                .criterion(hasItem(Items.BLAZE_ROD),conditionsFromItem(Items.BLAZE_ROD))
                .criterion(hasItem(Items.IRON_BLOCK),conditionsFromItem(Items.IRON_BLOCK))
                .criterion(hasItem(Items.JUKEBOX),conditionsFromItem(Items.JUKEBOX))
                .criterion(hasItem(Items.GRAY_CARPET),conditionsFromItem(Items.GRAY_CARPET))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CRE8VIES_BOOM_BOX)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILK_HELMET, 1)
                .pattern("LLL")
                .pattern("L L")
                .input('L', ModItems.SILK)
                .criterion(hasItem(ModItems.SILK),conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SILK_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILK_CHESTPLATE, 1)
                .pattern("L L")
                .pattern("LLL")
                .pattern("LLL")
                .input('L', ModItems.SILK)
                .criterion(hasItem(ModItems.SILK),conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SILK_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILK_LEGGINGS, 1)
                .pattern("LLL")
                .pattern("L L")
                .pattern("L L")
                .input('L', ModItems.SILK)
                .criterion(hasItem(ModItems.SILK),conditionsFromItem(ModItems.SILK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SILK_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SILK_BOOTS, 1)
                .pattern("E E")
                .pattern("L L")
                .input('E', Items.SPIDER_EYE)
                .input('L', ModItems.SILK)
                .criterion(hasItem(ModItems.SILK),conditionsFromItem(ModItems.SILK))
                .criterion(hasItem(Items.SPIDER_EYE),conditionsFromItem(Items.SPIDER_EYE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.SILK_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRE8IVES_SKATEBOARD, 1)
                .pattern("LLL")
                .pattern("I I")
                .input('L', Items.DARK_OAK_LOG)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.DARK_OAK_LOG),conditionsFromItem(Items.DARK_OAK_LOG))
                .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.CRE8IVES_SKATEBOARD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("DTD")
                .pattern("DSD")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('T', ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE)
                .input('S', Items.DEEPSLATE)
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.DIAMOND),conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.DEEPSLATE),conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE, 2)
                .pattern("ETE")
                .pattern("EBE")
                .pattern("EEE")
                .input('E', Items.EMERALD_BLOCK)
                .input('T', ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE)
                .input('B', Items.BELL)
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.EMERALD_BLOCK),conditionsFromItem(Items.EMERALD_BLOCK))
                .criterion(hasItem(Items.BELL),conditionsFromItem(Items.BELL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE)));

        //lonsdaleite armor smithing
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.LONSDALEITE_HELMET,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_HELMET),conditionsFromItem(Items.DIAMOND_HELMET))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.LONSDALEITE_CHESTPLATE,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_CHESTPLATE),conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.LONSDALEITE_LEGGINGS,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_LEGGINGS),conditionsFromItem(Items.DIAMOND_LEGGINGS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.LONSDALEITE_BOOTS,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_BOOTS),conditionsFromItem(Items.DIAMOND_BOOTS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_BOOTS)));

        //lonsdaleite tools smithing
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_SWORD),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.TOOLS,
                        new ItemStack(ModItems.LONSDALEITE_SWORD,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_SWORD),conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_SWORD)));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_AXE),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.TOOLS,
                        new ItemStack(ModItems.LONSDALEITE_AXE,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_AXE),conditionsFromItem(Items.DIAMOND_AXE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_AXE)));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_PICKAXE),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.TOOLS,
                        new ItemStack(ModItems.LONSDALEITE_PICKAXE,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_PICKAXE),conditionsFromItem(Items.DIAMOND_PICKAXE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_PICKAXE)));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_SHOVEL),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.TOOLS,
                        new ItemStack(ModItems.LONSDALEITE_SHOVEL,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_SHOVEL),conditionsFromItem(Items.DIAMOND_SHOVEL))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_SHOVEL)));
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HOE),
                        Ingredient.ofItems(ModItems.LONSDALEITE),
                        RecipeCategory.TOOLS,
                        new ItemStack(ModItems.LONSDALEITE_HOE,1).getItem())
                .criterion(hasItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.LONSDALEITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(ModItems.LONSDALEITE),conditionsFromItem(ModItems.LONSDALEITE))
                .criterion(hasItem(Items.DIAMOND_HOE),conditionsFromItem(Items.DIAMOND_HOE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.LONSDALEITE_HOE)));

        //emerald armor smithing
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_HELMET),
                        Ingredient.ofItems(Items.EMERALD),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.EMERALD_HELMET,1).getItem())
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.EMERALD),conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.GOLDEN_HELMET),conditionsFromItem(Items.GOLDEN_HELMET))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.EMERALD_HELMET)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_CHESTPLATE),
                        Ingredient.ofItems(Items.EMERALD),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.EMERALD_CHESTPLATE,1).getItem())
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.EMERALD),conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.GOLDEN_CHESTPLATE),conditionsFromItem(Items.GOLDEN_CHESTPLATE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.EMERALD_CHESTPLATE)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_LEGGINGS),
                        Ingredient.ofItems(Items.EMERALD),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.EMERALD_LEGGINGS,1).getItem())
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.EMERALD),conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.GOLDEN_LEGGINGS),conditionsFromItem(Items.GOLDEN_LEGGINGS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.EMERALD_LEGGINGS)));

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(Items.GOLDEN_BOOTS),
                        Ingredient.ofItems(Items.EMERALD),
                        RecipeCategory.COMBAT,
                        new ItemStack(ModItems.EMERALD_BOOTS,1).getItem())
                .criterion(hasItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE),conditionsFromItem(ModItems.EMERALD_UPGRADE_SMITHING_TEMPLATE))
                .criterion(hasItem(Items.EMERALD),conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.GOLDEN_BOOTS),conditionsFromItem(Items.GOLDEN_BOOTS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.EMERALD_BOOTS)));
    }
}
