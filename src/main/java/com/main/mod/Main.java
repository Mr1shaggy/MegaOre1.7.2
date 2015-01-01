package com.main.mod;

import com.main.mod.Enchantmets.EnchantmentDurability;
import com.main.mod.Items.*;
import com.main.mod.armor.*;
import com.main.mod.blocks.*;
import com.main.mod.blocks.handler.CoalFuelHandler;
import com.main.mod.blocks.handler.FuelHandler;
import com.main.mod.blocks.handler.GuiHandler;
import com.main.mod.food.Cheese;
import com.main.mod.food.Sandwich;
import com.main.mod.food.SlicedBread;
import com.main.mod.proxy.CommonProxy;
import com.main.mod.tileentity.TileEntityCrucibleOven;
import com.main.mod.weapons.Aluminum.*;
import com.main.mod.weapons.HardenedDiamond.*;
import com.main.mod.weapons.Nickel.*;
import com.main.mod.weapons.Tin.*;
import com.main.mod.weapons.Copper.*;
import com.main.mod.worldgen.MegaOreWorldGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Brandon Boyd on 12/1/14-5:53 PM Project Name: MegaOre Mod.
 */

@Mod(modid = Main.modid, version = Main.version, name = Main.name)
public class Main {

    public static final String modid = "main";
    public static final String version = "Alpha";
    public static final String name = "Mega Ore";

    MegaOreWorldGen eventWorldGen = new MegaOreWorldGen();

    @Mod.Instance(modid)
    public static Main instance;

    public static CreativeTabs megaoreTab;
    public static CreativeTabs megaorematerialsTab;
    public static CreativeTabs megaoreToolsTab;
    public static CreativeTabs megaoreFoodTab;

//Tools Materials
    public static Item.ToolMaterial CopperToolMaterial = EnumHelper.addToolMaterial("CopperTool", 1, 350, 7.0F, 10.0F, 30);
    public static Item.ToolMaterial TinToolMaterial = EnumHelper.addToolMaterial("TinTool", 2, 500, 4.0F, 6.0F, 30);
    public static Item.ToolMaterial NickelToolMaterial = EnumHelper.addToolMaterial("NickelTool", 3, 1150, 8.0F, 8.0F, 30);
    public static Item.ToolMaterial AluminumToolMaterial = EnumHelper.addToolMaterial("AluminumTool", 3, 2350, 10.0F, 10.0F, 30);
    public static Item.ToolMaterial HardenedDiamondToolMaterial = EnumHelper.addToolMaterial("HardenedDiamond", 3, 4576, 50.0F, 50.0F, 50);

//Armor Materials
    public static ItemArmor.ArmorMaterial CopperArmorMaterial = EnumHelper.addArmorMaterial("CopperArmor", 13, new int[]{2, 4, 3, 2,}, 30);
    public static ItemArmor.ArmorMaterial TinArmorMaterial = EnumHelper.addArmorMaterial("TinArmor", 24, new int[]{3, 5, 3, 3}, 30);
    public static ItemArmor.ArmorMaterial NickelArmorMaterial = EnumHelper.addArmorMaterial("NickelArmor", 30, new int[]{4, 6, 5, 3}, 30);
    public static ItemArmor.ArmorMaterial AluminumArmorMaterial = EnumHelper.addArmorMaterial("AluminumArmor", 42, new int[]{6, 9, 7, 5}, 30);
    public static ItemArmor.ArmorMaterial HardenedDiamondArmorMaterial = EnumHelper.addArmorMaterial("HardenedArmorDiamond", 136, new int[]{13, 26, 20, 18}, 50);

//Blocks
    //Ores
    public static Block oreCopperOre;
    public static Block oreTinOre;
    public static Block oreNickelOre;
    public static Block oreAluminumOre;
    public static Block oreCrystalCoalOre;
    //Nether Ores
    public static Block oreNetherCopperOre;
    public static Block oreNetherTinOre;
    public static Block oreNetherNickelOre;
    public static Block oreNetherAluminumOre;
    public static Block oreNetherCrystalCoalOre;
    //Metal Blocks
    public static Block blockCopperBlock;
    public static Block blockTinBlock;
    public static Block blockNickelBlock;
    public static Block blockAluminumBlock;
    public static Block blockCrystalCoalBlock;
    //Machines
    public static Block blockCrucibleIdle;
    public static Block blockCrucibleActive;
    public static final int guiIDCrucible = 0;

