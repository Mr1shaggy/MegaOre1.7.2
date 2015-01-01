package com.main.mod.blocks;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by brandon on 12/2/14.
 */
public class LowOre extends Block {

    public LowOre(Material material) {
        super(material);
        this.setHardness(2.0F);
        this.setResistance(4.0F);
        this.setCreativeTab(Main.megaoreTab);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
