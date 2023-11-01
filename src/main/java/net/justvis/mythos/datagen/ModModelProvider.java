package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.justvis.mythos.block.ModBlocks;
import net.justvis.mythos.block.custom.SageCropBlock;
import net.justvis.mythos.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WRITHING_ROCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CURSED_SAND);

        //Ores
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CELESTIAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CELESTIAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMAL_GEODE_ORE);

        //Flowers / Crops
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.TEAR_LOTUS, ModBlocks.POTTED_TEAR_LOTUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCrop(ModBlocks.SAGE_CROP, SageCropBlock.AGE, 0,1,2,3);

        // Entities
        blockStateModelGenerator.registerSimpleState(ModBlocks.GEODE_CRUSHER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        //Items
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.DREAMSHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CELESTIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMAL_GEODE, Models.GENERATED);

        //Glyphs
        itemModelGenerator.register(ModItems.INERT_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.AERO_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.AQUA_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TERRA_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PYRO_GLYPH, Models.GENERATED);


        //Foods
        itemModelGenerator.register(ModItems.CELESTIAL_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAGE, Models.GENERATED);
    }
}
