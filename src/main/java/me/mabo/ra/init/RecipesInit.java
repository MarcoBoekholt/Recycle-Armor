package me.mabo.ra.init;

import me.mabo.ra.RecycleArmor;
import me.mabo.ra.recipes.RecipesInventoryFurnace;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.Iterator;
import java.util.Map;

public class RecipesInit {

    public static void init() {
        // Iron
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.IRON_HELMET), new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.IRON_CHESTPLATE), new ItemStack(Items.IRON_INGOT, 5, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.IRON_LEGGINGS), new ItemStack(Items.IRON_INGOT, 4, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.IRON_BOOTS), new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);

        // Chainmail
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.CHAINMAIL_HELMET), new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.CHAINMAIL_CHESTPLATE), new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.CHAINMAIL_LEGGINGS), new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.CHAINMAIL_BOOTS), new ItemStack(Items.IRON_INGOT, 1, 0), 0.1F);

        // Gold
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.GOLDEN_HELMET), new ItemStack(Items.GOLD_INGOT, 3, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.GOLDEN_CHESTPLATE), new ItemStack(Items.GOLD_INGOT, 5, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.GOLDEN_LEGGINGS), new ItemStack(Items.GOLD_INGOT, 4, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.GOLDEN_BOOTS), new ItemStack(Items.GOLD_INGOT, 2, 0), 0.1F);

        // Diamond
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.DIAMOND_HELMET), new ItemStack(Items.DIAMOND, 3, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.DIAMOND_CHESTPLATE), new ItemStack(Items.DIAMOND, 5, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.DIAMOND_LEGGINGS), new ItemStack(Items.DIAMOND, 4, 0), 0.1F);
        RecipesInventoryFurnace.getInstance().addRecycleRecipe(new ItemStack(Items.DIAMOND_BOOTS), new ItemStack(Items.DIAMOND, 2, 0), 0.1F);
    }

    public static void removeRecipes(ItemStack resultStack, String modID) {
        ItemStack result = null;
        Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
        Iterator<ItemStack> iterator = recipes.keySet().iterator();
        while (iterator.hasNext()) {
            ItemStack tmpRecipe = iterator.next();
            result = recipes.get(tmpRecipe);
            if(ItemStack.areItemStacksEqual(resultStack, result)) {
                //RecycleArmor.logger.info(modID + " Removed Recipe: " + tmpRecipe + " -> " + result);
                iterator.remove();
            }
        }
    }

}
