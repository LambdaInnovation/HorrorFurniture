/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeathFolD
 *
 */
public class RendererMirror extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RendererMirror() {
		super(new TileEntityModelCustom(OFClientProps.MDL_MIRROR));
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		this.scale = .046F;
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
