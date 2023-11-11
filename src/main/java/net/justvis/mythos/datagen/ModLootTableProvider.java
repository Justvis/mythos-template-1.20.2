package net.justvis.mythos.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.justvis.mythos.block.ModBlocks;
import net.justvis.mythos.block.custom.BorageCropBlock;
import net.justvis.mythos.block.custom.SageCropBlock;
import net.justvis.mythos.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
            addDrop(ModBlocks.RUBY_BLOCK);
            addDrop(ModBlocks.WRITHING_ROCK);
            addDrop(ModBlocks.CURSED_SAND);
            addDrop(ModBlocks.CRUMBLING_STONE_BRICKS);
            addDrop(ModBlocks.FOUNDATION_STONE_BRICKS);
            addDrop(ModBlocks.WEATHERED_STONE_BRICKS);

            //Ore Behavior
            addDrop(ModBlocks.RUBY_ORE, copperLikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));
            addDrop(ModBlocks.NETHER_RUBY_ORE, copperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RUBY));
            addDrop(ModBlocks.DEEPSLATE_DREAMSHARD_ORE, diamondLikeOreDrops(ModBlocks.DEEPSLATE_DREAMSHARD_ORE, ModItems.DREAMSHARD));
            addDrop(ModBlocks.DEEPSLATE_CELESTIAL_ORE, ironLikeOreDrops(ModBlocks.DEEPSLATE_CELESTIAL_ORE, ModItems.RAW_CELESTIAL));
            addDrop(ModBlocks.CELESTIAL_ORE, ironLikeOreDrops(ModBlocks.CELESTIAL_ORE, ModItems.RAW_CELESTIAL));
            addDrop(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE, ironLikeOreDrops(ModBlocks.DEEPSLATE_PRIMAL_GEODE_ORE, ModItems.PRIMAL_GEODE));
            addDrop(ModBlocks.PRIMAL_GEODE_ORE, ironLikeOreDrops(ModBlocks.PRIMAL_GEODE_ORE, ModItems.PRIMAL_GEODE));

            addDrop(ModBlocks.TEAR_LOTUS);
            addPottedPlantDrops(ModBlocks.POTTED_TEAR_LOTUS);

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.SAGE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(SageCropBlock.AGE, 3));
        addDrop(ModBlocks.SAGE_CROP, cropDrops(ModBlocks.SAGE_CROP, ModItems.SAGE, ModItems.SAGE_SEEDS, builder));

        BlockStatePropertyLootCondition.Builder borageBuilder = BlockStatePropertyLootCondition.builder(ModBlocks.BORAGE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(BorageCropBlock.AGE, 5));
        addDrop(ModBlocks.BORAGE_CROP, cropDrops(ModBlocks.BORAGE_CROP, ModItems.BORAGE, ModItems.BORAGE_SEEDS, borageBuilder));

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f))))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
    public LootTable.Builder diamondLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,2f))))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
    public LootTable.Builder ironLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f))))));
    }
}
