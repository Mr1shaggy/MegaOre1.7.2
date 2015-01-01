package com.main.mod.armor;

import com.main.mod.Main;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Brandon Boyd on 12/21/14-8:31 PM Project Name: MegaOre Mod.
 */
public class HardenedDiamond extends ItemArmor {

    public HardenedDiamond(ArmorMaterial material, int id, int slot) {
        super(material, id, slot);
        this.setCreativeTab(Main.megaoreToolsTab);

        if (slot == 0) {
            this.setTextureName(Main.modid + ":HardenedHelmet");
        } else if (slot == 1) {
            this.setTextureName(Main.modid + ":HardenedChest");
        } else if (slot == 2) {
            this.setTextureName(Main.modid + ":HardenedLegs");
        } else if (slot == 3) {
            this.setTextureName(Main.modid + ":HardenedBoots");
        }
    }

    public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
        if (itemStack.getItem() == Main.itemHardenedDiamondHelmet || itemStack.getItem() == Main.itemHardenedDiamondChest || itemStack.getItem() == Main.itemHardenedDiamondBoots) {
            return Main.modid + ":textures/model/armor/HardenedDiamond_Layer_1.png";
        } else if (itemStack.getItem() == Main.itemHardenedDiamondLegs) {
            return Main.modid + ":textures/model/armor/HardenedDiamond_Layer_2.png";
        } else
            return null;
    }
}

/*
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack.getItem() == Main.itemAluminumHelmet) {
            itemStack.addEnchantment(Enchantment.aquaAffinity, 5);
        }else if (itemStack.getItem() == Main.itemAluminumChest) {
            itemStack.addEnchantment(Enchantment.blastProtection, 5);
        }else if (itemStack.getItem() == Main.itemAluminumLegs) {
            itemStack.addEnchantment(Enchantment.fireProtection, 5);
        }else if (itemStack.getItem() == Main.itemAluminumBoots) {
            itemStack.addEnchantment(Enchantment.featherFalling, 5);
        }
    }
}*/