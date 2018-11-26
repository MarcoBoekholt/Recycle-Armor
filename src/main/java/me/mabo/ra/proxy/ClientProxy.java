package me.mabo.ra.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    public void preInit() {
        super.preInit();
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("ra:recycle_furnace", "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(CommonProxy.itemBlockInventoryAdvanced, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

    public void init() {

    }

    public void postInit() {

    }
}
