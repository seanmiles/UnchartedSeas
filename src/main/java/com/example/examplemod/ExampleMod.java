package com.example.examplemod;

import com.example.examplemod.common.CommonProxy;
import com.example.examplemod.common.item.ModItems;
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

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "1.0";
    public static CreativeTabs TAB;

    private static Logger logger;

    @SidedProxy(clientSide = "com.example.examplemod.client.ClientProxy", serverSide = "com.example.examplemod.common.CommonProxy")
    public static CommonProxy PROXY;

    public static Configuration config;
    public static ExampleModConfig CONFIG_OPTIONS = new ExampleModConfig();

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
                logger.warn("Could not create a new Example Mod config file.");
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
