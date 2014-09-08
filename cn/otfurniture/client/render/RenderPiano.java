/**
 * 
 */
package cn.otfurniture.client.render;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author FolD
 *
 */
public class RenderPiano extends RenderTileModelSided {

	/**
	 * @param mdl
	 */
	public RenderPiano() {
		super(new TileEntityModelCustom(HFClientProps.MDL_PIANO));
		this.setModelTexture(HFClientProps.TEX_PIANO);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		scale = .08F;
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
