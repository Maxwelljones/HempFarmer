package com.shruglabs.hempfarmer;

import com.shruglabs.hempfarmer.block.cannibis.Hemp;
import com.shruglabs.hempfarmer.block.cannibis.Indica;
import com.shruglabs.hempfarmer.block.cannibis.Sativa;
import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.item.HFWand;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {

	public static void serverConfig(FMLPreInitializationEvent preEvent) {
		HempFarmer.config = new Configuration(preEvent.getSuggestedConfigurationFile());
		EntityShotLeaf.entity = HempFarmer.config.getBoolean("Wand- Effective on Entities:", "Wand", true, "Wand Effective on non-player entities.");
		EntityShotLeaf.player = HempFarmer.config.getBoolean("Wand- Effective on Players:", "Wand", true, "Wand Effective on player entities.");
		EntityShotLeaf.block = HempFarmer.config.getBoolean("Wand- Effective on Blocks:", "Wand", true, "Wand Effective on blocks.");
		HFWand.leafDamage = HempFarmer.config.getInt("Wand- Leaf Wand Shots:", "Wand", 75, 1, 1000, "Amount of magical shots.");
		HFWand.superiorDamage = HempFarmer.config.getInt("Wand- Superior Leaf Wand Shots:", "Wand", 300, 1, 1000, "Amount of magical shots.");
		Hemp.seedsGrassRate = HempFarmer.config.getInt("Hemp- Seeds drop rate:", "Drops-Grassseeds", 6, 1, 10,
				"Weighted drop rate from grass. Wheat is 10 by default.");
		Hemp.seedsCropAmount = HempFarmer.config.getInt("Hemp- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Hemp Crop.");
		Hemp.hempAmount = HempFarmer.config.getInt("Hemp- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Hemp Crop.");
		Hemp.budAmount = HempFarmer.config.getInt("Hemp- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Hemp Crop.");
		Indica.seedsGrassRate = HempFarmer.config.getInt("Indica- Seeds drop rate:", "Drops-Grassseeds", 4, 1, 10,
				"Weighted drop rate from grass. Wheat is 10 by default.");
		Indica.seedsCropAmount = HempFarmer.config.getInt("Indica- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Indica Crop.");
		Indica.hempAmount = HempFarmer.config.getInt("Indica- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Indica Crop.");
		Indica.budAmount = HempFarmer.config.getInt("Indica- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Indica Crop.");
		Sativa.seedsGrassRate = HempFarmer.config.getInt("Sativa- Seeds drop rate:", "Drops-Grassseeds", 4, 1, 10,
				"Weighted drop rate from grass. Wheat is 10 by default");
		Sativa.seedsCropAmount = HempFarmer.config.getInt("Sativa- Seeds drop amount:", "Drops-Seeds", 1, 1, 5,
				"Amount of seeds to drop from Sativa Crop.");
		Sativa.hempAmount = HempFarmer.config.getInt("Sativa- Hemp drop amount:", "Drops-Hemp", 1, 1, 5,
				"Amount of hemp to drop from Sativa Crop.");
		Sativa.budAmount = HempFarmer.config.getInt("Sativa- Bud drop amount:", "Drops-Buds", 1, 0, 5,
				"Amount of buds to drop from Sativa Crop.");
		HempFarmer.config.save();
		Config.save();

	}

	private static void save() {
		if (HempFarmer.config.hasChanged()) {
			HempFarmer.config.save();
		}

	}

}
