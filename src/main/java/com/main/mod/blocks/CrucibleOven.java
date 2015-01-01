package com.main.mod.blocks;

import com.main.mod.Main;
import com.main.mod.tileentity.TileEntityCrucibleOven;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Brandon Boyd on 12/6/14-9:17 PM Project Name: Mega Ore Mod.
 */
public class CrucibleOven extends BlockContainer {

    private final boolean isActive;

    @SideOnly(Side.CLIENT)
    public IIcon iconTop;

    @SideOnly(Side.CLIENT)
    public IIcon iconFront;

    public static boolean keepInventory;
    private Random rand = new Random();

    public CrucibleOven(boolean isActive) {
        super(Material.iron);
        this.isActive = isActive;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {

        this.blockIcon = iconRegister.registerIcon(Main.modid + ":" + "OvenSide");
        this.iconFront = iconRegister.registerIcon(Main.modid + ":" + (this.isActive ? "OvenFrontOn" : "OvenFrontOff"));
        this.iconTop = iconRegister.registerIcon(Main.modid + ":" + "OvenTop");

    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata){
        return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
    }

    public Item getItemDropped(int i, Random random, int j) {

        return Item.getItemFromBlock(Main.blockCrucibleIdle);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if(!world.isRemote) {
            Block b1 = world.getBlock(x, y, z - 1);
            Block b2 = world.getBlock(x, y, z + 1);
            Block b3 = world.getBlock(x - 1, y, z);
            Block b4 = world.getBlock(x + 1, y, z);

            byte b0 = 3;

            if(b1.func_149730_j() && !b2.func_149730_j()) {
                b0 = 3;
            }

            if(b2.func_149730_j() && !b1.func_149730_j()) {
                b0 = 2;
            }

            if(b3.func_149730_j() && !b4.func_149730_j()) {
                b0 = 5;
            }

            if(b4.func_149730_j() && !b3.func_149730_j()) {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z,b0, 2 );

        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            FMLNetworkHandler.openGui(player, Main.instance, Main.guiIDCrucible, world, x, y, z);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if(this.isActive) {
            int direction = world.getBlockMetadata(x, y, z);

            float x1 = (float)x + 0.5F;
            float y1 = (float)y + random.nextFloat();
            float z1 = (float)z + 0.5F;

            float f = 0.52F;
            float f1 = random.nextFloat() * 0.6F - 0.3F;

            if(direction == 4) {
                world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
            }

            if(direction == 5) {
                world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
            }

            if(direction == 2) {
                world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
            }

            if(direction == 3) {
                world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
                world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
            }
        }
    }


    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityCrucibleOven();
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {

        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.F) + 0.5F) & 3;

        if(l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if(l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if(l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if(l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }

        if(itemStack.hasDisplayName()) {
            ((TileEntityCrucibleOven)world.getTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
        }

    }

    public static void updateCrucibleOvenBlockState(boolean active, World world, int xCoord, int yCoord, int zCoord) {

        int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity tileentity = world.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;
        if(active) {
            world.setBlock(xCoord, yCoord, zCoord, Main.blockCrucibleActive);
        }else{
            world.setBlock(xCoord, yCoord, zCoord, Main.blockCrucibleIdle);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
        if(tileentity != null) {
            tileentity.validate();
            world.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block oBlock, int oMetadata){
        if(!keepInventory) {
            TileEntityCrucibleOven tileentity = (TileEntityCrucibleOven) world.getTileEntity(x, y, z);

            if(tileentity != null) {
                for(int i = 0; i < tileentity.getSizeInventory(); i++) {
                    ItemStack itemStack = tileentity.getStackInSlot(i);
                    if(itemStack != null) {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemStack.stackSize > 0) {
                            int j = this.rand.nextInt(21) + 10;
                            if(j > itemStack.stackSize) {
                                j = itemStack.stackSize;
                            }

                            itemStack.stackSize -= j;
                            EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));
                            if(itemStack.hasTagCompound()) {
                                item.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                            }
                            world.spawnEntityInWorld(item);
                        }
                    }
                }

                world.func_147453_f(x, y, z, oBlock);
            }
        }

        super.breakBlock(world, x, y, z, oBlock, oMetadata);
    }

    public Item getItem(World world, int x, int y, int z) {
        return Item.getItemFromBlock(Main.blockCrucibleIdle);
    }
}
