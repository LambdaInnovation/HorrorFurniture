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
package cn.horniture.client.render;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.horniture.block.BlockTV;
import cn.horniture.block.BlockTV.Tile;
import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.api.client.util.RenderUtils;

/**
 * @author WeAthFolD
 *
 */
public class RenderTV extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderTV() {
		super(new TileEntityModelCustom(HFClientProps.MDL_TV));
	}
	
	protected void renderAtOrigin(TileEntity te) {
		int meta = te.getBlockMetadata();
		BlockTV b = (BlockTV) te.getBlockType();
		scale = 0.01F;
		Tile t = (Tile) te;
		ResourceLocation tex;
		if(b.isBlooded) {
			if(t.isOpen) {
				int ind = t.openedTick / 2;
				if(ind < 4) tex = HFClientProps.TEX_TVB_ANIM[ind];
				else tex = HFClientProps.TEX_TVB_OPEN;
			} else tex = HFClientProps.TEX_TVB;
		} else {
			if(t.isOpen) {
				int ind = t.openedTick / 2;
				
				if(ind < 4) tex = HFClientProps.TEX_TV_ANIM[ind];
				else tex = HFClientProps.TEX_TV_OPEN;
			} else tex = HFClientProps.TEX_TV;
		}
		
		GL11.glPushMatrix(); {
			
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
			GL11.glScalef(scale, scale, scale);
			RenderUtils.loadTexture(tex);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			theModel.render(te, 0F, 0F);
		} GL11.glPopMatrix();
	}

}
