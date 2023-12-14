package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.justvis.mythos.block.ModBlocks;
import net.justvis.mythos.block.custom.BorageCropBlock;
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
        // Texture Pools
        BlockStateModelGenerator.BlockTexturePool elderWoodTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ELDER_OAK_PLANKS);

        //Blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CURSED_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FOUNDATION_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUMBLING_STONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCHOLAR_STONE);

        // Ores
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CELESTIAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CELESTIAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRIMAL_GEODE_ORE);

        //Flowers / Crops
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.TEAR_LOTUS, ModBlocks.POTTED_TEAR_LOTUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCrop(ModBlocks.SAGE_CROP, SageCropBlock.AGE, 0,1,2,3);
        blockStateModelGenerator.registerCrop(ModBlocks.BORAGE_CROP, BorageCropBlock.AGE, 0,1,2,3,4,5);

        // Entities
        blockStateModelGenerator.registerSimpleState(ModBlocks.GEODE_CRUSHER);

        // WOOD
        blockStateModelGenerator.registerLog(ModBlocks.ELDER_OAK_LOG).log(ModBlocks.ELDER_OAK_LOG).wood(ModBlocks.ELDER_OAK_WOOD);
        elderWoodTexturePool.stairs(ModBlocks.ELDER_OAK_STAIRS);
        elderWoodTexturePool.slab(ModBlocks.ELDER_OAK_SLAB);
        elderWoodTexturePool.fence(ModBlocks.ELDER_OAK_FENCE);
        elderWoodTexturePool.fenceGate(ModBlocks.ELDER_OAK_FENCE_GATE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ELDER_OAK_LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.ELDER_OAK_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        //Items
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.DREAMSHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CELESTIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMAL_GEODE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRIMAL_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCANIST_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CALCIFIED_BLOOD, Models.GENERATED);

        //Glyphs
        itemModelGenerator.register(ModItems.INERT_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.AERO_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.AQUA_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TERRA_GLYPH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PYRO_GLYPH, Models.GENERATED);

        //Foods
        itemModelGenerator.register(ModItems.CELESTIAL_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGETABLE_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERB_BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERB_COOKED_MUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERB_COOKED_STEAK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BORAGE, Models.GENERATED);
    }
}
