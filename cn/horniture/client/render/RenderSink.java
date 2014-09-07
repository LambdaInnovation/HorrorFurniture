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
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

import cn.horniture.block.BlockSink;
import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.api.client.util.RenderUtils;

/**
 * @author WeAthFolD
 *
 */
public class RenderSink extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderSink() {
		super(new TileEntityModelCustom(HFClientProps.MDL_SINK));
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		BlockSink sink = (BlockSink) var1.getBlockType();
		RenderUtils.loadTexture(sink.isBlooded ? HFClientProps.TEX_SINK_B : HFClientProps.TEX_SINK);
		this.scale = 0.016F;
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
