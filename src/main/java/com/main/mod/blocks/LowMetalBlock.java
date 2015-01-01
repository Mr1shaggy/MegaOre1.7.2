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
public class LowMetalBlock extends Block {

    public LowMetalBlock(Material material) {
        super(material);

        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(Main.megaoreTab);
        this.setHardness(5.0F);
        this.setResistance(7.0F);

    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
