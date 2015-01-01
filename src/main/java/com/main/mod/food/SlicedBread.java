package com.main.mod.food;

import com.main.mod.Main;
import net.minecraft.item.ItemFood;

/**
 * Created by Brandon Boyd on 12/26/14-11:31 PM Project Name: MegaOre Mod.
 */
public class SlicedBread extends ItemFood {
    public SlicedBread(int health, float saturation, boolean wolfeat) {
        super(health, saturation, wolfeat);
        this.setCreativeTab(Main.megaoreFoodTab);
        this.setTextureName(Main.modid + ":SlicedBread");

    }
}
