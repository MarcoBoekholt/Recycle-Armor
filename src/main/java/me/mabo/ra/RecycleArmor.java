package me.mabo.ra;

import me.mabo.ra.init.RecipesInit;
import me.mabo.ra.proxy.CommonProxy;
import me.mabo.ra.util.Reference;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.logging.Logger;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, updateJSON = Reference.UPDATE_URL)
public class RecycleArmor {

    @Mod.Instance
    public static RecycleArmor instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    public static Logger logger;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent e) {
        proxy.preInit();
        logger = Logger.getLogger(Reference.MOD_ID);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        proxy.init();
        RecipesInit.removeRecipes(new ItemStack(Items.IRON_NUGGET), Reference.MOD_ID);
        RecipesInit.removeRecipes(new ItemStack(Items.GOLD_NUGGET), Reference.MOD_ID);
        RecipesInit.init();
        logger.info("Init intialized");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent e) {
        proxy.postInit();
    }


}
