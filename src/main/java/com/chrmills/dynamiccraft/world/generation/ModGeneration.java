package com.chrmills.dynamiccraft.world.generation;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModGeneration {
    private static final BlackSandWorldGen BLACK_SAND_WORLD_GEN = new BlackSandWorldGen();
    private static final int BLACK_SAND_WORLD_GEN_WEIGHT = 10000;

    public static void registerWorldGen() {
        GameRegistry.registerWorldGenerator(BLACK_SAND_WORLD_GEN, BLACK_SAND_WORLD_GEN_WEIGHT);
    }
}
