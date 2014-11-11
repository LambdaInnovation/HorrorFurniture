/**
 * 
 */
package cn.otfurniture.client.renderer;

import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author FolD
 *
 */
public class RenderTVShelf extends RenderDirMultiModelled {

	/**
	 * @param mdl
	 */
	public RenderTVShelf() {
		super(new TileEntityModelCustom(OFClientProps.MDL_TVSHELF));
		setScale(0.07F);
	}

}
