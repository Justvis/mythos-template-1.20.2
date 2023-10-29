package net.justvis.mythos;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.justvis.mythos.block.ModBlocks;
import net.justvis.mythos.screen.GeodeCrusherScreen;
import net.justvis.mythos.screen.ModScreenHandlers;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class MythosModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        HandledScreens.register(ModScreenHandlers.GEODE_CRUSHER_SCREEN_HANDLER, GeodeCrusherScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEAR_LOTUS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_TEAR_LOTUS, RenderLayer.getCutout());
    }
}
