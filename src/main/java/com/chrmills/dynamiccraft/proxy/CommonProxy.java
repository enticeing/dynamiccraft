package com.chrmills.dynamiccraft.proxy;

import com.chrmills.dynamiccraft.ModBlocks;
import com.chrmills.dynamiccraft.biome.overworld.BiomeBlackSandBeach;
import com.chrmills.dynamiccraft.block.BlackSand;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlackSand());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(
            new ItemBlock(ModBlocks.BLACK_SAND).setRegistryName(ModBlocks.BLACK_SAND.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        BiomeBlackSandBeach biomeBlackSandBeach = new BiomeBlackSandBeach();
        IForgeRegistry<Biome> biomeRegistry = event.getRegistry();
        biomeRegistry.register(biomeBlackSandBeach.setRegistryName("BlackSandBeach"));

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
            new BiomeManager.BiomeEntry(biomeBlackSandBeach, 7000000));
        BiomeDictionary.addTypes(biomeBlackSandBeach, BiomeDictionary.Type.BEACH);
    }
}
