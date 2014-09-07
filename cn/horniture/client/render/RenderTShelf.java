/**
 * 
 */
package cn.horniture.client.render;

import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;

/**
 * @author WeAthFolD
 *
 */
public class RenderTShelf extends RenderTileModelSided {

	public RenderTShelf() {
		super(new TileEntityModelCustom(HFClientProps.MDL_TSHELF));
		this.scale = 0.07F;
	}

}
