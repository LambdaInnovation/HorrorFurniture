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
package cn.otfurniture.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class BlockDesk extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
		
	}

	public int id;
	
	public BlockDesk(int i) {
		super(Material.wood);
		setCreativeTab(OldTownFurniture.cct);
		id = i;
		setBlockName("desk" + i);
		setBlockTextureName("leon:desk" + i);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(1., 0.0, 0.5);
	}
	
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
	}

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_DESK[id];
	}

}
