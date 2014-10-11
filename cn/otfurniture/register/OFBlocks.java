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
package cn.otfurniture.register;

import cn.otfurniture.block.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * 方块注册类
 * @author WeAthFolD
 */
public class OFBlocks {

	public static Block
		cabinet[],
		shelf[],
		sofa_s[],
		sofa_m[],
		sofa_l[],
		bathtub[],
		tv[],
		sink[],
		lamp[],
		desk[],
		lampl[],
		chair[],
		file_shelf,
		wdesk[],
		ksink[],
		clock[],
		kshelf[],
		tshelf[],
		ksshelf[],
		schair[],
		bed[],
		tvshelf,
		oillamp[],
		hanger,
		piano,
		cholder,
		cholderl,
		wine,
		mirror[],
		scurtain[],
		bcurtain[],
		mcurtain[],
		lcurtain[],
		pianopb[],
		chandeliers,
		chandelierl,
		car,
		deadRabbit,
		mydoor[],
		chaos;
	
	public static void init() {
		//方块初始化和注册
		cabinet = reg(BlockCabinet.class, 5, "hf_cabinet");
		shelf = reg(BlockShelf.class, 3, "hf_shelf");
		sofa_s = reg(BlockSofaSmall.class, 3, "hf_sofas");
		sofa_m = reg(BlockSofaMedium.class, 3, "hf_sofam");
		sofa_l = reg(BlockSofaLarge.class, 3, "hf_sofal");
		bathtub = reg(BlockBathtub.class, 2, "hf_bathtub");
		tv = reg(BlockTV.class, 2, "hf_tv");
		sink = reg(BlockSink.class, 2, "hf_sink");
		lamp = reg(BlockLamp.class, 4, "hf_lamp");
		desk = reg(BlockDesk.class, 5, "hf_desk");
		lampl = reg(BlockLampLarge.class, 4, "hf_lampl");
		chair = reg(BlockChair.class, 4, "hf_chair");
		file_shelf = reg(BlockFileShelf.class, "hf_fshelf");
		wdesk = reg(BlockWritingDesk.class, 2, "hf_wdesk");
		ksink = reg(BlockKitchenSink.class, 2, "hf_ksink");
		clock = reg(BlockClock.class, 2, "hf_clock");
		kshelf = reg(BlockKitchenShelf.class, 4, "hf_kshelf");
		tshelf = reg(BlockTShelf.class, 4, "hf_tshelf");
		ksshelf = reg(BlockKitchenShelfSmall.class, 3, "hf_ksshelf");
		schair = reg(BlockSmallChair.class, 2, "hf_schair");
		bed = reg(BlockBed.class, 2, "hf_bed");
		tvshelf = reg(BlockTVShelf.class, "hf_tvshelf");
		oillamp = reg(BlockOilLamp.class, 2, "hf_oillamp");
		hanger = reg(BlockHanger.class, "hf_hanger");
		piano = reg(BlockPiano.class, "hf_piano");
		cholder = reg(BlockCandleHolderSmall.class, "hf_candleholder");
		cholderl = reg(BlockCandleHolderLarge.class, "hf_candleholderl");
		wine = reg(BlockWine.class, "hf_wine");
		mirror = reg(BlockMirror.class, 4, "hf_mirror");
		scurtain = reg(BlockSmallCurtain.class, 4, "hf_scurtain");
		bcurtain = reg(BlockBathCurtain.class, 4, "hf_bcurtain");
		mcurtain = reg(BlockMediumCurtain.class, 4, "hf_mcurtain");
		lcurtain = reg(BlockCurtain4.class, 2, "hf_lcurtain");
		pianopb = reg(BlockPianoRecorded.class, 1, "hf_pianop");
		chandeliers = reg(BlockChandelierSmall.class, "hf_chds");
		chandelierl = reg(BlockChandelierLarge.class, "hf_chdl");
		car = reg(BlockCar.class, "hf_car");
		deadRabbit = reg(BlockDeadRabbit.class, "hf_dead_rabbit");
		mydoor = reg(BlockMyDoor.class, 3, "hf_door");
		chaos = reg(BlockChaos.class, "hf_Chaos");
		
		//TileEntity注册
		GameRegistry.registerTileEntity(BlockCabinet.Tile.class, "hf_tile_cabinet");
		GameRegistry.registerTileEntity(BlockShelf.Tile.class, "hf_tile_shelf");
		GameRegistry.registerTileEntity(BlockSofaSmall.Tile.class, "hf_tile_ssofa");
		GameRegistry.registerTileEntity(BlockSofaMedium.Tile.class, "hf_tile_msofa");
		GameRegistry.registerTileEntity(BlockSofaLarge.Tile.class, "hf_tile_lsofa");
		GameRegistry.registerTileEntity(BlockBathtub.Tile.class, "hf_tile_bathtub");
		GameRegistry.registerTileEntity(BlockTV.Tile.class, "hf_tile_tv");
		GameRegistry.registerTileEntity(BlockSink.Tile.class, "hf_tile_sink");
		GameRegistry.registerTileEntity(BlockDesk.Tile.class, "hf_tile_desk");
		GameRegistry.registerTileEntity(BlockChair.Tile.class, "hf_tile_chair");
		GameRegistry.registerTileEntity(BlockLampLarge.Tile.class, "hf_tile_lampl");
		GameRegistry.registerTileEntity(BlockFileShelf.Tile.class, "hf_file_shelf");
		GameRegistry.registerTileEntity(BlockWritingDesk.Tile.class, "hf_writing_desk");
		GameRegistry.registerTileEntity(BlockKitchenSink.Tile.class, "hf_ksink");
		GameRegistry.registerTileEntity(BlockClock.Tile.class, "hf_tile_clock");
		GameRegistry.registerTileEntity(BlockKitchenShelf.Tile.class, "hf_kshelf");
		GameRegistry.registerTileEntity(BlockTShelf.Tile.class, "hf_tshelf");
		GameRegistry.registerTileEntity(BlockKitchenShelfSmall.Tile.class, "hf_ksshelf");
		GameRegistry.registerTileEntity(BlockSmallChair.Tile.class, "hf_schair");
		GameRegistry.registerTileEntity(BlockBed.Tile.class, "hf_bed");
		GameRegistry.registerTileEntity(BlockTVShelf.Tile.class, "hf_tvshelf");
		GameRegistry.registerTileEntity(BlockOilLamp.Tile.class, "hf_oillamp");
		GameRegistry.registerTileEntity(BlockHanger.Tile.class, "hf_hanger");
		GameRegistry.registerTileEntity(BlockPiano.Tile.class, "hf_piano");
		GameRegistry.registerTileEntity(BlockCandleHolderSmall.Tile.class, "hf_cholder");
		GameRegistry.registerTileEntity(BlockCandleHolderLarge.Tile.class, "hf_cholderl");
		GameRegistry.registerTileEntity(BlockWine.Tile.class, "hf_wine");
		GameRegistry.registerTileEntity(BlockMirror.Tile.class, "hf_mirror");
		GameRegistry.registerTileEntity(BlockSmallCurtain.Tile.class, "hf_scurtain");
		GameRegistry.registerTileEntity(BlockBathCurtain.Tile.class, "hf_bcurtain");
		GameRegistry.registerTileEntity(BlockCurtain4.Tile.class, "hf_lcurtain");
		GameRegistry.registerTileEntity(BlockLamp.Tile.class, "hf_slamp");
		GameRegistry.registerTileEntity(BlockPianoRecorded.Tile.class, "hf_pianop");
		GameRegistry.registerTileEntity(BlockChandelierSmall.Tile.class, "hf_cdlp");
		GameRegistry.registerTileEntity(BlockChandelierLarge.Tile.class, "hf_aaa");
		GameRegistry.registerTileEntity(BlockCar.Tile.class, "hf_car");
		GameRegistry.registerTileEntity(BlockDeadRabbit.Tile.class, "hf_dead_rabbit");
		GameRegistry.registerTileEntity(BlockChaos.Tile.class, "hf_chaos");
	}
	
	private static Block[] reg(Class<? extends Block> cl, int cnt, String key) {
		Block[] bls = new Block[cnt];
		try {
			for(int i = 0; i < cnt; i++) {
				bls[i] = cl.getConstructor(Integer.TYPE).newInstance(i);
				GameRegistry.registerBlock(bls[i], key + i);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bls;
	}
	
	private static Block reg(Class<? extends Block> cl, String key) {
		Block b = null;
		try {
			b = cl.getConstructor().newInstance();
			GameRegistry.registerBlock(b, key);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
}
