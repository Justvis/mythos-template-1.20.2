package net.justvis.mythos;

import net.fabricmc.api.ModInitializer;

import net.justvis.mythos.item.ModItemGroups;
import net.justvis.mythos.item.ModItems;
import net.justvis.mythos.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mythos implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "mythos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		//LOGGER.info("Hello Fabric world!");
	}
}