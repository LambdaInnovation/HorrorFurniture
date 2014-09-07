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
import cn.horniture.HorrorFurniture;
import cn.horniture.proxy.HFClientProps;
import cn.horniture.tile.TileSittable;
import cn.liutils.api.block.BlockDirectionedMulti;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author WeAthFolD
 *
 */
public class BlockSofaSmall extends BlockDirectionedMulti implements ITextureProvider{ 
	
	public static class Tile extends TileSittable {
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	    	return INFINITE_EXTENT_AABB;
	    }
	}
	
	final int id;

	public BlockSofaSmall(int i) {
		super(Material.cloth);
		id = i;
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_sofas" + id);
		setBlockTextureName("leon:sofas" + id);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(.5D, 0D, .5D);
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(.5D, 0D, .5D);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float a, float b, float c)
    {
    	if(world.isRemote) return false;
    	Tile te = (Tile) world.getTileEntity(x, y, z);
    	te.onTileActivated(player);
        return true;
    }

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
	}
	
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_) {
    	setBlockBounds(0F, 0F, 0F, 1F, 0.4F, 1F);
    }

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_SOFA[id];
	}

}