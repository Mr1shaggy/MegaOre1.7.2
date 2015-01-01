package com.main.mod.blocks.handler;

import com.main.mod.Main;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

/**
 * Created by brandon on 12/3/14.
 */
public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == Main.itemCrystalCoal) return 15000;


        return 0;
    }

    }
