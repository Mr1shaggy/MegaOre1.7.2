package com.main.mod.blocks.handler;

import com.main.mod.Main;
import com.main.mod.container.ContainerCrucibleOven;
import com.main.mod.container.ContainerMegaTable;
import com.main.mod.gui.GuiCrucibleOven;
import com.main.mod.gui.GuiMegaTable;
import com.main.mod.tileentity.TileEntityCrucibleOven;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Brandon Boyd on 12/7/14-4:39 PM Project Name: MegaOre Mod.
 */
public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null) {
            switch(ID) {
                case Main.guiIDCrucible:
                    if (entity instanceof TileEntityCrucibleOven) {
                        return new ContainerCrucibleOven(player.inventory, (TileEntityCrucibleOven) entity);
                    }
                    return null;
            }
        }

        if(ID == Main.guiMegaTable) {
            return ID == Main.guiMegaTable && world.getBlock(x, y, z) == Main.blockMegaTable ? new ContainerMegaTable(player.inventory, world, x, y, z) : null;
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null) {
            switch(ID) {
                case Main.guiIDCrucible:
                    if (entity instanceof TileEntityCrucibleOven) {
                        return new GuiCrucibleOven(player.inventory, (TileEntityCrucibleOven) entity);
                    }
                    return null;
            }
        }

        if(ID == Main.guiMegaTable) {
            return ID == Main.guiMegaTable && world.getBlock(x, y, z) == Main.blockMegaTable ? new GuiMegaTable(player.inventory, world, x, y, z) : null;
        }

        return null;
    }
}
