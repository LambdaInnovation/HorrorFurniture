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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeAthFolD
 */
public class BlockLampLarge extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	public final int id;
	
	/**
	 * @param mat
	 */
	public BlockLampLarge(int i) {
		super(Material.wood);
		id = i;
		if(i == 1 || i == 3)
			this.setLightLevel(3.5F);
		setCreativeTab(OldTownFurniture.cct);
		String s = "lampl" + (i <= 1 ? "" : "b");
		setBlockName(s);
		setBlockTextureName("leon:" + s);
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

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
	@Override
	public Vec3 getRenderOffset() {
		return null;
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	int meta = world.getBlockMetadata(x, y, z);
    	System.out.println("Applying " + meta);
    	if((meta >> 2) != 0) {
    		System.out.println("aaa");
    		y -= 1;
    	}
    	Block reverse = getReverse();
    	world.setBlock(x, y, z, reverse, meta & 0x03, 0x03);
    	world.setBlock(x, y + 1, z, reverse, meta & 0x03 | 4, 0x03);
    	System.out.println("Set metadata " + (meta & 0x03) + " " + ( meta & 0x03 | 4));
    	System.out.println("Upper metadata : " + world.getBlockMetadata(x, y + 1, z));
        return true;
    }

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
	}
	
	private static final int[] revs = { 1, 0, 3, 2 };
	private Block getReverse() {
		return OFBlocks.lampl[revs[id]];
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if(id == 0 || id == 2) super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_LAMPL[id];
	}

}
