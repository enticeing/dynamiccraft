package com.chrmills.dynamiccraft.block;

import com.chrmills.dynamiccraft.DynamicCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlackSand extends Block {
    public BlackSand() {
        super(Material.SAND);
        setUnlocalizedName(DynamicCraft.MOD_ID + ".black_sand");
        setRegistryName("black_sand");
    }
}
