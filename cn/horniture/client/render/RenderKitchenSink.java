/**
 * 
 */
package cn.horniture.client.render;

import net.minecraft.tileentity.TileEntity;
import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;

/**
 * @author FolD
 *
 */
public class RenderKitchenSink extends RenderTileModelSided {

	public RenderKitchenSink() {
		super(new TileEntityModelCustom(HFClientProps.MDL_KSINK));
	}

	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		this.scale = 0.098F;
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}
}
