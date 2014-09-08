/**
 * 
 */
package cn.otfurniture.client.render;

import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author FolD
 *
 */
public class RenderKSShelf extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderKSShelf() {
		super(new TileEntityModelCustom(HFClientProps.MDL_KSSHELF));
		scale = 0.1F;
		for(int i = 0; i < 4; i++)
			this.rotations[i] += 90;
	}

}
