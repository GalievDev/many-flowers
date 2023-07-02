package net.valion.manyflowers.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.valion.manyflowers.ManyFlowers;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

@Environment(EnvType.CLIENT)
public class BookScreen extends Screen {
    private ButtonWidget next;
    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/gui/encyclopedia_gui.png");
    private static final Identifier NEXT = new Identifier(MOD_ID, "textures/gui/next_button.png");
    private static final int WIDTH = 276;
    private static final int HEIGHT = 186;

    public BookScreen() {
        super(Text.literal("Bonga"));
    }


    @Override
    protected void init() {
        next = ButtonWidget.builder(Text.literal("Button 1"), button -> {
                    generate();
                    ManyFlowers.LOGGER.info("GENERATED");
                })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .build();
        addDrawableChild(next);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        context.drawTexture(TEXTURE, x, y, 0, 0, WIDTH, HEIGHT, WIDTH, HEIGHT);
        next.drawTexture(context, NEXT, x, y, 0, 0, 0, 22, 9, 22, 9);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    public void generate() {
        MinecraftClient.getInstance().setScreen(new BookScreen());
    }
}
