package net.justvis.mythos.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.justvis.mythos.Mythos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<GeodeCrusherScreenHandler> GEODE_CRUSHER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Mythos.MOD_ID, "gem_polishing"),
                    new ExtendedScreenHandlerType<>(GeodeCrusherScreenHandler::new));

    public static final ScreenHandlerType<GlyphInfuserScreenHandler> GLYPH_INFUSER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Mythos.MOD_ID, "glyph_infusing"),
                    new ExtendedScreenHandlerType<>(GlyphInfuserScreenHandler::new));

    public static void registerScreenHandlers() {
        Mythos.LOGGER.info("Registering Screen Handlers for " + Mythos.MOD_ID);
    }
}
