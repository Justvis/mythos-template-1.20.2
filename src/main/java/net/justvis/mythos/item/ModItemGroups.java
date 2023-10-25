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
            FabricItemGroup.builder().displayName(Text.translatable("mythos.itemgroup"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        //Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.DREAMSHARD);
                        entries.add(ModItems.RAW_CELESTIAL);
                        entries.add(ModItems.CELESTIAL_INGOT);

                        entries.add(Items.ICE);

                        //Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.WRITHING_ROCK);

                        //Food
                        entries.add(ModItems.CELESTIAL_BERRIES);

                        //Ores
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CELESTIAL_ORE);
                        entries.add(ModBlocks.CELESTIAL_ORE);

                        entries.add(ModBlocks.SACRED_LOG);

                    }).build());
    public static void registerItemGroups() {
        Mythos.LOGGER.info("Register Item Groups for " + Mythos.MOD_ID);
    }
}

