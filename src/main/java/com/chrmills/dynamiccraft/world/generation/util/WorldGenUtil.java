package com.chrmills.dynamiccraft.world.generation.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenUtil {
    public static BlockPos getSurfaceFromSky(World world, BlockPos skyPos) {
        BlockPos surfacePos = new BlockPos(skyPos);
        while (world.isAirBlock(surfacePos)) {
            surfacePos = surfacePos.down();
        }

        return surfacePos;
    }
}
