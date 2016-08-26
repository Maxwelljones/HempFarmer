package com.shruglabs.hempfarmer.creativetab;

import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DrugsTab extends HFCreativeTabs {

	public DrugsTab(int index, String label) {
		super(index, label);
	}

	public static final DrugsTab HFDrugs = new DrugsTab(CreativeTabs.getNextID(), "hfdrugs") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return HFItems.regs_joint;
		}
	};

}
