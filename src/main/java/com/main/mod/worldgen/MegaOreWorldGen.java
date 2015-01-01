package com.main.mod.worldgen;

import com.main.mod.Main;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

/**
 * Created by brandon on 12/3/14.
 */
public class MegaOreWorldGen implements IWorldGenerator {




    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkProvider, IChunkProvider chunkGenerator) {
        switch (world.provider.dimensionId) {
            case 0 :
                //Generate Surface
                generateSurface(world, random, chunkX*16, chunkZ*16);

            case -1 :
                //Generate Nether
                generateNether(world, random, chunkX * 16, chunkZ * 16);

            case 1 :
                //Generate End
                generateEnd(world, random, chunkX*16, chunkZ*16);
        }
    }

    public void generateSurface(World world, Random random, int x, int z) {
      //this.addOreSpawn(Main.myOre, world, random, blocksXpos, blocksZpos, maxX, maxZ, maxVeinSize, chanceToSpawn, minY, maxY);
        this.addOreSpawn(Main.oreCopperOre, world, random, x, z, 16, 16, 6+random.nextInt(10), 50, 50, 100);
        this.addOreSpawn(Main.oreAluminumOre, world, random, x, z, 16, 16, 1+random.nextInt(4), 50, 25, 50);
        this.addOreSpawn(Main.oreNickelOre, world, random, x, z, 16, 16, 3+random.nextInt(5), 50, 25, 50);
        this.addOreSpawn(Main.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 80, 50, 150);
        this.addOreSpawn(Main.oreCrystalCoalOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 50, 30, 100);

    }

    public void generateNether(World world, Random random, int x, int z) {
        this.addNetherOreSpawn(Main.oreNetherCopperOre, world, random, x, z, 16, 16, 6+random.nextInt(10), 50, 50, 100);
        this.addNetherOreSpawn(Main.oreNetherAluminumOre, world, random, x, z, 16, 16, 1+random.nextInt(4), 50, 25, 50);
        this.addNetherOreSpawn(Main.oreNetherNickelOre, world, random, x, z, 16, 16, 3+random.nextInt(5), 50, 25, 50);
        this.addNetherOreSpawn(Main.oreNetherTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 80, 50, 150);
        this.addNetherOreSpawn(Main.oreNetherCrystalCoalOre, world, random, x, z, 16, 16, 2+random.nextInt(4), 50, 30, 100);

    }

    public void generateEnd(World world, Random random, int i, int j) {

    }

    public void addOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for(int i = 0; i < chanceToSpawn; i++) {
            int posX = blockX + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZ + random.nextInt(maxZ);
            (new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

    public void addNetherOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for (int i = 0; i < chanceToSpawn; i++) {
            int posX = blockX + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZ + random.nextInt(maxZ);
            (new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }
}