    //Custom Blocks
    public static Block blockStoneTable;
    public static Block blockMegaTable;
    public static final int guiMegaTable = 1;



//Items
    public static Item itemCopperIngot;
    public static Item itemTinIngot;
    public static Item itemNickelIngot;
    public static Item itemAluminumIngot;
    public static Item itemTinGear;
    public static Item itemCrystalCoal;
    public static Item itemRawCrystalOre;
    public static Item itemObsidianIngot;

//Tools
    //Copper
    public static Item itemCopperSword;
    public static Item itemCopperPick;
    public static Item itemCopperAxe;
    public static Item itemCopperShovel;
    public static Item itemCopperHoe;
    //Tin
    public static Item itemTinSword;
    public static Item itemTinPick;
    public static Item itemTinAxe;
    public static Item itemTinShovel;
    public static Item itemTinHoe;
    //Nickel
    public static Item itemNickelSword;
    public static Item itemNickelPick;
    public static Item itemNickelAxe;
    public static Item itemNickelShovel;
    public static Item itemNickelHoe;
    //Aluminum
    public static Item itemAluminumSword;
    public static Item itemAluminumPick;
    public static Item itemAluminumAxe;
    public static Item itemAluminumShovel;
    public static Item itemAluminumHoe;
    //Hardened Diamond
    public static Item itemHardenedDiamondSword;
    public static Item itemHardenedDiamondPick;
    public static Item itemHardenedDiamondAxe;
    public static Item itemHardenedDiamondShovel;
    public static Item itemHardenedDiamondHoe;

    //Copper
    public static Item itemCopperHelmet;
    public static Item itemCopperChest;
    public static Item itemCopperLegs;
    public static Item itemCopperBoots;
    //Tin
    public static Item itemTinHelmet;
    public static Item itemTinChest;
    public static Item itemTinLegs;
    public static Item itemTinBoots;
    //Nickel
    public static Item itemNickelHelmet;
    public static Item itemNickelChest;
    public static Item itemNickelLegs;
    public static Item itemNickelBoots;
    //Aluminum
    public static Item itemAluminumHelmet;
    public static Item itemAluminumChest;
    public static Item itemAluminumLegs;
    public static Item itemAluminumBoots;
    //Diamond
    public static Item itemHardenedDiamond;
    public static Item itemHardenedDiamondHelmet;
    public static Item itemHardenedDiamondChest;
    public static Item itemHardenedDiamondLegs;
    public static Item itemHardenedDiamondBoots;
    //Food
    public static Item foodCheese;
    public static Item foodSlicedBread;
    public static Item foodSandwich;

  //Armor IDs
    //Copper
    public static int copperHelmetID;
    public static int copperChestID;
    public static int copperLegsID;
    public static int copperBootsID;
    //Tin
    public static int tinHelmetID;
    public static int tinChestID;
    public static int tinLegsID;
    public static int tinBootsID;
    //Nickel
    public static int nickelHelmetID;
    public static int nickelChestID;
    public static int nickelLegsID;
    public static int nickelBootsID;
    //Aluminum
    public static int aluminumHelmetID;
    public static int aluminumChestID;
    public static int aluminumLegsID;
    public static int aluminumBootsID;
    //Hardened Diamond
    public static int hardenedDiamondHelmetID;
    public static int hardenedDiamondChestID;
    public static int hardenedDiamondLegsID;
    public static int hardenedDiamondBootsID;


