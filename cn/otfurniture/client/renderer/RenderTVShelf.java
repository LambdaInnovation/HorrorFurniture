/**
 * 
 */
package cn.otfurniture.client.renderer;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author FolD
 *
 */
public class RenderTVShelf extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderTVShelf() {
		super(new TileEntityModelCustom(OFClientProps.MDL_TVSHELF));
		setScale(0.07F);
	}

}
