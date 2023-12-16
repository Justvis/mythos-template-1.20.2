package net.justvis.mythos.recipe;

import net.justvis.mythos.Mythos;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Mythos.MOD_ID, GeodeCrusherRecipe.Serializer.ID),
                GeodeCrusherRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Mythos.MOD_ID, GeodeCrusherRecipe.Type.ID),
                GeodeCrusherRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Mythos.MOD_ID, GlyphInfuserRecipe.Serializer.ID),
                GlyphInfuserRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Mythos.MOD_ID, GlyphInfuserRecipe.Type.ID),
                GlyphInfuserRecipe.Type.INSTANCE);
    }

}
