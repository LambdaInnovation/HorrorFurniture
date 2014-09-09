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
package cn.otfurniture.proxy;

import org.lwjgl.input.Keyboard;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.core.client.register.LIKeyProcess;
import cn.otfurniture.block.*;
import cn.otfurniture.client.key.KeyInvestigate;
import cn.otfurniture.client.render.*;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * @author WeAthFolD
 *
 */
public class ClientProxy extends Proxy {

	/**
	 * 
	 */
	public ClientProxy() {
		
	}
	
	@Override
	public void preInit() {
		LIKeyProcess.addKey("investigate", Keyboard.KEY_R, false, new KeyInvestigate());
		super.preInit();
	}
	
	/* (non-Javadoc)
	 * @see cn.horniture.proxy.Proxy#init()
	 */
	@Override
	public void init() {
		ClientRegistry.bindTileEntitySpecialRenderer(BlockShelf.Tile.class, new RenderShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBathtub.Tile.class, new RenderBathtub());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTV.Tile.class, new RenderTV());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSink.Tile.class, new RenderSink());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLamp.Tile.class, new RenderLamp());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLampLarge.Tile.class, new RenderLampLarge());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockChair.Tile.class, new RenderChair());
		//这个在debug状态注册会出现迷之错误，所以暂时敲掉
		//ClientRegistry.bindTileEntitySpecialRenderer(BlockClock.Tile.class, new RenderClock());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelf.Tile.class, new RenderKitchenShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelfSmall.Tile.class, new RenderKSShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockPiano.Tile.class, new RenderPiano());
		
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSmallChair.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SCHAIR)).setScale(0.14F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockDesk.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_DESK)).setScale(0.04F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCabinet.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_CABINET)).setScale(0.03F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaSmall.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[0])).setScale(0.01F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaMedium.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[1])).setScale(0.0165F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaLarge.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[2])).setScale(0.019F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockFileShelf.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_FILE_SHELF))
				.setScale(0.1F).setModelTexture(HFClientProps.TEX_FSHELF));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockWritingDesk.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_WDESK)).setScale(0.12F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenSink.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_KSINK)).setScale(0.098F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTShelf.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_TSHELF)).setScale(0.07F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockHanger.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_HANGER)).setScale(0.1F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockOilLamp.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_OILLAMP)).setScale(0.1F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTVShelf.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_TVSHELF)).setScale(0.07F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBed.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_BED)).setScale(0.095F));
		
		super.init();
	}

}
