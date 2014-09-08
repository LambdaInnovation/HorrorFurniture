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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author WeAthFolD
 *
 */
public class BlockSink extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntity {
		public boolean watered;
	}
	
	public final boolean isBlooded;

	/**
	 * @param mat
	 */
	public BlockSink(boolean b) {
		super(Material.rock);
		isBlooded = b;
		setCreativeTab(OldTownFurniture.cct);
		setBlockName(b ? "sinkb" : "sink");
		setBlockTextureName(b ? "leon:sinkb" : "leon:sink");
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
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
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer pl, int side, float a, float b, float c)
    {
    	ItemStack stack = pl.getCurrentEquippedItem();
    	if(stack == null) return false;
    	Tile te = (Tile) world.getTileEntity(x, y, z);
    	if(!te.watered && stack.getItem() == Items.water_bucket) {
    		te.watered = true;
    		if(!pl.capabilities.isCreativeMode)
    			pl.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
    		return true;
    	} else if(te.watered && stack.getItem() == Items.bucket) {
    		te.watered = false;
    		if(!pl.capabilities.isCreativeMode)
    			pl.setCurrentItemOrArmor(0, new ItemStack(Items.water_bucket));
    		return true;
    	}
        return false;
    }

}
