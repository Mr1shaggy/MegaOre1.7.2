package com.main.mod.blocks;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by brandon on 12/2/14.
 */
public class HighOre extends Block {

    public HighOre(Material material) {
        super(material);
        this.setHardness(4.0F);
        this.setResistance(6.0F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(Main.megaoreTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
