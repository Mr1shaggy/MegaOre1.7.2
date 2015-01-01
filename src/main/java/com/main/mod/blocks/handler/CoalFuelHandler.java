package com.main.mod.blocks.handler;

import com.main.mod.Main;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by brandon on 12/4/14.
 */
public class CoalFuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.getItem() == Item.getItemFromBlock(Main.blockCrystalCoalBlock)) return 135000;

        return 0;
    }
}
