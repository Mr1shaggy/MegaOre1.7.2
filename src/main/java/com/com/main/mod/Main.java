package com.com.main.mod;

import com.com.main.mod.Items.MOItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by Brandon Boyd on 12/1/14.
 */


@Mod(modid = Main.modid, version = Main.version)
public class Main {

    public static final String modid = "MegaOre";
    public static final String version = "Alpha";

    public static Item itemCopperIngot;
    public static Item itemTinIngot;
    public static Item itemNickelIngot;
    public static Item itemAluminumIngot;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preEvent) {

        itemCopperIngot = new MOItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        itemTinIngot = new MOItems().setUnlocalizedName("TinIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        itemNickelIngot = new MOItems().setUnlocalizedName("NickelIngot");
        GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
        itemAluminumIngot = new MOItems().setUnlocalizedName("AluminumIngot");
        GameRegistry.registerItem(itemAluminumIngot, "AluminumIngot");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent postInit) {

    }

}
