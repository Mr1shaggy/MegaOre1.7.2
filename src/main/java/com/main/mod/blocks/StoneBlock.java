package com.main.mod.blocks;

import com.main.mod.Main;
import com.main.mod.tileentity.TileEntityStoneBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Brandon Boyd on 12/11/14-2:08 PM Project Name: MegaOre Mod.
 */
public class StoneBlock extends BlockContainer {
    public StoneBlock(Material material) {
        super(material);
        this.setCreativeTab(Main.megaoreTab);
        this.setHardness(9.0F);
        this.setResistance(5.0F);
        this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityStoneBlock();
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}



