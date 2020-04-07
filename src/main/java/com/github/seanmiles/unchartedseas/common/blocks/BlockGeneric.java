package com.github.seanmiles.unchartedseas.common.blocks;

import com.github.seanmiles.unchartedseas.UnchartedSeas;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGeneric extends Block
{
    public Item itemBlock;

    public BlockGeneric(String name, Material mat, float hardness, float resistance, SoundType sound)
    {
        super(mat);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
        this.setCreativeTab(UnchartedSeas.TAB);
        this.setRegistryName(UnchartedSeas.MODID, name);
        this.setTranslationKey(UnchartedSeas.MODID + "." + getRegistryName().getPath());
    }

    public BlockGeneric(String name, Material mat, String toolUsed, int toolStrength, float hardness, float resistance, SoundType sound)
    {
        super(mat);
        this.setHarvestLevel(toolUsed, toolStrength);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
        this.setCreativeTab(UnchartedSeas.TAB);
        this.setRegistryName(UnchartedSeas.MODID, name);
        this.setTranslationKey(UnchartedSeas.MODID + "." + getRegistryName().getPath());
        System.out.println(UnchartedSeas.MODID + "." + getRegistryName().getPath());
    }

    public BlockGeneric(String name, Material mat, float hardness, float resistance, SoundType sound, float light)
    {
        super(mat);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
        this.setCreativeTab(UnchartedSeas.TAB);
        this.setRegistryName(UnchartedSeas.MODID, name);
        this.setTranslationKey(UnchartedSeas.MODID + "." + getRegistryName().getPath());
        this.setLightLevel(light);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return super.getRenderLayer();
    }
}
