package net.justvis.mythos.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.justvis.mythos.Mythos;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GlyphInfuserScreen extends HandledScreen<GlyphInfuserScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(Mythos.MOD_ID, "textures/gui/glyph_infuser_gui.png");

    public GlyphInfuserScreen(GlyphInfuserScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 10;
        playerInventoryTitleY = 72;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            //context.drawTexture(TEXTURE, x + 99, y + 33, 176, 0, 50, handler.getScaledProgress());
            //context.drawTexture(TEXTURE, x + 99 - handler.getScaledProgress(), y + 33, 176, 0, handler.getScaledProgress(), 16);
            context.drawTexture(TEXTURE, x + 103, y + 33, 176, 0, handler.getScaledProgress(), 20);

        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
