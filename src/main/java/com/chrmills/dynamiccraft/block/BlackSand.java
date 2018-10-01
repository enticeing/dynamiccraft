package com.chrmills.dynamiccraft.block;

import com.chrmills.dynamiccraft.DynamicCraft;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlackSand extends BlockFalling {
    public BlackSand() {
        super(Material.SAND);
        this.setUnlocalizedName(DynamicCraft.MOD_ID + ".black_sand");
        this.setRegistryName("black_sand");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }
}
