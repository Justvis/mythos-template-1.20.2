package net.justvis.mythos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.justvis.mythos.Mythos;
import net.justvis.mythos.block.custom.BorageCropBlock;
import net.justvis.mythos.block.custom.GeodeCrusherBlock;
import net.justvis.mythos.block.custom.SageCropBlock;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    //All Block Listings
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block WRITHING_ROCK = registerBlock("writhing_rock",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));
    public static final Block CURSED_SAND = registerBlock("cursed_sand",
            new Block(FabricBlockSettings.copyOf(Blocks.SAND)));

    public static final Block CRUMBLING_STONE_BRICKS = registerBlock("crumbling_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block WEATHERED_STONE_BRICKS = registerBlock("weathered_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));
    public static final Block FOUNDATION_STONE_BRICKS = registerBlock("foundation_stone_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS)));

    //Block Entity
    public static final Block GEODE_CRUSHER = registerBlock("geode_crusher",
    new GeodeCrusherBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    // Ores
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0f), UniformIntProvider.create(2,5)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2.0f), UniformIntProvider.create(3,5)));
    public static final Block DEEPSLATE_DREAMSHARD_ORE = registerBlock("deepslate_dreamshard_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(3,5)));
    public static final Block CELESTIAL_ORE = registerBlock("celestial_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(3.0F, 3.0F)));
    public static final Block DEEPSLATE_CELESTIAL_ORE = registerBlock("deepslate_celestial_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(3.0F, 3.0F)));
    public static final Block DEEPSLATE_PRIMAL_GEODE_ORE = registerBlock("deepslate_primal_geode_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(2.0F, 2.0F)));
    public static final Block PRIMAL_GEODE_ORE = registerBlock("primal_geode_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).strength(2.0F, 2.0F)));

    // ======= Flowers/Crops =======
    public static final Block TEAR_LOTUS = registerBlock("tear_lotus",
            new FlowerBlock(StatusEffects.LEVITATION, 10, FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_TEAR_LOTUS = Registry.register(Registries.BLOCK, new Identifier(Mythos.MOD_ID, "potted_tear_lotus"),
            new FlowerPotBlock(TEAR_LOTUS, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block SAGE_CROP = Registry.register(Registries.BLOCK, new Identifier(Mythos.MOD_ID, "sage_crop"),
            new SageCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static final Block BORAGE_CROP = Registry.register(Registries.BLOCK, new Identifier(Mythos.MOD_ID, "borage_crop"),
            new BorageCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    //Wood

    public static final Block ELDER_OAK_LOG = registerBlock("elder_oak_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4.0f)));
    public static final Block ELDER_OAK_WOOD = registerBlock("elder_oak_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4.0f)));

    public static final Block ELDER_OAK_PLANKS = registerBlock("elder_oak_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3.0f)));
    public static final Block ELDER_OAK_LEAVES = registerBlock("elder_oak_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(1)));

    public static final Block ELDER_OAK_SAPLING = registerBlock("elder_oak_sapling",
            new SaplingBlock(null, FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(1)));



    //Helper Methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Mythos.MOD_ID, name), block);
    }
    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Mythos.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        Mythos.LOGGER.info("Registering Mod Blocks for " + Mythos.MOD_ID);

    }
}
