package com.main.mod.crafting;

import net.minecraft.item.crafting.IRecipe;

import java.util.Comparator;

/**
 * Created by Brandon Boyd on 12/15/14-1:42 AM Project Name: MegaOre Mod.
 */
public class MegaTableRecipeSorter implements Comparator {
    final MegaTableCraftingManager megaTable;

    public MegaTableRecipeSorter(MegaTableCraftingManager megaTableCraftingManager) {
        this.megaTable = megaTableCraftingManager;
    }

    public int compareRecipes(IRecipe r1, IRecipe r2) {
        return r1 instanceof MegaTableShapelessRecipes && r2 instanceof MegaTableShapedRecipes ? 1 : (r2 instanceof MegaTableShapelessRecipes && r1 instanceof MegaTableShapedRecipes ? - 1 : (r2.getRecipeSize() < r1.getRecipeSize() ? - 1 : (r2.getRecipeSize() > r1.getRecipeSize() ? 1 : 0)));
    }


    @Override
    public int compare(Object o1, Object o2) {
        return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
    }
}
