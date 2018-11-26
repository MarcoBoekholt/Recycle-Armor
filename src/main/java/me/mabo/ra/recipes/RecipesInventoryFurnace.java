package me.mabo.ra.recipes;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Map.Entry;

public class RecipesInventoryFurnace {

    private static final RecipesInventoryFurnace INSTANCE = new RecipesInventoryFurnace();
    /** The list of smelting results. */
    private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    /** A list which contains how many experience points each recipe output will give. */
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static RecipesInventoryFurnace getInstance()
    {
        return INSTANCE;
    }

    private RecipesInventoryFurnace()
    {
       // addRecycleRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.RECYCLE_FURNACE), 5.0F);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addRecycleRecipe(ItemStack input1, ItemStack result, float experience)
    {
        if(getRecycleResult(input1) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, result);
        this.experienceList.put(result, experience);
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getRecycleResult(ItemStack input1)
    {
        for(Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if(this.compareItemStacks(input1, entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getRecycleExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }
        return 0.0F;
    }
}
