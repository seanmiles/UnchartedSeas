package com.github.seanmiles.unchartedseas.common.item;

import com.github.seanmiles.unchartedseas.UnchartedSeas;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    //@GameRegistry.ObjectHolder(UnchartedSeas.MODID + ":guide")
    //public static Item GUIDE = new ItemGuide();
    @GameRegistry.ObjectHolder(UnchartedSeas.MODID + ":test_item")
    public static Item TEST_ITEM = new ItemGeneric("test_item");
}
