package com.shruglabs.hempfarmer.item;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class HFItem extends Item {

	public HFItem(String name, int maxStack) {
		this.setMaxStackSize(maxStack);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(HFCreativeTabs.HFMisc);
		addToItems(this);
	}
	


	private void addToItems(Item item) {
		HFItems.items.add(item);
	}

}