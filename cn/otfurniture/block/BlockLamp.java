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

import cn.liutils.core.proxy.LIClientProps;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.HFClientProps;
import cn.otfurniture.register.HFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

/**
 * @author WeAthFolD
 *
 */
public class BlockLamp extends Block implements ITileEntityProvider, ITextureProvider {

	public final int id;
	public final boolean isLit, isBloody;
	
	public static class Tile extends TileEntity {
		
	}
	
	public BlockLamp(int id) {
		super(Material.wood);
		this.id = id;
		isLit = (id & 1) != 0;
		isBloody = (id & 2) != 0;
		String s = "lamp" + (isBloody ? "b" : "");
		setBlockName(s);
		setBlockTextureName("leon:" + s);
		setCreativeTab(OldTownFurniture.cct);
		if(isLit)
			this.setLightLevel(2.5F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return LIClientProps.RENDER_TYPE_EMPTY;
	}
	
	@Override
    public boolean isOpaqueCube()
    {
		return false;
    }
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs ct, List list)
    {
        if(!isLit) super.getSubBlocks(item, ct, list);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int w, float a, float b, float c)
    {
    	world.setBlock(x, y, z, getReversal());
        return true;
    }
    
    private Block getReversal() {
    	return HFBlocks.lamp[isLit ? id - 1 : id + 1];
    }

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_LAMP[id];
	}

}
