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
package cn.horniture.proxy;

import cn.horniture.block.*;
import cn.horniture.client.render.*;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
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
	
	/* (non-Javadoc)
	 * @see cn.horniture.proxy.Proxy#init()
	 */
	@Override
	public void init() {
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCabinet.Tile.class, new RenderCabinet());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockShelf.Tile.class, new RenderShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBathtub.Tile.class, new RenderBathtub());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTV.Tile.class, new RenderTV());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSink.Tile.class, new RenderSink());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLamp.Tile.class, new RenderLamp());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockDesk.Tile.class, new RenderDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLampLarge.Tile.class, new RenderLampLarge());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockChair.Tile.class, new RenderChair());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockFileShelf.Tile.class, new RenderFileShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockWritingDesk.Tile.class, new RenderWritingDesk());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenSink.Tile.class, new RenderKitchenSink());
		//ClientRegistry.bindTileEntitySpecialRenderer(BlockClock.Tile.class, new RenderClock());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelf.Tile.class, new RenderKitchenShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTShelf.Tile.class, new RenderTShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelfSmall.Tile.class, new RenderKSShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSmallChair.Tile.class, new RenderSmallChair());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBed.Tile.class, new RenderBed());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTVShelf.Tile.class, new RenderTVShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockOilLamp.Tile.class, new RenderOilLamp());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockHanger.Tile.class, new RenderHanger());
		
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaSmall.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[0])).setScale(0.01F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaMedium.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[1])).setScale(0.0165F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaLarge.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(HFClientProps.MDL_SOFA[2])).setScale(0.019F));
	}

}
