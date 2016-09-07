package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.block.HFBlockDirt;
import com.shruglabs.hempfarmer.init.HFBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HFOil extends HFItem{

	public static int oilMaxStack;


	public HFOil(String name) {
		super(name, oilMaxStack);
	}
	
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!player.canPlayerEdit(pos, facing, stack)){
			return EnumActionResult.FAIL;
		}
		else {
			Block block = world.getBlockState(pos).getBlock();
			if (block == Blocks.DIRT || block == Blocks.GRASS){
				String oil = stack.getItem().getRegistryName().toString();
				oil = oil.substring(11, oil.length() - 4);
				int oilType = oil.equals("hemp") ? 0 : 1;
				if (oil.equals("violet")){
					oilType++;
				}	
				IBlockState state;
				HFBlockDirt blockOut;
				switch (oilType){
				case 1: blockOut = (HFBlockDirt)HFBlocks.lime_dirt;
						blockOut.fromOil = true;
						state = blockOut.getDefaultState();
						break;
				case 2:	 blockOut = (HFBlockDirt)HFBlocks.violet_dirt;
						blockOut.fromOil = true;
						state = blockOut.getDefaultState();
						break;
				default: blockOut = (HFBlockDirt)HFBlocks.oily_dirt;
						blockOut.fromOil = true;
						state = blockOut.getDefaultState();
						break;
				}	
				if (state != null){ 
					world.destroyBlock(pos, false);
					world.setBlockState(pos, state, 11);
					if (stack.stackSize > 0){
						--stack.stackSize;
					}
				}
			}
			return EnumActionResult.SUCCESS;
		}
	}
	
}
