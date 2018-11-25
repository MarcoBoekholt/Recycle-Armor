package me.mabo.ra.init;

import me.mabo.ra.RecycleArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class RecipesInit {



    public static void init() {
        // Leather
        GameRegistry.addSmelting(Items.LEATHER_HELMET, new ItemStack(Items.LEATHER, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.LEATHER_CHESTPLATE, new ItemStack(Items.LEATHER, 5, 0), 0.1F);
        GameRegistry.addSmelting(Items.LEATHER_LEGGINGS, new ItemStack(Items.LEATHER, 4, 0), 0.1F);
        GameRegistry.addSmelting(Items.LEATHER_BOOTS, new ItemStack(Items.LEATHER, 2, 0), 0.1F);

        // Iron
        GameRegistry.addSmelting(Items.IRON_HELMET, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.IRON_CHESTPLATE, new ItemStack(Items.IRON_INGOT, 5, 0), 0.1F);
        GameRegistry.addSmelting(Items.IRON_LEGGINGS, new ItemStack(Items.IRON_INGOT, 4, 0), 0.1F);
        GameRegistry.addSmelting(Items.IRON_BOOTS, new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);

        // Chainmail
        GameRegistry.addSmelting(Items.CHAINMAIL_HELMET, new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);
        GameRegistry.addSmelting(Items.CHAINMAIL_CHESTPLATE, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.CHAINMAIL_LEGGINGS, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.CHAINMAIL_BOOTS, new ItemStack(Items.IRON_INGOT, 1, 0), 0.1F);

        // Gold
        GameRegistry.addSmelting(Items.GOLDEN_HELMET, new ItemStack(Items.GOLD_INGOT, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.GOLDEN_CHESTPLATE, new ItemStack(Items.GOLD_INGOT, 5, 0), 0.1F);
        GameRegistry.addSmelting(Items.GOLDEN_LEGGINGS, new ItemStack(Items.GOLD_INGOT, 4, 0), 0.1F);
        GameRegistry.addSmelting(Items.GOLDEN_BOOTS, new ItemStack(Items.GOLD_INGOT, 2, 0), 0.1F);

        // Diamond
        GameRegistry.addSmelting(Items.DIAMOND_HELMET, new ItemStack(Items.DIAMOND, 3, 0), 0.1F);
        GameRegistry.addSmelting(Items.DIAMOND_CHESTPLATE, new ItemStack(Items.DIAMOND, 5, 0), 0.1F);
        GameRegistry.addSmelting(Items.DIAMOND_LEGGINGS, new ItemStack(Items.DIAMOND, 4, 0), 0.1F);
        GameRegistry.addSmelting(Items.DIAMOND_BOOTS, new ItemStack(Items.DIAMOND, 2, 0), 0.1F);


    }

    public static void removeRecipes(ItemStack resultStack, String modID) {
        ItemStack result = null;
        Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
        Iterator<ItemStack> iterator = recipes.keySet().iterator();

        while (iterator.hasNext()) {
            ItemStack tmpRecipe = iterator.next();
            result = recipes.get(tmpRecipe);
            if(ItemStack.areItemStacksEqual(resultStack, result)) {
                RecycleArmor.logger.info(modID + " Removed Recipe: " + tmpRecipe + " -> " + result);
                iterator.remove();
            }
        }
    }

}
