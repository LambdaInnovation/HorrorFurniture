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

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.ITextureProvider;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class RendererClock extends RenderDirMultiModelled {

	public RendererClock() {
		super(new TileEntityModelCustom(OFClientProps.MDL_CLOCK));
		setScale(0.1F);
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		
		if(te.getBlockMetadata() >> 2 != 0) return;
		int meta = te.getBlockMetadata();
		
		ResourceLocation tex = ((ITextureProvider) te.getBlockType()).getTexture();
		RenderUtils.loadTexture(tex);
		
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPushMatrix(); {
			
			GL11.glTranslatef(0F, 2.2F, 0F);
			GL11.glScalef(scale, scale, scale);
			
			GL11.glPushMatrix(); {
				//绘制钟摆
				GL11.glRotated(getTheta(Minecraft.getSystemTime()), 0, 0, 1);
				theModel.renderPart(te, "Swing", 0F, 0F);
			} GL11.glPopMatrix();
			
			//绘制主要部分
			theModel.renderPart(te, "Main", 0F, 0F);
			
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
			
		} GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
	}
	
	protected double getTheta(long time) {
		//用正弦函数模拟真的没问题么？233
		return 6.7 * Math.sin(time / 400D);
	}

}