    @SidedProxy(clientSide = "com.main.mod.proxy.ClientProxy", serverSide = "com.main.mod.proxy.CommonProxy")
    public static CommonProxy myProxy;

    public static final Enchantment LongerDurability = new EnchantmentDurability(84, 5);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preEvent) {

        megaoreTab = new CreativeTabs("megaore") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Item.getItemFromBlock(Main.oreNetherAluminumOre);
            }
        };

        megaorematerialsTab = new CreativeTabs("megaorematerials") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Main.itemObsidianIngot;
            }
        };

        megaoreToolsTab = new CreativeTabs("megaoretools") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {return Main.itemHardenedDiamondSword;
            }

        };

        megaoreFoodTab = new CreativeTabs("megaorefood") {
            @SideOnly(Side.CLIENT)
            public Item getTabIconItem() {
                return Main.foodCheese;
            }
        };



    //Armor
        //Copper
        itemCopperHelmet = new CopperArmor(CopperArmorMaterial, copperHelmetID, 0).setUnlocalizedName("CopperHelmet");
        GameRegistry.registerItem(itemCopperHelmet, "CopperHelmet");
        itemCopperChest = new CopperArmor(CopperArmorMaterial, copperChestID, 1).setUnlocalizedName("CopperChest");
        GameRegistry.registerItem(itemCopperChest, "CopperChest");
        itemCopperLegs = new CopperArmor(CopperArmorMaterial, copperLegsID, 2).setUnlocalizedName("CopperLegs");
        GameRegistry.registerItem(itemCopperLegs, "CopperLegs");
        itemCopperBoots = new CopperArmor(CopperArmorMaterial, copperBootsID, 3).setUnlocalizedName("CopperBoots");
        GameRegistry.registerItem(itemCopperBoots, "CopperBoots");
        //Tin
        itemTinHelmet = new TinArmor(TinArmorMaterial, tinHelmetID, 0).setUnlocalizedName("TinHelmet");
        GameRegistry.registerItem(itemTinHelmet, "TinHelmet");
        itemTinChest = new TinArmor(TinArmorMaterial, tinChestID, 1).setUnlocalizedName("TinChest");
        GameRegistry.registerItem(itemTinChest, "TinChest");
        itemTinLegs = new TinArmor(TinArmorMaterial, tinLegsID, 2).setUnlocalizedName("TinLegs");
        GameRegistry.registerItem(itemTinLegs, "TinLegs");
        itemTinBoots = new TinArmor(TinArmorMaterial, tinBootsID, 3).setUnlocalizedName("TinBoots");
        GameRegistry.registerItem(itemTinBoots, "TinBoots");
        //Nickel
        itemNickelHelmet = new NickelArmor(NickelArmorMaterial, nickelHelmetID, 0).setUnlocalizedName("NickelHelmet");
        GameRegistry.registerItem(itemNickelHelmet, "NickelHelmet");
        itemNickelChest = new NickelArmor(NickelArmorMaterial, nickelChestID, 1).setUnlocalizedName("NickelChest");
        GameRegistry.registerItem(itemNickelChest, "NickelChest");
        itemNickelLegs = new NickelArmor(NickelArmorMaterial, nickelLegsID, 2).setUnlocalizedName("NickelLegs");
        GameRegistry.registerItem(itemNickelLegs, "NickelLegs");
        itemNickelBoots = new NickelArmor(NickelArmorMaterial, nickelBootsID, 3).setUnlocalizedName("NickelBoots");
        GameRegistry.registerItem(itemNickelBoots, "NickelBoots");
        //Aluminum
        itemAluminumHelmet = new AluminumArmor(AluminumArmorMaterial, aluminumHelmetID, 0).setUnlocalizedName("AluminumHelmet");
        GameRegistry.registerItem(itemAluminumHelmet, "AluminumHelmet");
        itemAluminumChest = new AluminumArmor(AluminumArmorMaterial, aluminumChestID, 1).setUnlocalizedName("AluminumChest");
        GameRegistry.registerItem(itemAluminumChest, "AluminumChest");
        itemAluminumLegs = new AluminumArmor(AluminumArmorMaterial, aluminumLegsID, 2).setUnlocalizedName("AluminumLegs");
        GameRegistry.registerItem(itemAluminumLegs, "AluminumLegs");
        itemAluminumBoots = new AluminumArmor(AluminumArmorMaterial, aluminumBootsID, 3).setUnlocalizedName("AluminumBoots");
        GameRegistry.registerItem(itemAluminumBoots, "AluminumBoots");
        //Hardened Diamond
        itemHardenedDiamondHelmet = new HardenedDiamond(HardenedDiamondArmorMaterial, hardenedDiamondHelmetID, 0).setUnlocalizedName("HardenedHelmet");
        GameRegistry.registerItem(itemHardenedDiamondHelmet, "HardenedHelmet");
        itemHardenedDiamondChest = new HardenedDiamond(HardenedDiamondArmorMaterial, hardenedDiamondChestID, 1).setUnlocalizedName("HardenedChest");
        GameRegistry.registerItem(itemHardenedDiamondChest, "HardenedChest");
        itemHardenedDiamondLegs = new HardenedDiamond(HardenedDiamondArmorMaterial, hardenedDiamondLegsID, 2).setUnlocalizedName("HardenedLegs");
        GameRegistry.registerItem(itemHardenedDiamondLegs, "HardenedLegs");
        itemHardenedDiamondBoots = new HardenedDiamond(HardenedDiamondArmorMaterial, hardenedDiamondBootsID, 3).setUnlocalizedName("HardenedBoots");
        GameRegistry.registerItem(itemHardenedDiamondBoots, "HardenedBoots");


    //Items
        itemCopperIngot = new MOItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        itemTinIngot = new MOItems().setUnlocalizedName("TinIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        itemNickelIngot = new MOItems().setUnlocalizedName("NickelIngot");
        GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
        itemAluminumIngot = new MOItems().setUnlocalizedName("AluminumIngot");
        GameRegistry.registerItem(itemAluminumIngot, "AluminumIngot");
        itemTinGear = new MOItems().setUnlocalizedName("TinGear");
        GameRegistry.registerItem(itemTinGear, "TinGear");
        itemCrystalCoal = new MOItems().setUnlocalizedName("CrystalCoal");
        GameRegistry.registerItem(itemCrystalCoal, "CrystalCoal");
        itemRawCrystalOre = new MOItems().setUnlocalizedName("RawCrystal");
        GameRegistry.registerItem(itemRawCrystalOre, "RawCrystal");
        itemHardenedDiamond = new MOItems().setUnlocalizedName("HardenedDiamond");
        GameRegistry.registerItem(itemHardenedDiamond, "HardenedDiamond");
        itemObsidianIngot = new MOItems().setUnlocalizedName("ObsidianIngot");
        GameRegistry.registerItem(itemObsidianIngot, "ObsidianIngot");

    //Food
        foodCheese = new Cheese(3, 0.2F, false).setUnlocalizedName("Cheese");
        GameRegistry.registerItem(foodCheese, "Cheese");
        foodSlicedBread = new SlicedBread(2, 0.2F, false).setUnlocalizedName("SlicedBread");
        GameRegistry.registerItem(foodSlicedBread, "SlicedBread");
        foodSandwich = new Sandwich(10, 1.0F, true).setUnlocalizedName("Sandwich");
        GameRegistry.registerItem(foodSandwich, "Sandwich");

    //Tools
        //Copper
        itemCopperSword = new CopperSword(CopperToolMaterial).setUnlocalizedName("CopperSword");
        GameRegistry.registerItem(itemCopperSword, "CopperSword");
        itemCopperPick = new CopperPick(CopperToolMaterial).setUnlocalizedName("CopperPick");
        GameRegistry.registerItem(itemCopperPick, "CopperPick");
        itemCopperAxe = new CopperAxe(CopperToolMaterial).setUnlocalizedName("CopperAxe");
        GameRegistry.registerItem(itemCopperAxe, "CopperAxe");
        itemCopperShovel = new CopperShovel(CopperToolMaterial).setUnlocalizedName("CopperShovel");
        GameRegistry.registerItem(itemCopperShovel, "CopperShovel");
        itemCopperHoe = new CopperHoe(CopperToolMaterial).setUnlocalizedName("CopperHoe");
        GameRegistry.registerItem(itemCopperHoe, "CopperHoe");
        //Tin
        itemTinSword = new TinSword(TinToolMaterial).setUnlocalizedName("TinSword");
        GameRegistry.registerItem(itemTinSword, "TinSword");
        itemTinPick = new TinPick(TinToolMaterial).setUnlocalizedName("TinPick");
        GameRegistry.registerItem(itemTinPick, "TinPick");
        itemTinAxe = new TinAxe(TinToolMaterial).setUnlocalizedName("TinAxe");
        GameRegistry.registerItem(itemTinAxe, "TinAxe");
        itemTinShovel = new TinShovel(TinToolMaterial).setUnlocalizedName("TinShovel");
        GameRegistry.registerItem(itemTinShovel, "TinShovel");
        itemTinHoe = new TinHoe(TinToolMaterial).setUnlocalizedName("TinHoe");
        GameRegistry.registerItem(itemTinHoe, "TinHoe");
        //Nickel
        itemNickelSword = new NickelSword(NickelToolMaterial).setUnlocalizedName("NickelSword");
        GameRegistry.registerItem(itemNickelSword, "NickelSword");
        itemNickelPick = new NickelPick(NickelToolMaterial).setUnlocalizedName("NickelPick");
        GameRegistry.registerItem(itemNickelPick, "NickelPick");
        itemNickelAxe = new NickelAxe(NickelToolMaterial).setUnlocalizedName("NickelAxe");
        GameRegistry.registerItem(itemNickelAxe, "NickelAxe");
        itemNickelShovel = new NickelShovel(NickelToolMaterial).setUnlocalizedName("NickelShovel");
        GameRegistry.registerItem(itemNickelShovel, "NickelShovel");
        itemNickelHoe = new NickelHoe(NickelToolMaterial).setUnlocalizedName("NickelHoe");
        //Aluminum
        itemAluminumSword = new AluminumSword(AluminumToolMaterial).setUnlocalizedName("AluminumSword");
        GameRegistry.registerItem(itemAluminumSword, "AluminumSword");
        itemAluminumShovel = new AluminumShovel(AluminumToolMaterial).setUnlocalizedName("AluminumShovel");
        GameRegistry.registerItem(itemAluminumShovel, "AluminumShovel");
        itemAluminumPick = new AluminumPick(AluminumToolMaterial).setUnlocalizedName("AluminumPick");
        GameRegistry.registerItem(itemAluminumPick, "AluminumPick");
        itemAluminumAxe = new AluminumAxe(AluminumToolMaterial).setUnlocalizedName("AluminumAxe");
        GameRegistry.registerItem(itemAluminumAxe, "AluminumAxe");
        itemAluminumHoe = new AluminumHoe(AluminumToolMaterial).setUnlocalizedName("AluminumHoe");
        GameRegistry.registerItem(itemAluminumHoe, "AluminumHoe");
        //Hardened Diamond
        itemHardenedDiamondSword = new HardenedSword(HardenedDiamondToolMaterial).setUnlocalizedName("HardenedSword");
        GameRegistry.registerItem(itemHardenedDiamondSword, "HardenedSword");
        itemHardenedDiamondPick = new HardenedPick(HardenedDiamondToolMaterial).setUnlocalizedName("HardenedPick");
        GameRegistry.registerItem(itemHardenedDiamondPick, "HardenedPick");
        itemHardenedDiamondAxe = new HardenedAxe(HardenedDiamondToolMaterial).setUnlocalizedName("HardenedAxe");
        GameRegistry.registerItem(itemHardenedDiamondAxe, "HardenedAxe");
        itemHardenedDiamondShovel = new HardenedShovel(HardenedDiamondToolMaterial).setUnlocalizedName("HardenedShovel");
        GameRegistry.registerItem(itemHardenedDiamondShovel, "HardenedShovel");
        itemHardenedDiamondHoe = new HardenedHoe(HardenedDiamondToolMaterial).setUnlocalizedName("HardenedHoe");
        GameRegistry.registerItem(itemHardenedDiamondHoe, "HardenedHoe");

    //Blocks
        //Ores
        oreAluminumOre = new HighOre(Material.rock).setBlockName("AluminumOre");
        GameRegistry.registerBlock(oreAluminumOre, "AluminumOre");
        oreCopperOre = new LowOre(Material.rock).setBlockName("CopperOre");
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");
        oreNickelOre = new HighOre(Material.rock).setBlockName("NickelOre");
        GameRegistry.registerBlock(oreNickelOre, "NickelOre");
        oreTinOre = new LowOre(Material.rock).setBlockName("TinOre");
        GameRegistry.registerBlock(oreTinOre, "TinOre");
        oreCrystalCoalOre = new OreBlock(Material.rock).setBlockName("CrystalOre");
        GameRegistry.registerBlock(oreCrystalCoalOre, "CrystalOre");
        //Nether
        oreNetherAluminumOre = new HighOre(Material.rock).setBlockName("Nether_AluminumOre");
        GameRegistry.registerBlock(oreNetherAluminumOre, "Nether_AluminumOre");
        oreNetherCopperOre = new LowOre(Material.rock).setBlockName("Nether_CopperOre");
        GameRegistry.registerBlock(oreNetherCopperOre, "Nether_CopperOre");
        oreNetherTinOre = new LowOre(Material.rock).setBlockName("Nether_TinOre");
        GameRegistry.registerBlock(oreNetherTinOre, "Nether_TInOre");
        oreNetherNickelOre = new HighOre(Material.rock).setBlockName("Nether_NickelOre");
        GameRegistry.registerBlock(oreNetherNickelOre, "Nether_NickelOre");
        oreNetherCrystalCoalOre = new OreBlock(Material.rock).setBlockName("Nether_CrystalOre");

    //Metal Blocks
        blockCopperBlock = new LowMetalBlock(Material.iron).setBlockName("CopperBlock");
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
        blockTinBlock = new LowMetalBlock(Material.iron).setBlockName("TinBlock");
        GameRegistry.registerBlock(blockTinBlock, "TinBlock");
        blockNickelBlock = new HighMetalBlock(Material.iron).setBlockName("NickelBlock");
        GameRegistry.registerBlock(blockNickelBlock, "NickelBlock");
        blockAluminumBlock = new HighMetalBlock(Material.iron).setBlockName("AluminumBlock");
        GameRegistry.registerBlock(blockAluminumBlock, "AluminumBlock");

    //Custom Blocks
        blockStoneTable = new StoneBlock(Material.rock).setBlockName("StoneTable");
        GameRegistry.registerBlock(blockStoneTable, "StoneTable");

    //Machines
        //Furnace
        blockCrucibleIdle = new CrucibleOven(false).setBlockName("CrucibleIdle").setCreativeTab(Main.megaoreToolsTab).setHardness(4.0F);
        GameRegistry.registerBlock(blockCrucibleIdle, "CrucibleIdle");
        blockCrucibleActive = new CrucibleOven(true).setBlockName("CrucibleActive").setLightLevel(0.9F).setHardness(4.0F);
        GameRegistry.registerBlock(blockCrucibleActive, "CrucibleActive");
        //Mega Table
        blockMegaTable = new MegaTable().setBlockName("MegaTable");
        GameRegistry.registerBlock(blockMegaTable, "MegaTable");

    //Fuel Blocks
        blockCrystalCoalBlock = new CoalBlock(Material.rock).setBlockName("CrystalBlock");
        GameRegistry.registerBlock(blockCrystalCoalBlock, "CrystalBlock");

    //World Spawn
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);

    //Renderers
        myProxy.registerRenderThings();




    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {

    //Shaped Recipes
        //Metal Blocks
        GameRegistry.addRecipe(new ItemStack(blockCopperBlock), "CCC", "CCC", "CCC", 'C', itemCopperIngot);
        GameRegistry.addRecipe(new ItemStack(blockTinBlock), "CCC", "CCC", "CCC", 'C', itemTinIngot);
        GameRegistry.addRecipe(new ItemStack(blockNickelBlock), "CCC", "CCC", "CCC", 'C', itemNickelIngot);
        GameRegistry.addRecipe(new ItemStack(blockAluminumBlock), "CCC", "CCC", "CCC", 'C', itemAluminumIngot);
        GameRegistry.addRecipe(new ItemStack(itemTinGear, 4), " X ", "X X", " X ", 'X', itemTinIngot);
        GameRegistry.addRecipe(new ItemStack(blockCrystalCoalBlock), "CCC", "CCC", "CCC", 'C', itemCrystalCoal);
        //Tools
            //Swords
        GameRegistry.addRecipe(new ItemStack(itemCopperSword), " x ", " x ", " y ", 'x', itemCopperIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemTinSword), " x ", " x ", " y ", 'x', itemTinIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemNickelSword), " x ", " x ", " y ", 'x', itemNickelIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemAluminumSword), " x ", " x ", " y ", 'x', itemAluminumIngot, 'y', Items.stick);
            //Pickaxes
        GameRegistry.addRecipe(new ItemStack(itemCopperPick), "xxx", " y ", " y ", 'x', itemCopperIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemTinPick), "xxx", " y ", " y ", 'x', itemTinIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemNickelPick), "xxx", " y ", " y ", 'x', itemNickelIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemAluminumPick), "xxx", " y ", " y ", 'x', itemAluminumIngot, 'y', Items.stick);
            //Axes
        GameRegistry.addRecipe(new ItemStack(itemCopperAxe), "xx ", "xy "," y ", 'x', itemCopperIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemTinAxe), "xx ", "xy "," y ", 'x', itemTinIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemNickelAxe), "xx ", "xy "," y ", 'x', itemNickelIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemAluminumAxe), "xx ", "xy "," y ", 'x', itemAluminumIngot, 'y', Items.stick);
            //Shovels
        GameRegistry.addRecipe(new ItemStack(itemCopperShovel), " x ", " y ", " y ", 'x', itemCopperIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemTinShovel), " x ", " y ", " y ", 'x', itemTinIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemNickelShovel), " x ", " y ", " y ", 'x', itemNickelIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemAluminumShovel), " x ", " y ", " y ", 'x', itemAluminumIngot, 'y', Items.stick);
            //Hoes
        GameRegistry.addRecipe(new ItemStack(itemCopperHoe), "xx ", " y ", " y ", 'x', itemCopperIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemTinHoe), "xx ", " y ", " y ", 'x', itemTinIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemNickelHoe), "xx ", " y ", " y ", 'x', itemNickelHoe, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(itemAluminumHoe), "xx ", " y ", " y ", 'x', itemAluminumHoe, 'y', Items.stick);

    //Armor
        //Copper
        GameRegistry.addRecipe(new ItemStack(itemCopperHelmet), "xxx", "x x", 'x', itemCopperIngot);
        GameRegistry.addRecipe(new ItemStack(itemCopperChest), "x x", "xxx", "xxx", 'x', itemCopperIngot);
        GameRegistry.addRecipe(new ItemStack(itemCopperLegs), "xxx", "x x", "x x", 'x', itemCopperIngot);
        GameRegistry.addRecipe(new ItemStack(itemCopperBoots), "x x", "x x", 'x', itemCopperIngot);
        //Nickel
        GameRegistry.addRecipe(new ItemStack(itemNickelHelmet), "xxx", "x x", 'x', itemNickelIngot);
        GameRegistry.addRecipe(new ItemStack(itemNickelChest), "x x", "xxx", "xxx", 'x', itemNickelIngot);
        GameRegistry.addRecipe(new ItemStack(itemNickelLegs), "xxx", "x x", "x x", 'x', itemNickelIngot);
        GameRegistry.addRecipe(new ItemStack(itemNickelBoots), "x x", "x x", 'x', itemNickelIngot);
        //Tin
        GameRegistry.addRecipe(new ItemStack(itemTinHelmet), "xxx", "x x", 'x', itemTinIngot);
        GameRegistry.addRecipe(new ItemStack(itemTinChest), "x x", "xxx", "xxx", 'x', itemTinIngot);
        GameRegistry.addRecipe(new ItemStack(itemTinLegs), "xxx", "x x", "x x", 'x', itemTinIngot);
        GameRegistry.addRecipe(new ItemStack(itemTinBoots), "x x", "x x", 'x', itemTinIngot);
        //Aluminum
        GameRegistry.addRecipe(new ItemStack(itemAluminumHelmet), "xxx", "x x", 'x', itemAluminumIngot);
        GameRegistry.addRecipe(new ItemStack(itemAluminumChest), "x x", "xxx", "xxx", 'x', itemAluminumIngot);
        GameRegistry.addRecipe(new ItemStack(itemAluminumLegs), "xxx", "x x", "x x", 'x', itemAluminumIngot);
        GameRegistry.addRecipe(new ItemStack(itemAluminumBoots), "x x", "x x", 'x', itemAluminumIngot);



     //Shapeless Recipes
        GameRegistry.addShapelessRecipe(new ItemStack(itemCopperIngot, 9), blockCopperBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(itemTinIngot, 9), blockTinBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(itemNickelIngot, 9), blockNickelBlock);
        GameRegistry.addShapelessRecipe(new ItemStack(itemAluminumIngot, 9), blockAluminumBlock);


    //Smelting
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 1.0F);
        GameRegistry.addSmelting(oreAluminumOre, new ItemStack(itemAluminumIngot), 1.0F);
        GameRegistry.addSmelting(oreNickelOre, new ItemStack(itemNickelIngot), 1.0F);
        GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 1.0F);
        GameRegistry.addSmelting(itemRawCrystalOre, new ItemStack(itemCrystalCoal), 1.0F);
        GameRegistry.addSmelting(oreNetherAluminumOre, new ItemStack(itemAluminumIngot), 1.0F);
        GameRegistry.addSmelting(oreNetherCopperOre, new ItemStack(itemCopperIngot), 1.0F);
        GameRegistry.addSmelting(oreNetherTinOre, new ItemStack(itemTinIngot), 1.0F);
        GameRegistry.addSmelting(oreNetherNickelOre, new ItemStack(itemNickelIngot), 1.0F);
        GameRegistry.addSmelting(Items.diamond, new ItemStack(itemHardenedDiamond), 1.0F);
        GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(itemObsidianIngot,2), 1.0F);

    //Fuels
        GameRegistry.registerFuelHandler(new FuelHandler());
        GameRegistry.registerFuelHandler(new CoalFuelHandler());

    //TileEntities
        GameRegistry.registerTileEntity(TileEntityCrucibleOven.class, "Crucible");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent postInit) {

    }

}
