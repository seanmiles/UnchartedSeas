package com.example.examplemod.common.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGeneric extends Item
{
    private int textLength = 0;

    public ItemGeneric(String name)
    {
        super();
        this.setCreativeTab(ExampleMod.TAB);
        this.setRegistryName(ExampleMod.MODID, name);
        this.setTranslationKey(ExampleMod.MODID + "." + getRegistryName().getPath());
    }

    public ItemGeneric(String name, int textLength)
    {
        this(name);
        this.textLength = textLength;
    }

    /*public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (textLength > 0)
        {
            for (int i = 0; i < textLength; i++)
            {
                tooltip.add(I18n.format(this.getTranslationKey() + ".desc" + i));
            }
        }
    }*/
}
