package me.mabo.ra;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Main
{
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event)
  {
    GameRegistry.addSmelting(Items.LEATHER_HELMET, new ItemStack(Items.LEATHER, 3, 0), 0.1F);
    GameRegistry.addSmelting(Items.IRON_HELMET, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
    GameRegistry.addSmelting(Items.CHAINMAIL_HELMET, new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);
    GameRegistry.addSmelting(Items.GOLDEN_HELMET, new ItemStack(Items.GOLD_INGOT, 3, 0), 0.1F);
    GameRegistry.addSmelting(Items.DIAMOND_HELMET, new ItemStack(Items.DIAMOND, 3, 0), 0.1F);
    
    GameRegistry.addSmelting(Items.LEATHER_CHESTPLATE, new ItemStack(Items.LEATHER, 5, 0), 0.1F);
    GameRegistry.addSmelting(Items.IRON_CHESTPLATE, new ItemStack(Items.IRON_INGOT, 5, 0), 0.1F);
    GameRegistry.addSmelting(Items.CHAINMAIL_CHESTPLATE, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
    GameRegistry.addSmelting(Items.GOLDEN_CHESTPLATE, new ItemStack(Items.GOLD_INGOT, 5, 0), 0.1F);
    GameRegistry.addSmelting(Items.DIAMOND_CHESTPLATE, new ItemStack(Items.DIAMOND, 5, 0), 0.1F);
    
    GameRegistry.addSmelting(Items.LEATHER_LEGGINGS, new ItemStack(Items.LEATHER, 4, 0), 0.1F);
    GameRegistry.addSmelting(Items.IRON_LEGGINGS, new ItemStack(Items.IRON_INGOT, 4, 0), 0.1F);
    GameRegistry.addSmelting(Items.CHAINMAIL_LEGGINGS, new ItemStack(Items.IRON_INGOT, 3, 0), 0.1F);
    GameRegistry.addSmelting(Items.GOLDEN_LEGGINGS, new ItemStack(Items.GOLD_INGOT, 4, 0), 0.1F);
    GameRegistry.addSmelting(Items.DIAMOND_LEGGINGS, new ItemStack(Items.DIAMOND, 4, 0), 0.1F);
    
    GameRegistry.addSmelting(Items.LEATHER_BOOTS, new ItemStack(Items.LEATHER, 2, 0), 0.1F);
    GameRegistry.addSmelting(Items.IRON_BOOTS, new ItemStack(Items.IRON_INGOT, 2, 0), 0.1F);
    GameRegistry.addSmelting(Items.CHAINMAIL_BOOTS, new ItemStack(Items.IRON_INGOT, 1, 0), 0.1F);
    GameRegistry.addSmelting(Items.GOLDEN_BOOTS, new ItemStack(Items.GOLD_INGOT, 2, 0), 0.1F);
    GameRegistry.addSmelting(Items.DIAMOND_BOOTS, new ItemStack(Items.DIAMOND, 2, 0), 0.1F);
    

  }

}
