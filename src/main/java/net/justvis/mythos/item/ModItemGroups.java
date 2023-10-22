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

    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Mythos.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);

                        entries.add(Items.ICE);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.WRITHING_ROCK);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.RUBY_ORE);

                        entries.add(ModBlocks.SACRED_LOG);

                    }).build());
    public static void registerItemGroups() {
        Mythos.LOGGER.info("Register Item Groups for " + Mythos.MOD_ID);
    }
}

