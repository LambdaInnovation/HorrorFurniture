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
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.horniture.HorrorFurniture;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author WeAthFolD
 *
 */
public class BlockTV extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntity {
		public boolean isOpen;
		public int openedTick = 0;
		
		@Override
		public void updateEntity() {
			if(isOpen) ++openedTick;
		}
		
		public void open() {
			isOpen = true;
			openedTick = 0;
		}
		
		public void close() {
			isOpen = false;
		}
	}
	
	public boolean isBlooded;

	public BlockTV(boolean b) {
		super(Material.iron);
		setCreativeTab(HorrorFurniture.cct);
		isBlooded = b;
		setBlockName(b ? "tvb" : "tv");
		setBlockTextureName("leon:" + (b ? "tvb" : "tv"));
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(0.5D, 0D, 0.5D);
    }

	@Override
	public Vec3 getRenderOffset() {
		return null;
	}

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer pl, int side, float a, float b, float c)
    {
		System.out.println(world.isRemote);
		Tile te = (Tile) world.getTileEntity(x, y, z);
		if(te.isOpen) te.close();
		else te.open();
		return true;
    }

}