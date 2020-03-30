package com.example.examplemod.common.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    //@GameRegistry.ObjectHolder(ExampleMod.MODID + ":guide")
    //public static Item GUIDE = new ItemGuide();
    @GameRegistry.ObjectHolder(ExampleMod.MODID + ":test_item")
    public static Item TEST_ITEM = new ItemGeneric("test_item");
}
