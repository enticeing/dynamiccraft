package com.chrmills.dynamiccraft.biome;

import com.chrmills.dynamiccraft.biome.overworld.BlackSandBeach;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {
    public static BlackSandBeach BLACK_SAND_BEACH = new BlackSandBeach();

    static {
        BLACK_SAND_BEACH.setRegistryName("BlackSandBeach");
    }

    public static void register(IForgeRegistry<Biome> biomeRegistry) {
        biomeRegistry.register(BLACK_SAND_BEACH);

        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
            new BiomeManager.BiomeEntry(BLACK_SAND_BEACH, 7000000));
        BiomeDictionary.addTypes(BLACK_SAND_BEACH, BiomeDictionary.Type.BEACH);

    }
}
