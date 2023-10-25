package net.justvis.mythos.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.justvis.mythos.Mythos;
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

    //Food
    public static final Item CELESTIAL_BERRIES = registerItem("celestial_berries", new Item(new FabricItemSettings().food(ModFoodComponents.CELESTIAL_BERRIES)));



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
