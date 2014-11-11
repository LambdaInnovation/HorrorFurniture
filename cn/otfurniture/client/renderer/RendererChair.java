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
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockChair;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class RendererChair extends RenderDirMultiModelled {

	/**
	 * @param mdl
	 */
	public RendererChair() {
		super(new TileEntityModelCustom(OFClientProps.MDL_CHAIR));
		for(int i = 0; i < 4; i++)
			rotations[i] += 180;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		scale = 0.092F;
		RenderUtils.loadTexture(OFClientProps.TEX_CHAIR[((BlockChair)var1.getBlockType()).id]);
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
