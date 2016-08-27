package com.shruglabs.hempfarmer.item.edibles;

import com.shruglabs.hempfarmer.creativetab.HFCreativeTabs;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;

public class HempMilkBucket extends ItemBucketMilk {

	public HempMilkBucket(String name, int maxStack) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		addToItems(this);
		this.setCreativeTab(HFCreativeTabs.FOOD);
	}

	private void addToItems(Item item) {
		HFItems.items.add(item);
	}

}