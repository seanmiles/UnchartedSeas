package com.example.examplemod.common;

import com.example.examplemod.common.blocks.ModBlocks;
import com.example.examplemod.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class CommonProxy
{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        try
        {
            for (Field f : ModBlocks.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Block)
                {
                    event.getRegistry().register((Block) obj);
                }
                else if (obj instanceof Block[])
                {
                    for (Block block : (Block[]) obj)
                    {
                        event.getRegistry().register(block);
                    }
                }
            }
        } catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        // ItemBlocks
        try
        {
            for (Field f : ModBlocks.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Block)
                {
                    ItemBlock itemBlock;
                    itemBlock = new ItemBlock((Block) obj);
                    itemBlock.setRegistryName(((Block) obj).getRegistryName());
                    event.getRegistry().register(itemBlock);
                }
                else if (obj instanceof Block[])
                {
                    for (Block block : (Block[]) obj)
                    {
                        ItemBlock itemBlock = new ItemBlock(block);
                        itemBlock.setRegistryName(block.getRegistryName());
                        event.getRegistry().register(itemBlock);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // Items
        try {
            for (Field f : ModItems.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Item)
                {
                    event.getRegistry().register((Item) obj);
                } else if (obj instanceof Item[])
                {
                    for (Item item : (Item[]) obj)
                    {
                        event.getRegistry().register(item);
                    }
                }
            }
        } catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }

        //ModRecipes.preInit();
    }

    public void preInit()
    {

    }

    public void init()
    {

    }

    public void postInit()
    {

    }
}
