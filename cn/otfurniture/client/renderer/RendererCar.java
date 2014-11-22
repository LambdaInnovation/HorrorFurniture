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
public class RendererCar extends RenderDirMultiModelled {

	/**
	 * @param mdl
	 */
	public RendererCar() {
		super(new TileEntityModelCustom(OFClientProps.MDL_CAR));
		this.setModelTexture(OFClientProps.TEX_CAR);
		this.setScale(0.021F);
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		scale = 0.021F;
		super.renderAtOrigin(te);
	}

}
