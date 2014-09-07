/**
 * Copyright (C) Lambda-Innovation, 2013-2014
 * This code is open-source. Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 */
package cn.horniture;

import org.apache.logging.log4j.Logger;

import cn.horniture.entity.EntitySittable;
import cn.horniture.proxy.Proxy;
import cn.horniture.register.HFBlocks;
import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * @author WeAthFolD
 *
 */
@Mod(modid = "horniture", name = "Horror Furniture", version = HorrorFurniture.VERSION)
public class HorrorFurniture {
	
	public static final String VERSION = "0.0.1";

	@Instance("horniture")
	public static HorrorFurniture INSTANCE;
	
	@SidedProxy(
		serverSide = "cn.horniture.proxy.Proxy",
		clientSide = "cn.horniture.proxy.ClientProxy")
	private static Proxy proxy;
	
	
	public static CreativeTabs cct;
	
	public static Logger log = FMLLog.getLogger();
	
	@EventHandler()
	public void preInit(FMLPreInitializationEvent event) {

		log.info("Starting LIUtils " + VERSION);
		log.info("Copyright (c) Lambda Innovation, 2013");
		log.info("http://www.lambdacraft.cn");
		
		cct = new CreativeTabs("horniture") {

			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(HFBlocks.tv);
			}
			
		};
		
		proxy.preInit();
		HFBlocks.init();
	}
	
	@EventHandler()
	public void init(FMLInitializationEvent Init) {
		proxy.init();
		EntityRegistry.registerModEntity(EntitySittable.class, "sittable", 0, INSTANCE, 16, 16, false);
	}
	
	@EventHandler()
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	@EventHandler()
	public void serverStarting(FMLServerStartingEvent event) {
		CommandHandler cm = (CommandHandler) event.getServer().getCommandManager();
		proxy.commandInit(cm);
	}

}
