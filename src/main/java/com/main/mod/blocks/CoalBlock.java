package com.main.mod.blocks;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;



/**
 * Created by brandon on 12/3/14.
 */
public class CoalBlock extends Block {


    public CoalBlock(Material material) {
        super(material);
        this.setCreativeTab(Main.megaoreTab);
        this.setHardness(5.0F);
        this.setResistance(7.0F);
        this.setStepSound(soundTypeGravel);
        this.setHarvestLevel("pickaxe", 3);

    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}


    /**
     * Make ore drop item
    public Item getItemDropped(int i, Random random, int j) {
        return this == Mod.MyOre ? Mod.MyItem : Item.getItemFromBlock(this);
     **/




