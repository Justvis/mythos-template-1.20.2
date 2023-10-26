package net.justvis.mythos.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.justvis.mythos.Mythos;
import net.justvis.mythos.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<GeodeCrusherBlockEntity> GEODE_CRUSHER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Mythos.MOD_ID, "gem_polishing_be"),
                    FabricBlockEntityTypeBuilder.create(GeodeCrusherBlockEntity::new,
                            ModBlocks.GEODE_CRUSHER).build());

    public static void registerBlockEntities() {
        Mythos.LOGGER.info("Registering Block Entities for " + Mythos.MOD_ID);
    }
}