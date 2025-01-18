package net.thewonderfultime.pony18craft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.block.ModBlocks;

import java.util.List;
import java.util.function.Consumer;



public class ModRecipeGenerator extends FabricRecipeProvider {


    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerSmelting(exporter, List.of(ModItems.ORESHEK), RecipeCategory.MISC, ModItems.BAKED_ORESHEK,
                0.35f, 200, "food");







//        offerReversibleCompactingRecipes(exporter, RecipeCategory.FOOD, ModBlocks.PIVO_BLOCK, RecipeCategory.FOOD,
//                ModBlocks.BEER_BLOCK);



        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModBlocks.BEER_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(ModBlocks.PIVO_BLOCK))
                .criterion("has_pivo_block", conditionsFromItem(ModBlocks.PIVO_BLOCK)) // Используем корректные conditions
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.BEER_BLOCK)));

    }
}
