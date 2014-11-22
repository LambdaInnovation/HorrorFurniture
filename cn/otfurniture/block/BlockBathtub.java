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

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class BlockBathtub extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
		public boolean watered = false;
		
		@Override
	    public void readFromNBT(NBTTagCompound nbt)
	    {
			nbt.setBoolean("watered", watered);
	    	super.readFromNBT(nbt);
	    }
	    
	    @Override
	    public void writeToNBT(NBTTagCompound nbt)
	    {
	    	watered = nbt.getBoolean("watered");
	    	super.writeToNBT(nbt);
	    }
	    
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	public final int id;

	public BlockBathtub(int i) {
		super(Material.rock);
		id = i;
		setCreativeTab(OldTownFurniture.cct);
		setHardness(2F);
		setBlockName("bathtub" + (id == 1 ? "b" : ""));
		setBlockTextureName("leon:bathtub" + (id == 1 ? "b" : ""));
		addSubBlock(1, 0, 0);
		setBlockBounds(0, 0, 0, 1, 0.65F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(1D, 0D, 0.5D);
	}
	
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer pl, int side, float a, float b, float c)
    {
    	ItemStack stack = pl.getCurrentEquippedItem();
    	if(stack == null) return false;
    	{
    		int meta = world.getBlockMetadata(x, y, z);
    		int[] crds = this.getOrigin(world, x, y, z, meta);
    		
    		x = crds[0];
    		z = crds[2];
    	}
    	
    	TileEntity t = world.getTileEntity(x, y, z);
    	if(t == null || !(t instanceof Tile))
    		return false;
    	Tile te = (Tile) t;
    	if(!te.watered && stack.getItem() == Items.water_bucket) { //倒水
    		te.watered = true;
    		if(!pl.capabilities.isCreativeMode)
    			pl.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
    		return true;
    	} else if(te.watered && stack.getItem() == Items.bucket) { //取水
    		te.watered = false;
    		if(!pl.capabilities.isCreativeMode)
    			pl.setCurrentItemOrArmor(0, new ItemStack(Items.water_bucket));
    		return true;
    	}
        return false;
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_BATHTUB[id];
	}

}
