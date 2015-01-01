package com.main.mod.food;

import com.main.mod.Main;
import net.minecraft.item.ItemFood;

/**
 * Created by Brandon Boyd on 12/26/14-9:19 PM Project Name: MegaOre Mod.
 */
public class Cheese extends ItemFood {

    public Cheese(int health, float saturation, boolean wolfeat) {
        super(health, saturation, wolfeat);
        this.setCreativeTab(Main.megaoreFoodTab);
        this.setTextureName(Main.modid + ":Cheese");

    }
}
