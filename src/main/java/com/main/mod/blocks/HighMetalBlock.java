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
public class HighMetalBlock extends Block {

    public HighMetalBlock(Material material) {
        super(material);

        this.setCreativeTab(Main.megaoreTab);
        this.setHardness(7.0F);
        this.setResistance(9.0F);
        this.setStepSound(soundTypeMetal);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
