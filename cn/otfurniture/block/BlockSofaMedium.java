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

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.tile.TileSittable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 *
 */
public class BlockSofaMedium extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileSittable {
		@Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	    	return INFINITE_EXTENT_AABB;
	    }
	}

	final int id;
	
	public BlockSofaMedium(int i) {
		super(Material.cloth);
		id = i;
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("sofam" + i);
		setBlockTextureName("leon:sofam" + i);
		addSubBlock(1, 0, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(1, 0, .5);
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float a, float b, float c)
    {
    	if(world.isRemote) return false;
    	TileEntity t = world.getTileEntity(x, y, z);
    	if(t == null || !(t instanceof Tile))
    		return false;
    	Tile te = (Tile) world.getTileEntity(x, y, z);
    	te.onTileActivated(player);
        return true;
    }
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
    	setBlockBounds(0F, 0F, 0F, 1F, 0.4F, 1F);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_SOFA[id];
	}

}
