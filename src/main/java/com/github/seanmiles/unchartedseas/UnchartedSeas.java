package com.github.seanmiles.unchartedseas;

import com.github.seanmiles.unchartedseas.common.CommonProxy;
import com.github.seanmiles.unchartedseas.common.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = UnchartedSeas.MODID, name = UnchartedSeas.NAME, version = UnchartedSeas.VERSION)
public class UnchartedSeas
{
    public static final String MODID = "unchartedseas";
    public static final String NAME = "Uncharted Seas";
    public static final String VERSION = "0.1";
    public static CreativeTabs TAB;

    private static Logger logger;

    @SidedProxy(clientSide = "com.github.seanmiles.unchartedseas.client.ClientProxy", serverSide = "com.github.seanmiles.unchartedseas.common.CommonProxy")
    public static CommonProxy PROXY;

    public static Configuration config;
    public static UnchartedSeasConfig CONFIG_OPTIONS = new UnchartedSeasConfig();

    public static void loadConfig()
    {
        File configFile = new File(Loader.instance().getConfigDir(), MODID + ".cfg");
        if (!configFile.exists())
        {
            try
            {
                configFile.createNewFile();
            }
            catch (Exception e)
            {
                logger.warn("Could not create a new Uncharted Seas config file.");
                logger.warn(e.getLocalizedMessage());
            }
        }
        config = new Configuration(configFile);
        config.load();
    }

    public static void syncConfig()
    {
        CONFIG_OPTIONS.init(config);
        config.save();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        loadConfig();
        syncConfig();
        MinecraftForge.EVENT_BUS.register(PROXY);
        PROXY.preInit();
        logger = event.getModLog();
        TAB = new CreativeTabs(MODID)
        {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(ModItems.TEST_ITEM);
            }
        };
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Initializing");
        PROXY.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        PROXY.postInit();
    }
}
