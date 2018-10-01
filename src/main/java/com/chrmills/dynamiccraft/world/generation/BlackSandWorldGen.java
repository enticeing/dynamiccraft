package com.chrmills.dynamiccraft.world.generation;

import com.chrmills.dynamiccraft.block.ModBlocks;
import com.chrmills.dynamiccraft.world.generation.util.WorldGenUtil;

import java.util.Random;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

@ParametersAreNonnullByDefault
public class BlackSandWorldGen implements IWorldGenerator {
    private static String BEACH_BIOME_NAME = "Beach";

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {
        BlockPos currentBlock = new BlockPos(chunkX*16+8 , 200, chunkZ*16+8);

        if (random.nextInt(100) > 1 && isBeachBiome(world, currentBlock)) {
            currentBlock = WorldGenUtil.getSurfaceFromSky(world, currentBlock);

            if (isBlockSand(world, currentBlock)) {
                replaceSandAreaWithBlackSand(world, currentBlock);
            }
        }
    }

    private void replaceSandAreaWithBlackSand(World world, BlockPos pos) {
        if (canReplaceWithBlackSand(world, pos)) {
            changeBlockToBlackSand(world, pos);

            replaceSandAreaWithBlackSand(world, pos.north());
            replaceSandAreaWithBlackSand(world, pos.east());
            replaceSandAreaWithBlackSand(world, pos.south());
            replaceSandAreaWithBlackSand(world, pos.west());
            replaceSandAreaWithBlackSand(world, pos.north().up());
            replaceSandAreaWithBlackSand(world, pos.east().up());
            replaceSandAreaWithBlackSand(world, pos.south().up());
            replaceSandAreaWithBlackSand(world, pos.west().up());
            replaceSandAreaWithBlackSand(world, pos.north().down());
            replaceSandAreaWithBlackSand(world, pos.east().down());
            replaceSandAreaWithBlackSand(world, pos.south().down());
            replaceSandAreaWithBlackSand(world, pos.west().down());
            replaceSandAreaWithBlackSand(world, pos.down());
            replaceSandAreaWithBlackSand(world, pos.up());
        }
    }

    private boolean isBlockSand(World world, BlockPos pos) {
        IBlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof BlockSand
                && blockState.getValue(BlockSand.VARIANT).equals(BlockSand.EnumType.SAND)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBlockExposed(World world, BlockPos pos) {
        return (world.isAirBlock(pos.north()) ||
                world.isAirBlock(pos.east())  ||
                world.isAirBlock(pos.south()) ||
                world.isAirBlock(pos.west())  ||
                world.isAirBlock(pos.up())    ||
                world.isAirBlock(pos.down()));
    }

    private boolean canReplaceWithBlackSand(World world, BlockPos pos) {
        if (!isBeachBiome(world, pos)) {
            return false;
        }

        BlockPos localBlockPos = pos;
        if (isBlockExposed(world, pos)) {
            return isBlockSand(world, pos);
        }

        return false;
    }

    private void changeBlockToBlackSand(World world, BlockPos pos) {
        world.setBlockState(pos, ModBlocks.BLACK_SAND.getDefaultState());
    }

    private boolean isBeachBiome(World world, BlockPos pos) {
        return world.getBiome(pos).getBiomeName().equals(BEACH_BIOME_NAME);
    }
}
