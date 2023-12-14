package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.justvis.mythos.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        // Can use different MINEABLE traits
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)

                // Ores
                .add(ModBlocks.DEEPSLATE_DREAMSHARD_ORE)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.CELESTIAL_ORE)
                .add(ModBlocks.DEEPSLATE_CELESTIAL_ORE)
                .add(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE)
                .add(ModBlocks.PRIMAL_GEODE_ORE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
            .add(ModBlocks.CURSED_SAND);

        // Mining Difficulty
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.CELESTIAL_ORE)
                .add(ModBlocks.DEEPSLATE_CELESTIAL_ORE)
                .add(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE)
                .add(ModBlocks.PRIMAL_GEODE_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_DREAMSHARD_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ELDER_OAK_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ELDER_OAK_FENCE_GATE);

    }
}
