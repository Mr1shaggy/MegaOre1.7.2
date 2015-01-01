package com.main.mod.weapons.Aluminum;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

/**
 * Created by Brandon Boyd on 1/1/15-3:12 PM Project Name: MegaOre Mod.
 */
public class AluminumPick extends ItemPickaxe {
    public AluminumPick(Item.ToolMaterial toolMaterial) {
        super(toolMaterial);
        this.setCreativeTab(Main.megaoreToolsTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }

    public boolean getIsRepairable(ItemStack item1, ItemStack item2) {
        return Main.itemAluminumIngot == item2.getItem() ? true : super.getIsRepairable(item1, item2);
    }
}
