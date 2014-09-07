/**
 * 
 */
package cn.horniture.client.render;

import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;

/**
 * @author FolD
 *
 */
public class RenderSmallChair extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderSmallChair() {
		super(new TileEntityModelCustom(HFClientProps.MDL_SCHAIR));
		setScale(.14F);
	}

}
