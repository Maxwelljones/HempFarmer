package com.shruglabs.hempfarmer.item.edibles;

import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class HempFood extends ItemFood {

	public HempFood(String name, int amount, float saturation) {
		super(amount, saturation, false);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		addToItems(this);
	}

	public void addToItems(Item item) {
		HFItems.items.add(item);
	}
}
