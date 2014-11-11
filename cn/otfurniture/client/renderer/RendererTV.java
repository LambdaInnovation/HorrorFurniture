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
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockTV;
import cn.otfurniture.block.BlockTV.Tile;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class RendererTV extends RenderDirMultiModelled {

	public RendererTV() {
		super(new TileEntityModelCustom(OFClientProps.MDL_TV));
		setScale(0.01F);
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		int meta = te.getBlockMetadata();
		BlockTV b = (BlockTV) te.getBlockType();
		Tile t = (Tile) te;
		ResourceLocation tex;
		
		if(b.id == 1) {
			if(t.isOpen) {
				int ind = t.openedTick / 2;
				if(ind < 4) tex = OFClientProps.TEX_TVB_ANIM[ind];
				else tex = OFClientProps.TEX_TVB_OPEN;
			} else tex = OFClientProps.TEX_TVB;
		} else {
			if(t.isOpen) {
				int ind = t.openedTick / 2;
				
				if(ind < 4) tex = OFClientProps.TEX_TV_ANIM[ind];
				else tex = OFClientProps.TEX_TV_OPEN;
			} else tex = OFClientProps.TEX_TV;
		}
		
		GL11.glPushMatrix(); {
			
			RenderUtils.loadTexture(tex);
			//System.out.println("Rotation : " + rotations[meta]);
			GL11.glScalef(scale, scale, scale);
			//谁告诉我OpenGL的渲染顺序到底是怎么样啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊！
			GL11.glRotatef(180F, 0F, 1F, 0F);
			theModel.render(te, 0F, 0F);
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
			
		} GL11.glPopMatrix();
	}

}
