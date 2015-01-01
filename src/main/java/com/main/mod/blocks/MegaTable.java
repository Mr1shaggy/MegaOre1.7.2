package com.main.mod.blocks;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Brandon Boyd on 12/12/14-10:23 PM Project Name: MegaOre Mod.
 */
public class MegaTable extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon megaTableTop;

    public MegaTable() {
        super(Material.wood);
        this.setHardness(4.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(Main.megaoreToolsTab);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon (int side, int metadata) {
        return side == 1 ? this.megaTableTop : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + "MegaTableSide");
        this.megaTableTop = iconRegister.registerIcon(Main.modid + ":" + "MegaTableTop");
    }

    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer entityPlayer, int q, float a, float b, float c) {
        if(!entityPlayer.isSneaking()) {
            entityPlayer.openGui(Main.instance, Main.guiMegaTable, world, x, y, z);
            return true;
        }else{
            return false;
        }
    }
}
