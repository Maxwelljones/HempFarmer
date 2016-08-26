package com.shruglabs.hempfarmer;

import com.shruglabs.hempfarmer.init.HFItems;
import com.shruglabs.hempfarmer.proxy.CommonProxy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

@Mod(updateJSON = Reference.UPDATE, modid = Reference.ID, name = Reference.NAME, version = Reference.VER, acceptedMinecraftVersions = "1.9.4,)", dependencies = Reference.DEPENDENCIES)
public class HempFarmer {

	public static Configuration config;
	@Instance(value = "hempfarmer")
	public static HempFarmer instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	private static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		proxy.preInit(preEvent);
	}

	@EventHandler
	private void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onItemCraft(ItemCraftedEvent event) {
		Item item = event.crafting.getItem();
		if (item == HFItems.seeds_hemp_crushed || item == HFItems.seeds_indica_crushed
				|| item == HFItems.seeds_sativa_crushed) {
			for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
				if (event.craftMatrix.getStackInSlot(i) != null) {
					ItemStack stack = event.craftMatrix.getStackInSlot(i);
					if (stack.getItem() instanceof ItemShears) {
						--stack.stackSize;
						event.craftMatrix.setInventorySlotContents(i, stack);
					}
				}
			}
		}
	}
}
