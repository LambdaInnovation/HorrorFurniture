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
import cn.liutils.api.client.render.RenderTileEntityModel;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.core.client.register.LIKeyProcess;
import cn.otfurniture.block.*;
import cn.otfurniture.client.key.KeyInvestigate;
import cn.otfurniture.client.model.MdlCandleHolderL;
import cn.otfurniture.client.model.MdlCandleHolderS;
import cn.otfurniture.client.model.MdlWine;
import cn.otfurniture.client.model.ModelChandelierBig;
import cn.otfurniture.client.model.ModelChandelierSmall;
import cn.otfurniture.client.renderer.*;
import cn.otfurniture.event.OTEventListener;
import cn.otfurniture.event.OTTickEventListener;
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
		//----------Wireframe calcellation-------------
		//Feature disabled for creator edition
		/*
		OTEventListener.addHighlightIgnoring(BlockBathtub.class);
		OTEventListener.addHighlightIgnoring(BlockCabinet.class);
		OTEventListener.addHighlightIgnoring(BlockCandleHolderLarge.class);
		OTEventListener.addHighlightIgnoring(BlockCandleHolderSmall.class);
		OTEventListener.addHighlightIgnoring(BlockChair.class);
		OTEventListener.addHighlightIgnoring(BlockClock.class);
		OTEventListener.addHighlightIgnoring(BlockDesk.class);
		OTEventListener.addHighlightIgnoring(BlockFileShelf.class);
		OTEventListener.addHighlightIgnoring(BlockHanger.class);
		OTEventListener.addHighlightIgnoring(BlockKitchenShelf.class);
		OTEventListener.addHighlightIgnoring(BlockKitchenShelfSmall.class);
		OTEventListener.addHighlightIgnoring(BlockKitchenSink.class);
		OTEventListener.addHighlightIgnoring(BlockLamp.class);
		OTEventListener.addHighlightIgnoring(BlockLampLarge.class);
		OTEventListener.addHighlightIgnoring(BlockOilLamp.class);
		OTEventListener.addHighlightIgnoring(BlockPiano.class);
		OTEventListener.addHighlightIgnoring(BlockShelf.class);
		OTEventListener.addHighlightIgnoring(BlockSink.class);
		OTEventListener.addHighlightIgnoring(BlockSmallChair.class);
		OTEventListener.addHighlightIgnoring(BlockSofaSmall.class);
		OTEventListener.addHighlightIgnoring(BlockSofaMedium.class);
		OTEventListener.addHighlightIgnoring(BlockSofaLarge.class);
		OTEventListener.addHighlightIgnoring(BlockTShelf.class);
		OTEventListener.addHighlightIgnoring(BlockTV.class);
		OTEventListener.addHighlightIgnoring(BlockTVShelf.class);
		OTEventListener.addHighlightIgnoring(BlockWine.class);
		OTEventListener.addHighlightIgnoring(BlockWritingDesk.class);
		OTEventListener.addHighlightIgnoring(BlockBed.class);
		*/
		//-----------------------------------
		
		
		ClientRegistry.bindTileEntitySpecialRenderer(BlockShelf.Tile.class, new RendererShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBathtub.Tile.class, new RendererBathtub());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTV.Tile.class, new RendererTV());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSink.Tile.class, new RendererSink());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLamp.Tile.class, new RendererLamp());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockLampLarge.Tile.class, new RendererLampLarge());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockChair.Tile.class, new RendererChair());
		//这个在debug状态注册会出现迷之错误，所以暂时敲掉
		ClientRegistry.bindTileEntitySpecialRenderer(BlockClock.Tile.class, new RendererClock());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelf.Tile.class, new RendererKitchenShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenShelfSmall.Tile.class, new RendererKSShelf());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockPiano.Tile.class, new RendererPiano());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCandleHolderSmall.Tile.class, 
				new RenderTileEntityModel(new MdlCandleHolderS(), OFClientProps.TEX_CANDLE_HOLDER).setYOffset(1.5));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCandleHolderLarge.Tile.class, 
			new RenderTileModelSided(new MdlCandleHolderL())
			.setTechne(true).setModelTexture(OFClientProps.TEX_CANDLE_HOLDER).setOffset(0.0, 1.5, 0.0));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockWine.Tile.class, 
				new RenderTileEntityModel(new MdlWine(), OFClientProps.TEX_WINE).setYOffset(1.5));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSmallChair.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_SCHAIR)).setScale(0.14F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockDesk.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_DESK)).setScale(0.04F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCabinet.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_CABINET)).setScale(0.03F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaSmall.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_SOFA[0])).setScale(0.013F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaMedium.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_SOFA[1])).setScale(0.0165F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSofaLarge.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_SOFA[2])).setScale(0.019F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockFileShelf.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_FILE_SHELF))
				.setScale(0.1F).setModelTexture(OFClientProps.TEX_FSHELF));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockWritingDesk.Tile.class, 
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_WDESK)).setScale(0.12F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockKitchenSink.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_KSINK)).setScale(0.098F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTShelf.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_TSHELF)).setScale(0.07F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockHanger.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_HANGER)).setScale(0.1F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockOilLamp.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_OILLAMP)).setScale(0.1F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockTVShelf.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_TVSHELF)).setScale(0.07F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockBed.Tile.class,
				new RenderTileModelSided(new TileEntityModelCustom(OFClientProps.MDL_BED)).setScale(0.095F));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockMirror.Tile.class, new RendererMirror());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockSmallCurtain.Tile.class, new RendererSmallCurtain());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCurtain2.Tile.class, new RendererCurtain2());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockCurtain4.Tile.class, new RendererCurtain4());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockPianoRecorded.Tile.class, new RendererPiano());
		ClientRegistry.bindTileEntitySpecialRenderer(BlockChandelierSmall.Tile.class,
				new RenderTileModelSided(new ModelChandelierSmall()).setTechne(true)
				.setModelTexture(OFClientProps.TEX_CHANDELIER).setOffset(0D, 1.5D, 0D));
		ClientRegistry.bindTileEntitySpecialRenderer(BlockChandelierLarge.Tile.class,
				new RendererChandelierLarge());
		super.init();
	}

}
