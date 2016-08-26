package com.shruglabs.hempfarmer.creativetab;

import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HFCreativeTabs extends CreativeTabs {

	public HFCreativeTabs(int index, String label) {
		super(index, label);
	}

	public static final HFCreativeTabs HFCombat = new HFCreativeTabs(CreativeTabs.getNextID(), "hfcombat") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return HFItems.resin_sword;
		}
	};
	public static final HFCreativeTabs HFCrops = new HFCreativeTabs(CreativeTabs.getNextID(), "hfcrops") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return HFItems.leaf;
		}
	};

	public static final HFCreativeTabs HFMaterials = new HFCreativeTabs(CreativeTabs.getNextID(), "hfmaterials") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(HFBlocks.burlap);
		}
	};

	@Override
	public Item getTabIconItem() {
		return null;
	}

}
