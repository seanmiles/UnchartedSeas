package com.github.seanmiles.unchartedseas.client;

import com.github.seanmiles.unchartedseas.UnchartedSeas;
import com.github.seanmiles.unchartedseas.common.CommonProxy;
import com.github.seanmiles.unchartedseas.common.blocks.ModBlocks;
import com.github.seanmiles.unchartedseas.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy
{
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event)
    {
        // Block Models
        try
        {
            for (Field f : ModBlocks.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Block)
                {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock((Block) obj), 0, new ModelResourceLocation(UnchartedSeas.MODID + ":" + ((Block) obj).getRegistryName().getPath(), "inventory"));
                }
                else if (obj instanceof Block[])
                {
                    for (Block block : (Block[]) obj)
                    {
                        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(UnchartedSeas.MODID + ":" + block.getRegistryName().getPath(), "inventory"));
                    }
                }
            }
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }

        // Item Models
        try
        {
            for (Field f : ModItems.class.getDeclaredFields())
            {
                Object obj = f.get(null);
                if (obj instanceof Item)
                {
                    ModelLoader.setCustomModelResourceLocation((Item) obj, 0, new ModelResourceLocation(UnchartedSeas.MODID + ":" + ((Item) obj).getRegistryName().getPath(), "inventory"));
                }
                else if (obj instanceof Item[])
                {
                    for (Item item : (Item[]) obj)
                    {
                        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(UnchartedSeas.MODID + ":" + item.getRegistryName().getPath(), "inventory"));
                    }
                }
            }
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }
}
