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

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.block.BlockCabinet;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class RenderCabinet extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderCabinet() {
		super(new TileEntityModelCustom(HFClientProps.MDL_CABINET));
		setScale(0.03F);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		this.setModelTexture(HFClientProps.TEX_CABINET[((BlockCabinet)var1.getBlockType()).id]);
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}
	


}
