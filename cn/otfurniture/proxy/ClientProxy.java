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

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.input.Keyboard;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileEntityModel;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.liutils.core.client.register.LIKeyProcess;
import cn.otfurniture.block.*;
import cn.otfurniture.client.key.KeyInvestigate;
import cn.otfurniture.client.model.MdlCandleHolderL;
import cn.otfurniture.client.model.MdlCandleHolderS;
import cn.otfurniture.client.model.MdlWine;
import cn.otfurniture.client.model.ModelChandelierSmall;
import cn.otfurniture.client.renderer.*;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * @author WeAthFolD
 *
 */
public class ClientProxy extends Proxy {

	public ClientProxy() {
		
	}
	
	@Override
	public void preInit() {
		LIKeyProcess.addKey("investigate", Keyboard.KEY_R, false, new KeyInvestigate());
		super.preInit();
	}
	
	@Override
	public void init() {
		//----------Wireframe calcellation-------------
		//Feature disabled for creator edition
		/*
		OTEventListener.addHighlightIgnoring(BlockBathtub.class);
		OTEventListener.addHighlightIgnoring(BlockCabinet.class);
		OTEventListener.addHighlightIgnoring(BlockHolderLarge.class);
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
		
		
		bind(BlockShelf.Tile.class, new RendererShelf());
		bind(BlockBathtub.Tile.class, new RendererBathtub());
		bind(BlockTV.Tile.class, new RendererTV());
		bind(BlockSink.Tile.class, new RendererSink());
		bind(BlockLamp.Tile.class, new RendererLamp());
		bind(BlockLampLarge.Tile.class, new RendererLampLarge());
		bind(BlockChair.Tile.class, new RendererChair());
		bind(BlockClock.Tile.class, new RendererClock());
		bind(BlockKitchenShelf.Tile.class, new RendererKitchenShelf());
		bind(BlockKitchenShelfSmall.Tile.class, new RendererKSShelf());
		bind(BlockPiano.Tile.class, new RendererPiano());
		bind(BlockCandleHolderSmall.Tile.class, new RenderTileEntityModel(new MdlCandleHolderS(), OFClientProps.TEX_CANDLE_HOLDER)
			.setYOffset(1.5));
		bind(BlockCandleHolderLarge.Tile.class, new RenderDirMultiModelled(new MdlCandleHolderL())
			.setTechne(true)
			.setModelTexture(OFClientProps.TEX_CANDLE_HOLDER)
			.setOffset(0.0, 1.5, 0.0));
		bind(BlockWine.Tile.class, new RenderTileEntityModel(new MdlWine(), OFClientProps.TEX_WINE)
			.setReverse(true)
			.setYOffset(1.5F));
		bind(BlockSmallChair.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_SCHAIR))
			.setScale(0.14F));
		bind(BlockDesk.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_DESK))
			.setScale(0.04F));
		bind(BlockCabinet.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_CABINET))
			.setScale(0.03F));
		bind(BlockSofaSmall.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_SOFA[0]))
			.setScale(0.013F));
		bind(BlockSofaMedium.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_SOFA[1]))
			.setScale(0.0165F));
		bind(BlockSofaLarge.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_SOFA[2]))
			.setScale(0.019F));
		bind(BlockFileShelf.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_FILE_SHELF))
			.setScale(0.1F)
			.setModelTexture(OFClientProps.TEX_FSHELF));
		bind(BlockWritingDesk.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_WDESK))
			.setScale(0.12F));
		bind(BlockKitchenSink.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_KSINK))
			.setScale(0.098F));
		bind(BlockTShelf.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_TSHELF))
			.setScale(0.07F));
		bind(BlockHanger.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_HANGER))
			.setScale(0.1F));
		bind(BlockOilLamp.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_OILLAMP))
			.setScale(0.1F));
		bind(BlockTVShelf.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_TVSHELF))
			.setScale(0.07F));
		bind(BlockBed.Tile.class, new RenderDirMultiModelled(new TileEntityModelCustom(OFClientProps.MDL_BED))
			.setScale(0.095F));
		bind(BlockDeadRabbit.Tile.class, new RendererDeadRabbit());
		bind(BlockMirror.Tile.class, new RendererMirror());
		bind(BlockSmallCurtain.Tile.class, new RendererSmallCurtain());
		bind(BlockCurtain2.Tile.class, new RendererCurtain2());
		bind(BlockCurtain4.Tile.class, new RendererCurtain4());
		bind(BlockPianoRecorded.Tile.class, new RendererPiano());
		bind(BlockChandelierSmall.Tile.class, new RenderDirMultiModelled(new ModelChandelierSmall())
			.setTechne(true)
			.setModelTexture(OFClientProps.TEX_CHANDELIER)
			.setOffset(0D, 1.5D, 0D));
		bind(BlockChandelierLarge.Tile.class, new RendererChandelierLarge());
		bind(BlockCar.Tile.class, new RendererCar());
		bind(BlockChaos.Tile.class, new RendererSmallCurtain().setModelTexture(OFClientProps.TEX_CHAOS));
		super.init();
	}
	
	private static void bind(Class<? extends TileEntity> c, TileEntitySpecialRenderer r) {
		ClientRegistry.bindTileEntitySpecialRenderer(c, r);
	}

}
