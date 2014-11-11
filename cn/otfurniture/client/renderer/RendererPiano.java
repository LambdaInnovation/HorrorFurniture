/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author FolD
 *
 */
public class RendererPiano extends RenderDirMultiModelled {

	public RendererPiano() {
		super(new TileEntityModelCustom(OFClientProps.MDL_PIANO));
		this.setScale(0.08F);
		this.setModelTexture(OFClientProps.TEX_PIANO);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
