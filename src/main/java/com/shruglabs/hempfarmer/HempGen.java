package com.shruglabs.hempfarmer;

import java.util.Random;

import com.shruglabs.hempfarmer.block.HFBlockCrops;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class HempGen implements IWorldGenerator {

	private HempGen hemp;
	private HempGen indica;
	private HempGen sativa;
	private HFBlockCrops crop;

	public HempGen() {
		this.hemp = new HempGen((HFBlockCrops) HFBlocks.hemp_crop);
		this.indica = new HempGen((HFBlockCrops) HFBlocks.indica_crop);
		this.sativa = new HempGen((HFBlockCrops) HFBlocks.sativa_crop);
	}

	public HempGen(HFBlockCrops crop) {
		this.crop = crop;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) { 

		switch (world.provider.getDimension()) {
		case 0:
			this.runGenerator(this.hemp, world, random, chunkX, chunkZ, 3);
			this.runGenerator(this.indica, world, random, chunkX, chunkZ, 1);
			this.runGenerator(this.sativa, world, random, chunkX, chunkZ, 1);
			break;
		case -1: // Nether
			break;
		case 1: // End
			break;
		default:
			break;
		}
	}

	private void runGenerator(HempGen gen, World world, Random rand, int chunkX, int chunkZ, int chance) {

		int maxHeight = world.getHeight() + 1;
		int chancesToSpawn = chance;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(maxHeight) + world.getSeaLevel();
			int d = maxHeight - y;
			y = (y <= maxHeight) ? y : y + d;
			int z = chunkZ * 16 + rand.nextInt(16);
			System.out.println("X: " + x + " Y: " + y + " Z: " + z);
			gen.generate(world, rand, new BlockPos(x, y, z));

		}

	}

	private void generate(World world, Random rand, BlockPos pos) {
		for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (world.isAirBlock(blockpos) && (!world.provider.getHasNoSky() || blockpos.getY() < world.getHeight() - 1) && this.crop.canBlockStay(world, blockpos, this.crop.getDefaultState()))
            {
                world.setBlockState(blockpos, this.crop.getDefaultState(), 2);
            }
        }
		
	}

}
