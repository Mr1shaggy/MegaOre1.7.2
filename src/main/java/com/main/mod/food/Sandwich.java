package com.main.mod.food;

import com.main.mod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Brandon Boyd on 12/26/14-1:52 PM Project Name: MegaOre Mod.
 */
public class Sandwich extends ItemFood {

    private int secondpotionId;
    private int secondpotionDuration;
    private int secondpotionAmplifier;
    private float secondpotionEffectProbability;

    private int thirdpotionId;
    private int thirdpotionDuration;
    private int thirdpotionAmplifier;
    private float thirdpotionEffectProbability;

    public Sandwich(int heal, float saturation, boolean wolfeat) {
        super(heal, saturation, wolfeat);
        this.setCreativeTab(Main.megaoreFoodTab);
        this.setPotionEffect(10, 120, 4, 1F);
        this.setSecondPotionEffect(5, 120, 4, 1F);
        this.setThirdPotionEffect(1, 120, 4, 1F);
        this.setTextureName(Main.modid + ":Sandwich");
        this.setAlwaysEdible();   //just for testing but not too bad XD
}

    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        super.onFoodEaten(itemStack, world, entityPlayer);

        if (!world.isRemote && this.secondpotionId > 0 && world.rand.nextFloat() < this.secondpotionEffectProbability) {
            entityPlayer.addPotionEffect(new PotionEffect(this.secondpotionId, this.secondpotionDuration * 20, this.secondpotionAmplifier));

        }else{
            if (!world.isRemote && this.thirdpotionId > 0 && world.rand.nextFloat() < this.thirdpotionEffectProbability) {
                entityPlayer.addPotionEffect(new PotionEffect(this.thirdpotionId, this.thirdpotionDuration * 20, this.thirdpotionAmplifier));

            }
        }
    }

    public ItemFood setSecondPotionEffect(int par1, int par2, int par3, float par4) {
        this.secondpotionId = par1;
        this.secondpotionDuration = par2;
        this.secondpotionAmplifier = par3;
        this.secondpotionEffectProbability = par4;
        return this;
    }

    public ItemFood setThirdPotionEffect(int par1, int par2, int par3, float par4) {
        this.thirdpotionId = par1;
        this.thirdpotionDuration = par2;
        this.thirdpotionAmplifier = par3;
        this.thirdpotionEffectProbability = par4;
        return this;
    }
}
