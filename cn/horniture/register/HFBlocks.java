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
package cn.horniture.register;

import cn.horniture.block.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * @author WeAthFolD
 *
 */
public class HFBlocks {

	public static Block
		cabinet[],
		shelf[],
		sofa_s[],
		sofa_m[],
		sofa_l[],
		bathtub,
		bathtub_b,
		tv,
		tv_b,
		sink,
		sink_b,
		mirror[],
		lamp[],
		lamp_b[],
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
		hanger;
	
	public static void init() {
		
		cabinet = new Block[] {
				new BlockCabinet(0),
				new BlockCabinet(1),
				new BlockCabinet(2),
				new BlockCabinet(3),
				new BlockCabinet(4),
		};
		shelf = new Block[] {
				new BlockShelf(0),
				new BlockShelf(1),
				new BlockShelf(2)
		};
		
		sofa_s = new Block[3];
		sofa_m = new Block[3];
		sofa_l = new Block[3];
		for(int i = 0; i < 3; i++) {
			sofa_s[i] = new BlockSofaSmall(i);
			sofa_m[i] = new BlockSofaMedium(i);
			sofa_l[i] = new BlockSofaLarge(i);
			
			GameRegistry.registerBlock(sofa_s[i], "hf_sofa_s" + i);
			GameRegistry.registerBlock(sofa_m[i], "hf_sofa_m" + i);
			GameRegistry.registerBlock(sofa_l[i], "hf_sofa_l" + i);
		}
		bathtub = new BlockBathtub(false);
		bathtub_b = new BlockBathtub(true);
		tv = new BlockTV(false);
		tv_b = new BlockTV(true);
		sink = new BlockSink(false);
		sink_b = new BlockSink(true);
		lamp = new Block[] { new BlockLamp(false, false), new BlockLamp(true, false) };
		lamp_b = new Block[] { new BlockLamp(false, true), new BlockLamp(true, true) };
		file_shelf = new BlockFileShelf();
		
		desk = new Block[5];
		for(int i = 0; i < 5; i++) {
			desk[i] = new BlockDesk(i);
			GameRegistry.registerBlock(desk[i], "hf_desk" + i);
		}
		
		lampl = new Block[4];
		for(int i = 0; i < 4; i++) {
			lampl[i] = new BlockLampLarge(i);
			GameRegistry.registerBlock(lampl[i], "hf_lampl" + i);
		}
		
		chair = new Block[4];
		for(int i = 0; i < 4; i++) {
			chair[i] = new BlockChair(i);
			GameRegistry.registerBlock(chair[i], "hf_chair" + i);
		}
		
		wdesk = new Block[2];
		for(int i = 0; i < 2; i++) {
			wdesk[i] = new BlockWritingDesk(i);
			GameRegistry.registerBlock(wdesk[i], "hf_wdesk" + i);
		}
		
		ksink = new Block[2];
		for(int i = 0; i < 2; i++) {
			ksink[i] = new BlockKitchenSink(i);
			GameRegistry.registerBlock(ksink[i], "hf_ksink" + i);
		}
		
		clock = new Block[2];
		for(int i = 0; i < 2; i++) {
			clock[i] = new BlockClock(i);
			GameRegistry.registerBlock(clock[i], "hf_clock" + i);
		}
		
		kshelf = new Block[4];
		for(int i = 0; i < 4; i++) {
			kshelf[i] = new BlockKitchenShelf(i);
			GameRegistry.registerBlock(kshelf[i], "hf_kshelf" + i);
		}
		
		tshelf = new Block[4];
		for(int i = 0; i < 4; i++) {
			tshelf[i] = new BlockTShelf(i);
			GameRegistry.registerBlock(tshelf[i], "hf_tshelf" + i);
		}
		
		ksshelf = new Block[3];
		for(int i = 0; i < 3; i++) {
			ksshelf[i] = new BlockKitchenShelfSmall(i);
			GameRegistry.registerBlock(ksshelf[i], "hf_ksshelf" + i);
		}
		
		schair = new Block[3];
		for(int i = 0; i < 3; i++) {
			schair[i] = new BlockSmallChair(i);
			GameRegistry.registerBlock(schair[i], "hf_schair" + i);
		}
		
		for(int i = 0; i < 5; i++)
			GameRegistry.registerBlock(cabinet[i], "hf_cabinet" + i);
		
		for(int i = 0; i < 3; i++)
			GameRegistry.registerBlock(shelf[i], "hf_shelf" + i);
		
		bed = new Block[2];
		for(int i = 0; i < 2; i++) {
			bed[i] = new BlockBed(i);
			GameRegistry.registerBlock(bed[i], "hf_bed" + i);
		}
		
		tvshelf = new BlockTVShelf();
		GameRegistry.registerBlock(tvshelf, "hf_tvsgekf");
		
		oillamp = new BlockOilLamp[2];
		oillamp[1] = new BlockOilLamp(true);
		oillamp[0] = new BlockOilLamp(false);
		GameRegistry.registerBlock(oillamp[1], "hf_oillamp0");
		GameRegistry.registerBlock(oillamp[0], "hf_oillamp1");
		
		hanger = new BlockHanger();
		GameRegistry.registerBlock(hanger, "hf_hanger");
		
		GameRegistry.registerBlock(bathtub, "hf_bathtub");
		GameRegistry.registerBlock(bathtub_b, "hf_bathtub_b");
		GameRegistry.registerBlock(tv, "hf_tv");
		GameRegistry.registerBlock(tv_b, "hf_tvb");
		GameRegistry.registerBlock(sink, "hf_sink");
		GameRegistry.registerBlock(sink_b, "hf_sinkb");
		GameRegistry.registerBlock(lamp[0], "hf_lamp");
		GameRegistry.registerBlock(lamp[1], "hf_lampl");
		GameRegistry.registerBlock(lamp_b[0], "hf_lampb");
		GameRegistry.registerBlock(lamp_b[1], "hf_lamplb");
		GameRegistry.registerBlock(file_shelf, "hf_fshelf");
		
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
	}
	
}
