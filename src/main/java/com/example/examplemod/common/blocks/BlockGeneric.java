package com.example.examplemod.common.blocks;

import com.example.examplemod.ExampleMod;
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
        this.setCreativeTab(ExampleMod.TAB);
        this.setRegistryName(ExampleMod.MODID, name);
        this.setTranslationKey(ExampleMod.MODID + "." + getRegistryName().getPath());
    }

    public BlockGeneric(String name, Material mat, String toolUsed, int toolStrength, float hardness, float resistance, SoundType sound)
    {
        super(mat);
        this.setHarvestLevel(toolUsed, toolStrength);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
        this.setCreativeTab(ExampleMod.TAB);
        this.setRegistryName(ExampleMod.MODID, name);
        this.setTranslationKey(ExampleMod.MODID + "." + getRegistryName().getPath());
        System.out.println(ExampleMod.MODID + "." + getRegistryName().getPath());
    }

    public BlockGeneric(String name, Material mat, float hardness, float resistance, SoundType sound, float light)
    {
        super(mat);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setSoundType(sound);
        this.setCreativeTab(ExampleMod.TAB);
        this.setRegistryName(ExampleMod.MODID, name);
        this.setTranslationKey(ExampleMod.MODID + "." + getRegistryName().getPath());
        this.setLightLevel(light);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return super.getRenderLayer();
    }
}
