package com.main.mod.gui;

import com.main.mod.Main;
import com.main.mod.tileentity.TileEntityCrucibleOven;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import com.main.mod.container.ContainerCrucibleOven;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Brandon Boyd on 12/7/14-5:05 PM Project Name: MegaOre Mod.
 */


public class GuiCrucibleOven extends GuiContainer {

    public static final ResourceLocation bground = new ResourceLocation(Main.modid + ":" + "textures/gui/GuiCrucibleOven.png");

    public TileEntityCrucibleOven crucibleOven;

    public GuiCrucibleOven(InventoryPlayer inventoryPlayer, TileEntityCrucibleOven entity) {
        super(new ContainerCrucibleOven(inventoryPlayer, entity));

        this.crucibleOven = entity;

        this.xSize = 176;
        this.ySize = 166;
    }


    public void drawGuiContainerForegroundLayer(int par1, int par2) {

        String name = this.crucibleOven.hasCustomInventoryName() ? this.crucibleOven.getInventoryName() : I18n.format(this.crucibleOven.getInventoryName());
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 8867920);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 118, this.ySize - 96 + 2, 8867920);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if(this.crucibleOven.isBurning()) {
            int k = this.crucibleOven.getBurnTimeRemainingScaled(40);
            int j = 40 - k;
            drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
        }

        int k = this.crucibleOven.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
    }

}


/*public class GuiCrucibleOven extends GuiContainer {

    public static final ResourceLocation bground = new ResourceLocation(Main.modid + ":" + "textures/gui/GuiCrucibleOven.png");

    public TileEntityCrucibleOven crucibleOven;

    public GuiCrucibleOven(InventoryPlayer inventoryPlayer, TileEntityCrucibleOven entity) {
        super(new ContainerCrucibleOven(inventoryPlayer, entity));
        this.crucibleOven = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawGuiContainerForegroundLayer(int i, int j) {
        String name = this.crucibleOven.hasCustomInventoryName() ? this.crucibleOven.getInventoryName() : I18n.format(this.crucibleOven.getInventoryName(), new Object[0]);

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 8867920);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 8867920);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float a, int b, int c) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if(this.crucibleOven.isBurning()) {
            int k = this.crucibleOven.getBurnTimeRemainingScaled(40);
            int j = 40 - k;
            drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
        }

        int k = this.crucibleOven.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 73, guiTop + 34, 176, 10, k + 1, 16);

    }
}*/
