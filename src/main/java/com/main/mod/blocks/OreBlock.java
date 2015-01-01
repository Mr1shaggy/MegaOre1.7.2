package com.main.mod.blocks;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Brandon Boyd on 12/6/14-3:47 PM Project Name: forge-1.7.2-10.12.2.1121-src.
 */
public class OreBlock extends Block {
    public OreBlock(Material material) {
        super(material);
        this.setCreativeTab(Main.megaoreTab);
        this.setHardness(9.0F);
        this.setResistance(9.0F);
        this.setStepSound(soundTypeGravel);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(0.5F);
    }

    public Item getItemDropped(int i, Random random, int j) {
        return Main.itemRawCrystalOre;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
