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
package cn.otfurniture;

import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cn.otfurniture.entity.EntitySittable;
import cn.otfurniture.event.OTEventListener;
import cn.otfurniture.event.OTTickEventListener;
import cn.otfurniture.network.MsgInvsContentUpdate;
import cn.otfurniture.network.MsgInvsOpenGui;
import cn.otfurniture.network.MsgInvsStateUpdate;
import cn.otfurniture.proxy.Proxy;
import cn.otfurniture.register.OFBlocks;
import cn.otfurniture.register.OFItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * Mod主类
 * @author WeAthFolD
 */
@Mod(modid = "otfurniture", name = "The Old Town Furniture", version = OldTownFurniture.VERSION)
public class OldTownFurniture {
	
	/**
	 * 公共版本号
	 */
	public static final String VERSION = "0.0.1";

	/**
	 * 静态单例
	 */
	@Instance("otfurniture")
	public static OldTownFurniture INSTANCE;
	
	/**
	 * 加载代理
	 */
	@SidedProxy(
		serverSide = "cn.otfurniture.proxy.Psroxy",
		clientSide = "cn.otfurniture.proxy.ClientProxy")
	private static Proxy proxy;
	
	/**
	 * 创造栏
	 */
	public static CreativeTabs cct;
	
	/**
	 * 日志文件
	 */
	public static Logger log = FMLLog.getLogger();
	
	/**
	 * 网络channel handler。
	 */
	public static SimpleNetworkWrapper netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("otfurniture");
	
	@EventHandler()
	public void preInit(FMLPreInitializationEvent event) {

		log.info("Starting LIUtils " + VERSION);
		log.info("Copyright (c) Lambda Innovation & The Ancient Stone, 2013-2014");
		log.info("http://www.lambdacraft.cn");
		
		cct = new CreativeTabs("otfurniture") {

			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(OFBlocks.tv[1]);
			}
			
		};
		
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new OFGuiHandler());
		
		//events
		MinecraftForge.EVENT_BUS.register(new OTEventListener());
		FMLCommonHandler.instance().bus().register(new OTTickEventListener());
		
		//Network
		netHandler.registerMessage(MsgInvsStateUpdate.Handler.class, MsgInvsStateUpdate.class, 0, Side.CLIENT);
		netHandler.registerMessage(MsgInvsOpenGui.Handler.class, MsgInvsOpenGui.class, 1, Side.CLIENT);
		netHandler.registerMessage(MsgInvsOpenGui.Request.Handler.class, MsgInvsOpenGui.Request.class, 2, Side.SERVER);
		netHandler.registerMessage(MsgInvsContentUpdate.Handler.class, MsgInvsContentUpdate.class, 3, Side.SERVER);
		
		//Blocks and Items
		OFBlocks.init();
		OFItems.init();
		
		proxy.preInit();
	}
	
	@EventHandler()
	public void init(FMLInitializationEvent Init) {
		//Entities
		EntityRegistry.registerModEntity(EntitySittable.class, "sittable", 0, INSTANCE, 16, 16, false);
		
		proxy.init();
	}
	
	@EventHandler()
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
	@EventHandler()
	public void serverStarting(FMLServerStartingEvent event) {
		CommandHandler cm = (CommandHandler) event.getServer().getCommandManager();
		//Commands
		proxy.commandInit(cm);
	}

}
