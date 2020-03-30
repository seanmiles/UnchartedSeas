package com.example.examplemod.common.blocks;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    @GameRegistry.ObjectHolder(ExampleMod.MODID + ":test_block")
    public static Block TEST_BLOCK = new BlockGeneric("test_block", Material.IRON, "pickaxe", 2, 3.0F, 10.0F, SoundType.METAL);
}
