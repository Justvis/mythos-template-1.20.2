package net.justvis.mythos.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.justvis.mythos.Mythos;
import net.justvis.mythos.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MYTHOS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mythos.MOD_ID, "mythos.itemgroup"),
            FabricItemGroup.builder().displayName(Text.translatable("Mythos"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        //Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.DREAMSHARD);
                        entries.add(ModItems.RAW_CELESTIAL);
                        entries.add(ModItems.CELESTIAL_INGOT);
                        entries.add(ModItems.PRIMAL_GEODE);

                        //Glyphs
                        entries.add(ModItems.INERT_GLYPH);
                        entries.add(ModItems.AERO_GLYPH);
                        entries.add(ModItems.TERRA_GLYPH);
                        entries.add(ModItems.PYRO_GLYPH);
                        entries.add(ModItems.AQUA_GLYPH);


                        //Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.WRITHING_ROCK);
                        entries.add(ModBlocks.CURSED_SAND);
                        entries.add(ModBlocks.CRUMBLING_STONE_BRICKS);
                        entries.add(ModBlocks.FOUNDATION_STONE_BRICKS);
                        entries.add(ModBlocks.WEATHERED_STONE_BRICKS);

                        //Food
                        entries.add(ModItems.CELESTIAL_BERRIES);
                        entries.add(ModItems.BUTTER);
                        entries.add(ModItems.PUMPKIN_SOUP);
                        entries.add(ModItems.VEGETABLE_STEW);

                        // Food Reagents
                        entries.add(ModItems.SAGE_SEEDS);
                        entries.add(ModItems.SAGE);
                        entries.add(ModItems.BORAGE);
                        entries.add(ModItems.BORAGE_SEEDS);

                        //Ores
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CELESTIAL_ORE);
                        entries.add(ModBlocks.CELESTIAL_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE);
                        entries.add(ModBlocks.PRIMAL_GEODE_ORE);

                        //Block Entity
                        entries.add(ModBlocks.GEODE_CRUSHER);

                        //Wood / Trees       (REWATCH TUTORIAL FOR STRIPPABLE AND FLAMMABLE)
                        entries.add(ModBlocks.TEAR_LOTUS);
                        entries.add(ModBlocks.ELDER_OAK_LEAVES);
                        entries.add(ModBlocks.ELDER_OAK_PLANKS);
                        entries.add(ModBlocks.ELDER_OAK_LOG);
                        entries.add(ModBlocks.ELDER_OAK_WOOD);
                        entries.add(ModBlocks.ELDER_OAK_SAPLING);


                    }).build());
    public static void registerItemGroups() {
        Mythos.LOGGER.info("Register Item Groups for " + Mythos.MOD_ID);
    }
}

