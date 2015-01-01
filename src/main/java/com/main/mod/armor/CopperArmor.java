package com.main.mod.armor;

import com.main.mod.Main;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by Brandon Boyd on 12/16/14-9:00 PM Project Name: MegaOre Mod.
 */
public class CopperArmor extends ItemArmor {

    public CopperArmor(ArmorMaterial material, int id, int slot) {
        super(material, id, slot);
        this.setCreativeTab(Main.megaoreToolsTab);
        if (slot == 0) {
            this.setTextureName(Main.modid + ":CopperHelmet");
        }else if (slot == 1) {
            this.setTextureName(Main.modid + ":CopperChest");
        }else if (slot == 2) {
            this.setTextureName(Main.modid + ":CopperLegs");
        }else if (slot == 3) {
            this.setTextureName(Main.modid + ":CopperBoots");
        }
        }

        public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
            if (itemStack.getItem() == Main.itemCopperHelmet || (itemStack.getItem() == Main.itemCopperChest || (itemStack.getItem() == Main.itemCopperBoots))) {
                return Main.modid + ":textures/model/armor/Copper_Layer_1.png";
            } else if (itemStack.getItem() == Main.itemCopperLegs) {
                return Main.modid + ":textures/model/armor/Copper_Layer_2.png";
            }else{
                    return null;
                }

                }
            }

/*
    public void onCreated(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (itemStack.getItem() == Main.itemAluminumHelmet) {
            itemStack.addEnchantment(Enchantment.aquaAffinity, 4);
        }else if (itemStack.getItem() == Main.itemAluminumChest) {
            itemStack.addEnchantment(Enchantment.blastProtection, 4);
        }else if (itemStack.getItem() == Main.itemAluminumLegs) {
            itemStack.addEnchantment(Enchantment.fireProtection, 4);
        }else if (itemStack.getItem() == Main.itemAluminumBoots) {
            itemStack.addEnchantment(Enchantment.featherFalling, 4);
        }
    }
}*/
