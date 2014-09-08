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

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockDesk;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class RenderDesk extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderDesk() {
		super(new TileEntityModelCustom(HFClientProps.MDL_DESK));
		setScale(.04F);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		RenderUtils.loadTexture(
				HFClientProps.TEX_DESK[((BlockDesk)var1.getBlockType()).id] );
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
