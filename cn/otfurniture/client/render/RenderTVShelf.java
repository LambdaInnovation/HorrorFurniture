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
public class RenderTVShelf extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderTVShelf() {
		super(new TileEntityModelCustom(HFClientProps.MDL_TVSHELF));
		setScale(0.07F);
	}

}
