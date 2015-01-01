package com.main.mod.weapons.Copper;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

/**
 * Created by Brandon Boyd on 1/1/15-1:56 PM Project Name: MegaOre Mod.
 */
public class CopperShovel extends ItemSpade {
    public CopperShovel(ToolMaterial toolMaterial1) {
        super(toolMaterial1);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }

    public boolean getIsRepairable(ItemStack item1, ItemStack item2) {
        return Main.itemCopperIngot == item2.getItem() ? true : super.getIsRepairable(item1, item2);
    }
}
