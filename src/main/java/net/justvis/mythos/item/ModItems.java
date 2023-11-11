package net.justvis.mythos.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.justvis.mythos.Mythos;
import net.justvis.mythos.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Items
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item DREAMSHARD = registerItem("dreamshard", new Item(new FabricItemSettings()));
    public static final Item RAW_CELESTIAL = registerItem("raw_celestial", new Item(new FabricItemSettings()));
    public static final Item CELESTIAL_INGOT = registerItem("celestial_ingot", new Item(new FabricItemSettings()));
    public static final Item PRIMAL_GEODE = registerItem("primal_geode", new Item(new FabricItemSettings()));
    public static final Item SAGE = registerItem("sage", new Item(new FabricItemSettings()));
    public static final Item BORAGE = registerItem("borage", new Item(new FabricItemSettings()));

    //Glyphs
    public static final Item INERT_GLYPH = registerItem("inert_glyph", new Item(new FabricItemSettings()));
    public static final Item PYRO_GLYPH = registerItem("pyro_glyph", new Item(new FabricItemSettings()));
    public static final Item TERRA_GLYPH = registerItem("terra_glyph", new Item(new FabricItemSettings()));
    public static final Item AERO_GLYPH = registerItem("aero_glyph", new Item(new FabricItemSettings()));
    public static final Item AQUA_GLYPH = registerItem("aqua_glyph", new Item(new FabricItemSettings()));

    // ==== Food / Crops / Seeds ====
    public static final Item CELESTIAL_BERRIES = registerItem("celestial_berries", new Item(new FabricItemSettings().food(ModFoodComponents.CELESTIAL_BERRIES)));
    public static final Item BUTTER = registerItem("butter", new Item(new FabricItemSettings().food(ModFoodComponents.BUTTER)));
    public static final Item VEGETABLE_STEW = registerItem("vegetable_stew", new Item(new FabricItemSettings().food(ModFoodComponents.VEGETABLE_STEW)));
    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup", new Item(new FabricItemSettings().food(ModFoodComponents.PUMPKIN_SOUP)));
    public static final Item SAGE_SEEDS = registerItem("sage_seeds", new AliasedBlockItem(ModBlocks.SAGE_CROP, new FabricItemSettings()));
    public static final Item BORAGE_SEEDS = registerItem("borage_seeds", new AliasedBlockItem(ModBlocks.BORAGE_CROP, new FabricItemSettings()));


    // adding to minecraft tabs
    private static void addItemsToNaturalTab(FabricItemGroupEntries entry) {
        //entry.add(RUBY);
    }
    private static void addItemsIngredientToTab(FabricItemGroupEntries entry) {
        //entry.add(RUBY);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Mythos.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Mythos.LOGGER.info("Registering Mod Items for " + Mythos.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsIngredientToTab);
    }
}
