package net.valion.manyflowers.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.block.Block
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.valion.manyflowers.ManyFlowers.MOD_ID
import net.valion.manyflowers.registry.BlocksRegistry
import net.valion.manyflowers.registry.ItemsRegistry
import java.util.concurrent.CompletableFuture


class ModRecipeProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricRecipeProvider(output, registriesFuture) {
    override fun getName(): String = "${MOD_ID}_recipes"

    override fun getRecipeGenerator(
        registryLookup: RegistryWrapper.WrapperLookup,
        exporter: RecipeExporter
    ): RecipeGenerator {
        return object : RecipeGenerator(registryLookup, exporter) {
            override fun generate() {
                val itemLookup = registries.getOrThrow(RegistryKeys.ITEM)

                offerSingleOutputShapelessRecipe(Items.PINK_DYE, BlocksRegistry.ALSTROEMERIA, "pink_dye")
                offerSingleOutputShapelessRecipe(Items.MAGENTA_DYE, BlocksRegistry.HYDRANGEA, "magenta_dye")
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, BlocksRegistry.MARIGOLD, "orange_dye")
                offerSingleOutputShapelessRecipe(Items.RED_DYE, BlocksRegistry.DAISIES, "red_dye")
                offerShapelessRecipe(Items.WHITE_DYE, BlocksRegistry.ZINNIA, "white_dye", 2)
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, BlocksRegistry.SWEET_ALYSSUM, "pink_dye")
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, BlocksRegistry.GAILLARDIA, "orange_dye")
                offerSingleOutputShapelessRecipe(Items.RED_DYE, BlocksRegistry.ORIENTAL_POPPY, "red_dye")
                offerSingleOutputShapelessRecipe(Items.WHITE_DYE, BlocksRegistry.WATER_HEMLOCK, "white_dye")
                offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, BlocksRegistry.OENOTHERA, "yellow_dye")
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, BlocksRegistry.CHRYSANTHEMUM, "pink_dye")
                offerSingleOutputShapelessRecipe(Items.LIGHT_BLUE_DYE, BlocksRegistry.AUTUMN_CROCUS, "light_blue_dye")
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, BlocksRegistry.VELVETS, "orange_dye")
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, BlocksRegistry.AUTUMN_ASTERS, "purple_dye")

                createShapeless(RecipeCategory.MISC, ItemsRegistry.COAL_SEEDS)
                    .input(BlocksRegistry.COAL_FLOWER)
                    .criterion(hasItem(BlocksRegistry.COAL_FLOWER), conditionsFromItem(BlocksRegistry.COAL_FLOWER))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, ItemsRegistry.COPPER_SEEDS)
                    .input(BlocksRegistry.COPPER_FLOWER)
                    .criterion(hasItem(BlocksRegistry.COPPER_FLOWER), conditionsFromItem(BlocksRegistry.COPPER_FLOWER))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, ItemsRegistry.IRON_SEEDS)
                    .input(BlocksRegistry.IRON_FLOWER)
                    .criterion(hasItem(BlocksRegistry.IRON_FLOWER), conditionsFromItem(BlocksRegistry.IRON_FLOWER))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, ItemsRegistry.GOLD_SEEDS)
                    .input(BlocksRegistry.GOLD_FLOWER)
                    .criterion(hasItem(BlocksRegistry.GOLD_FLOWER), conditionsFromItem(BlocksRegistry.GOLD_FLOWER))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, ItemsRegistry.DIAMOND_SEEDS)
                    .input(BlocksRegistry.DIAMOND_FLOWER)
                    .criterion(hasItem(BlocksRegistry.DIAMOND_FLOWER), conditionsFromItem(BlocksRegistry.DIAMOND_FLOWER))
                    .offerTo(exporter)
                createShapeless(RecipeCategory.MISC, ItemsRegistry.EMERALD_SEEDS)
                    .input(BlocksRegistry.EMERALD_FLOWER)
                    .criterion(hasItem(BlocksRegistry.EMERALD_FLOWER), conditionsFromItem(BlocksRegistry.EMERALD_FLOWER))
                    .offerTo(exporter)

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.CARVED_PUMPKIN)
                    .input(BlocksRegistry.JACK_FLOWER)
                    .criterion(hasItem(BlocksRegistry.JACK_FLOWER), conditionsFromItem(BlocksRegistry.JACK_FLOWER))
                    .offerTo(exporter)

                offerSingleOutputShapelessRecipe(Items.ENDER_PEARL, BlocksRegistry.ROOT_OF_THE_WORLDS, "purple_dye")

                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.COAL_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.COAL_PETAL_BLOCK)
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.COPPER_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.COPPER_PETAL_BLOCK)
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.IRON_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.IRON_PETAL_BLOCK)
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.GOLD_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.GOLD_PETAL_BLOCK)
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.DIAMOND_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.DIAMOND_PETAL_BLOCK)
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ItemsRegistry.EMERALD_PETAL, RecipeCategory.BUILDING_BLOCKS, BlocksRegistry.EMERALD_PETAL_BLOCK)

                createOreRecipes(Items.COAL, ItemsRegistry.COAL_PETAL, BlocksRegistry.COAL_PETAL_BLOCK)
                createOreRecipes(Items.COPPER_INGOT, ItemsRegistry.COPPER_PETAL, BlocksRegistry.COPPER_PETAL_BLOCK)
                createOreRecipes(Items.IRON_INGOT, ItemsRegistry.IRON_PETAL, BlocksRegistry.IRON_PETAL_BLOCK)
                createOreRecipes(Items.GOLD_INGOT, ItemsRegistry.GOLD_PETAL, BlocksRegistry.GOLD_PETAL_BLOCK)
                createOreRecipes(Items.DIAMOND, ItemsRegistry.DIAMOND_PETAL, BlocksRegistry.DIAMOND_PETAL_BLOCK)
                createOreRecipes(Items.EMERALD, ItemsRegistry.EMERALD_PETAL, BlocksRegistry.EMERALD_PETAL_BLOCK)
            }

            fun createOreRecipes(output: Item, petal: Item, petalBlock: Block) {
                createShaped(RecipeCategory.MISC, output, 2)
                    .pattern("PBP")
                    .pattern("BIB")
                    .pattern("PBP")
                    .input('P', petal)
                    .input('B', petalBlock)
                    .input('I', output)
                    .criterion(hasItem(output), conditionsFromItem(output))
                    .offerTo(exporter)
            }
        }
    }
}