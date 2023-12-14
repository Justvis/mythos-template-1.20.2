package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.justvis.mythos.block.ModBlocks;
import net.justvis.mythos.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> CELESTIAL_SMELTABLES = List.of(ModBlocks.DEEPSLATE_CELESTIAL_ORE, ModBlocks.CELESTIAL_ORE, ModItems.RAW_CELESTIAL);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        // ======= Smelting / Blasting ======
        offerSmelting(exporter, CELESTIAL_SMELTABLES, RecipeCategory.MISC, ModItems.CELESTIAL_INGOT, 0.7f, 200, "celestial");
        offerBlasting(exporter, CELESTIAL_SMELTABLES, RecipeCategory.MISC, ModItems.CELESTIAL_INGOT, 0.7f, 200, "celestial");
    }
}
