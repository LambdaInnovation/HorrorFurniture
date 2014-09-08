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
package cn.otfurniture.client.render;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockLamp;
import cn.otfurniture.proxy.HFClientProps;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

/**
 * @author WeAthFolD
 *
 */
public class RenderLamp extends TileEntitySpecialRenderer {
	
	private ITileEntityModel mdl = new TileEntityModelCustom(HFClientProps.MDL_LAMP);

	public RenderLamp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPushMatrix(); {
			
			ResourceLocation tex;
			BlockLamp lamp = (BlockLamp) var1.getBlockType();
			if(lamp.isBloody) {
				if(lamp.isLit) tex = HFClientProps.TEX_LAMPOB;
				else tex = HFClientProps.TEX_LAMPB;
			} else {
				if(lamp.isLit) tex = HFClientProps.TEX_LAMPO;
				else tex = HFClientProps.TEX_LAMP;
			}
			RenderUtils.loadTexture(tex);
			
			GL11.glTranslated(var2 + .5, var4, var6 + .5);
			GL11.glScalef(0.06F, 0.06F, 0.06F);
			mdl.render(var1, 0F, 0F);
			
		} GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

}
