package me.mabo.ra.proxy;

import me.mabo.ra.RecycleArmor;
import me.mabo.ra.blocks.BlockRecycleFurnace;
import me.mabo.ra.tiles.TileRecycleFurnace;
import me.mabo.ra.util.handlers.GuiHandler;
import me.mabo.ra.util.registry.GuiHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

    public static Block blockInventoryAdvanced; // Holds the unique instance of the block
    public static ItemBlock itemBlockInventoryAdvanced; // holds the unique instance of the ItemBlock corresponding to your block

    public void preInit() {
        blockInventoryAdvanced = new BlockRecycleFurnace().setUnlocalizedName("recycle_furnace_unlocalised_name");
        blockInventoryAdvanced.setRegistryName("recycle_furnace");
        ForgeRegistries.BLOCKS.register(blockInventoryAdvanced);

        // We also need to create and register an ItemBlock for this block otherwise it won't appear in the inventory
        itemBlockInventoryAdvanced = new ItemBlock(blockInventoryAdvanced);
        itemBlockInventoryAdvanced.setRegistryName(blockInventoryAdvanced.getRegistryName());
        ForgeRegistries.ITEMS.register(itemBlockInventoryAdvanced);

        GameRegistry.registerTileEntity(TileRecycleFurnace.class, "recycle_furnace");

        NetworkRegistry.INSTANCE.registerGuiHandler(RecycleArmor.instance, GuiHandlerRegistry.getInstance());
        GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandler(), GuiHandler.getGuiID());

    }

    public void init() {

    }

    public void postInit() {

    }
}
