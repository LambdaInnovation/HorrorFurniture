/**
 * 
 */
package cn.horniture.client.render;

import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;

public class RenderBed extends RenderTileModelSided {

	public RenderBed() {
		super(new TileEntityModelCustom(HFClientProps.MDL_BED));
		this.scale = .095F;
	}

}
