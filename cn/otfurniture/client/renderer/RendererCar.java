/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeathFolD
 *
 */
public class RendererCar extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RendererCar() {
		super(new TileEntityModelCustom(OFClientProps.MDL_CAR));
		this.setModelTexture(OFClientProps.TEX_CAR);
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		scale = 0.021F;
		super.renderAtOrigin(te);
	}

}
