package com.example.examplemod;

import com.example.examplemod.common.CommonProxy;
import com.example.examplemod.common.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

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

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(PROXY);
        PROXY.preInit();
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
