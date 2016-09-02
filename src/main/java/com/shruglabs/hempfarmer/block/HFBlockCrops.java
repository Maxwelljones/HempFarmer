package com.shruglabs.hempfarmer.block;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HFBlockCrops extends BlockCrops {
	public static int seedsGrassRate;
	public static int seedsCropAmount;
	public static int hempAmount;
	public static int budAmount;
	public static Item crop;
	public static String cropName;

	public HFBlockCrops(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setDefaultState(this.withAge(7));
		this.setCreativeTab(HFCreativeTabs.HFCrops);
		addToBlocks(this);

	}

	private void addToBlocks(BlockCrops block) {
		HFBlocks.blocks.add(block);
	}

	

}
