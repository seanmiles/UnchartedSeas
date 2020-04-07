package com.github.seanmiles.unchartedseas.common.item;

import com.github.seanmiles.unchartedseas.UnchartedSeas;
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
        this.setCreativeTab(UnchartedSeas.TAB);
        this.setRegistryName(UnchartedSeas.MODID, name);
        this.setTranslationKey(UnchartedSeas.MODID + "." + getRegistryName().getPath());
    }

    public ItemGeneric(String name, int textLength)
    {
        this(name);
        this.textLength = textLength;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (textLength > 0)
        {
            for (int i = 0; i < textLength; i++)
            {
                tooltip.add(I18n.format(this.getTranslationKey() + ".desc" + i));
            }
        }
    }
}
