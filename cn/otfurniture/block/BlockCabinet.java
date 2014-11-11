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
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.IMetadataProvider;
import cn.liutils.api.client.ITextureProvider;
import cn.liutils.core.LIUtils;
import cn.liutils.core.network.MsgTileDirMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 *
 */
public class BlockCabinet extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntityChest implements IMetadataProvider {
		
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	    	return INFINITE_EXTENT_AABB;
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
			return metadata;
		}
		//#end boilerplate0
	}

	public final int id;
	
	/**
	 * @param mat
	 */
	public BlockCabinet(int id) {
		super(Material.wood);
		setHardness(2.0F);
		this.id = id;
		setBlockName("cabinet" + id);
		setBlockTextureName("leon:cabinet" + id);
		setCreativeTab(OldTownFurniture.cct);
		addSubBlock(0, 1, 0);
		addSubBlock(1, 1, 0);
		addSubBlock(1, 0, 0);
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.getInventory(world, x, y, z);

            if (iinventory != null)
            {
                player.displayGUIChest(iinventory);
            }

            return true;
        }
    }
	
    public IInventory getInventory(World world, int x, int y, int z)
    {
    	//Transform to origin position
        {
        	int meta = world.getBlockMetadata(x, y, z);
        	int[] crds = this.getOrigin(world, x, y, z, meta);
        	x = crds[0];
        	y = crds[1];
        	z = crds[2];
        }
        //Get #1's pos and fetch two TileEntities
        int[] crds2 = offset(x, y, z, world.getBlockMetadata(x, y, z));
        TileEntity 
        	t = world.getTileEntity(x, y, z),
        	t2 = world.getTileEntity(crds2[0], crds2[1], crds2[2]);
        
        if(t == null || !(t instanceof Tile) 
        	|| t2 == null || !(t2 instanceof Tile))
        	return null;
        //Return the inventory
        return new InventoryLargeChest("container.chestDouble", (IInventory)t, (TileEntityChest)t2);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_CABINET[id];
	}

}
