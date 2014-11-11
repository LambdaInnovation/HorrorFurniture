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

import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.liutils.api.client.render.Vertex;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockSink;
import cn.otfurniture.block.BlockSink.Tile;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 */
public class RendererSink extends RenderDirMultiModelled {

	public RendererSink() {
		super(new TileEntityModelCustom(OFClientProps.MDL_SINK));
		this.scale = 0.016F;
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		if(te.getBlockMetadata() >> 2 != 0) return;
		int meta = te.getBlockMetadata();
		float waterHeight = 1.0F;
		BlockSink block = (BlockSink) te.getBlockType();
		//GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix(); {
			
			if(((Tile)te).watered){
				IIcon i = BlockLiquid.getLiquidIcon("water_still");
				ResourceLocation rs = Minecraft.getMinecraft().getTextureManager().getResourceLocation(0);
				if(rs != null)
					RenderUtils.loadTexture(rs);
				
				float u0 = i.getMinU(), u1 = i.getMaxU(), v0 = i.getMinV(), v1 = i.getMaxV();
				Vertex ve1 = new Vertex(-.35, waterHeight, -0.3, u0, v0),
						ve2 = new Vertex(-.35, waterHeight, 0.3, u0, v1),
						ve3 = new Vertex(.35, waterHeight, 0.3, u1, v1),
						ve4 = new Vertex(.35, waterHeight, -0.3, u1, v0);
				Tessellator t = Tessellator.instance;
				
		        int l = 16777215;
		        float f = (l >> 16 & 255) / 255.0F;
		        float f1 = (l >> 8 & 255) / 255.0F;
		        float f2 = (l & 255) / 255.0F;
				if(block.id == 1)
					GL11.glColor4f(.8F, 0F, 0F, 1F);
				else GL11.glColor4f(f, f1, f2, 1.0F);
				t.startDrawingQuads();
				ve1.addTo(t);
				ve2.addTo(t);
				ve3.addTo(t);
				ve4.addTo(t);
				t.draw();
			}
			GL11.glColor4f(1F, 1F, 1F, 1F);
			RenderUtils.loadTexture(this.getTexture(te));
			GL11.glScalef(scale, scale, scale);
			theModel.render(te, 0F, 0F);
			//我已经醉了
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
		} GL11.glPopMatrix();
	}

}
