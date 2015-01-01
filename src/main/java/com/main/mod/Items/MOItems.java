package com.main.mod.Items;

import com.main.mod.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by brandon on 12/1/14.
 */
public class MOItems extends Item {

    public MOItems() {
        this.setCreativeTab(Main.megaorematerialsTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconsRegister) {
        this.itemIcon = iconsRegister.registerIcon(Main.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
