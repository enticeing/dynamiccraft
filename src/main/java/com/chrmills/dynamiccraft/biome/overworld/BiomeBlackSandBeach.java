package com.chrmills.dynamiccraft.biome.overworld;

import com.chrmills.dynamiccraft.ModBlocks;

import net.minecraft.world.biome.Biome;

public class BiomeBlackSandBeach extends Biome {
    public BiomeBlackSandBeach() {
        super(new BiomeProperties("BlackSandBeach")
            .setBaseHeight(0.0F)
            .setHeightVariation(0.025F)
            .setTemperature(0.8F)
            .setRainfall(0.4F));
        this.spawnableCreatureList.clear();
        this.topBlock = ModBlocks.BLACK_SAND.getDefaultState();
        this.fillerBlock = ModBlocks.BLACK_SAND.getDefaultState();
        this.decorator.treesPerChunk = -999;
        this.decorator.deadBushPerChunk = 0;
        this.decorator.reedsPerChunk = 0;
        this.decorator.cactiPerChunk = 0;
    }
}
