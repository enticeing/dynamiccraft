package com.chrmills.dynamiccraft.block;

import com.chrmills.dynamiccraft.DynamicCraft;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlackSand extends BlockFalling {

    public BlackSand() {
        super(Material.SAND);
        setUnlocalizedName(DynamicCraft.MOD_ID + ".black_sand");
        setRegistryName("black_sand");
        setCreativeTab(CreativeTabs.COMBAT);
    }
}
