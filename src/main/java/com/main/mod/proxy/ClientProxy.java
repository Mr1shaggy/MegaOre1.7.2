package com.main.mod.proxy;

import com.main.mod.Main;
import com.main.mod.render.ItemRenderStoneTable;
import com.main.mod.render.RenderStoneTable;
import com.main.mod.tileentity.TileEntityStoneBlock;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Brandon Boyd on 12/11/14-2:24 PM Project Name: MegaOre Mod.
 */
public class ClientProxy extends CommonProxy {

    public void registerRenderThings() {
        //Stone Table
        TileEntitySpecialRenderer render = new RenderStoneTable();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneBlock.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Main.blockStoneTable), new ItemRenderStoneTable(render, new TileEntityStoneBlock()));

    }

    public void registerTileEntitySpecialRenderer() {

    }
}
