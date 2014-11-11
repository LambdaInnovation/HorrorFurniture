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

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeAthFolD
 */
public class RendererKitchenShelf extends RenderDirMultiModelled {

	public RendererKitchenShelf() {
		super(new TileEntityModelCustom(OFClientProps.MDL_KSHELF));
		for(int i = 0; i < 4; i++) //Rotation fix
			this.rotations[i] += 90;
		setScale(0.1F);
	}
	
}
