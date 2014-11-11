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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.IMetadataProvider;
import cn.liutils.api.client.ITextureProvider;
import cn.liutils.core.LIUtils;
import cn.liutils.core.network.MsgTileDirMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.tile.TileSittable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 *
 */
public class BlockSofaLarge extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileSittable implements IMetadataProvider {
		
		public Tile() {
			offsetY = .01F;
		}
		
		//#boilerplate0
		private boolean synced = false;
		private int ticksUntilReq = 4;
		int metadata = -1;
		
		@Override
		public void updateEntity() {
			if(metadata == -1) {
				metadata = this.getBlockMetadata();
			}
			if(worldObj.isRemote && !synced && ++ticksUntilReq == 5) {
				ticksUntilReq = 0;
				LIUtils.netHandler.sendToServer(new MsgTileDirMulti.Request(this));
			}
		}
		
		@Override
		public void setMetadata(int meta) {
			synced = true;
			metadata = meta;
		}
		
	    @Override
		public void readFromNBT(NBTTagCompound nbt)
	    {
	    	metadata = nbt.getInteger("meta");
	        super.readFromNBT(nbt);
	    }

	    @Override
		public void writeToNBT(NBTTagCompound nbt)
	    {
	    	nbt.setInteger("meta", metadata);
	        super.writeToNBT(nbt);
	    }

		@Override
		public int getMetadata() {
			if(metadata == -1)
				metadata = this.getBlockMetadata();
			return metadata;
		}
		//#end boilerplate0
		
		@Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	    	return INFINITE_EXTENT_AABB;
	    }
		
	}

	final int id;
	
	/**
	 * @param mat
	 */
	public BlockSofaLarge(int i) {
		super(Material.wood);
		id = i;
		setBlockName("sofal" + id);
		setBlockTextureName("leon:sofal" + id);
		setCreativeTab(OldTownFurniture.cct);
		addSubBlock(-1, 0, 0);
		addSubBlock(1, 0, 0);
		addSubBlock(2, 0, 0);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0, 0, 0.5);
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	Vec3 pos = getRenderOffset();
    	if(dir == 3) 
			return Vec3.createVectorHelper(pos.xCoord + 1, pos.yCoord, pos.zCoord);
		if(dir == 4)
			return Vec3.createVectorHelper(pos.zCoord, pos.yCoord, pos.xCoord + 1);
		if(dir == 2)
			return Vec3.createVectorHelper(0, pos.yCoord, pos.zCoord);
		return Vec3.createVectorHelper(pos.zCoord, pos.yCoord, 0);
    }
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float a, float b, float c)
    { 
    	if(world.isRemote) return false;
    	TileEntity t = world.getTileEntity(x, y, z);
    	if(t == null || !(t instanceof Tile))
    		return false;
    	Tile te = (Tile) t;
    	te.onTileActivated(player);
        return true;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
    	setBlockBounds(0F, 0F, 0F, 1F, 0.51F, 1F);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_SOFA[id];
	}

}
