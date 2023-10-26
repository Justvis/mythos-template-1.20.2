package net.justvis.mythos;

import net.fabricmc.api.ClientModInitializer;
import net.justvis.mythos.screen.GeodeCrusherScreen;
import net.justvis.mythos.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class MythosModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.GEODE_CRUSHER_SCREEN_HANDLER, GeodeCrusherScreen::new);
    }
}
