/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeathFolD
 *
 */
public class RendererMirror extends RenderDirMultiModelled {

	/**
	 * @param mdl
	 */
	public RendererMirror() {
		super(new TileEntityModelCustom(OFClientProps.MDL_MIRROR));
		setScale(0.023F);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
