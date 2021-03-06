package com.shruglabs.hempfarmer.proxy;

import com.shruglabs.hempfarmer.Config;
import com.shruglabs.hempfarmer.HempFarmer;
import com.shruglabs.hempfarmer.HempGen;
import com.shruglabs.hempfarmer.block.HFBlockCrops;
import com.shruglabs.hempfarmer.entity.EntityShotLeaf;
import com.shruglabs.hempfarmer.init.HFBlocks;
import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.init.HFOreDictionary;
import com.shruglabs.hempfarmer.init.HFRecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent) {
		MinecraftForge.EVENT_BUS.register(HempFarmer.instance);

			Config.config(preEvent);

		register(preEvent);

	}

	public void init(FMLInitializationEvent event) {
		HFOreDictionary.init(event);
		registerRender(event);
		GameRegistry.registerWorldGenerator(new HempGen(), 2);
	}

	public void register(FMLPreInitializationEvent preEvent) {
		HFBlocks.register(preEvent);
		HFItems.register(preEvent);
		registerEntities(preEvent);
		HFRecipes.registerRecipes(preEvent);
	}

	public void registerRender(FMLInitializationEvent event) {
	}

	public void registerEntities(FMLPreInitializationEvent preEvent) {
		int id = 0;
		EntityRegistry.registerModEntity(EntityShotLeaf.class, "shotLeaf", id++, HempFarmer.instance, 64, 2, true);
	}

}
