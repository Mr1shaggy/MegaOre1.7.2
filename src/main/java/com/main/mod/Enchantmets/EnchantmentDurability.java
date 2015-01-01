package com.main.mod.Enchantmets;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * Created by Brandon Boyd on 12/27/14-12:25 PM Project Name: MegaOre Mod.
 */
public class EnchantmentDurability extends Enchantment {

    public EnchantmentDurability(int id, int rarity) {
        super (id, rarity, EnumEnchantmentType.breakable);
        this.setName("LongerDurability");
    }

    public int getMinEnchantability(int i) {
        return 1 + (i - 1) * 10;
    }

    public int getMaxEnchantability(int i) {
        return this.getMinEnchantability(i) * 20;
    }

    public int getMaxLevel() {
        return 5;
    }

}
