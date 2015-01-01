package com.main.mod.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by Brandon Boyd on 12/12/14-2:48 PM Project Name: MegaOre Mod.
 */
public class ItemRenderStoneTable implements IItemRenderer {

    TileEntitySpecialRenderer render;
    private TileEntity entity;

    public ItemRenderStoneTable(TileEntitySpecialRenderer render, TileEntity entity) {
        this.entity = entity;
        this.render = render;

    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        if(type == IItemRenderer.ItemRenderType.ENTITY)
            GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);

    }
}