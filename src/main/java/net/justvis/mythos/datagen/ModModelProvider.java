package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.justvis.mythos.block.ModBlocks;
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

        //Ores
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CELESTIAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CELESTIAL_ORE);

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

        //Foods
        itemModelGenerator.register(ModItems.CELESTIAL_BERRIES, Models.GENERATED);
    }
}
