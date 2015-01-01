package com.main.mod.gui;

import com.main.mod.Main;
import com.main.mod.container.ContainerMegaTable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Brandon Boyd on 12/13/14-12:25 PM Project Name: MegaOre Mod.
 */
public class GuiMegaTable extends GuiContainer {

    private ResourceLocation texture = new ResourceLocation(Main.modid + ":" + "textures/gui/MegaTable.png");

    public GuiMegaTable(InventoryPlayer inv, World world, int x, int y, int z) {
        super(new ContainerMegaTable(inv, world, x, y, z));
        this.xSize = 176;
        this.ySize = 188;
    }

    public void onGuiClosed() {
        super.onGuiClosed();
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString(StatCollector.translateToLocal("MEGA TABLE"), 100, 5, 0x7A2222);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

    }
}
