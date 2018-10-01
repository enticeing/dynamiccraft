package com.chrmills.dynamiccraft.block;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static BlackSand BLACK_SAND = new BlackSand();

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        registry.registerAll(BLACK_SAND);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(new ItemBlock(ModBlocks.BLACK_SAND).setRegistryName(BLACK_SAND.getRegistryName()));
    }

    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BLACK_SAND), 0,
            new ModelResourceLocation(BLACK_SAND.getRegistryName(), "inventory"));
    }
}
