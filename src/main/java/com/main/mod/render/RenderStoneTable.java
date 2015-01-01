package com.main.mod.render;

import com.main.mod.Main;
import com.main.mod.models.ModelStoneTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Brandon Boyd on 12/11/14-2:36 PM Project Name: MegaOre Mod.
 */
public class RenderStoneTable extends TileEntitySpecialRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Main.modid + ":" + "textures/model/StoneTable.png");

    private ModelStoneTable model;

    public RenderStoneTable() {
        this.model = new ModelStoneTable();
    }



    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
        GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180, 0F, 0F, 1F);

            this.bindTexture(texture);

                GL11.glPushMatrix();
                this.model.renderModel(0.0625F);
                GL11.glPopMatrix();
        GL11.glPopMatrix();

    }
}
