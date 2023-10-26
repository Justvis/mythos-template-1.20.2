package net.justvis.mythos.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.justvis.mythos.Mythos;
import net.justvis.mythos.block.custom.GeodeCrusherBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.PillarBlock;
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

    //Wood
    public static final Block SACRED_LOG = registerBlock("sacred_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(3.0f)));
    public static final Block SACRED_WOOD = registerBlock("sacred_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(3.0f)));



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
