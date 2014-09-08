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
public class RenderFileShelf extends RenderTileModelSided {

	public RenderFileShelf() {
		super(new TileEntityModelCustom(HFClientProps.MDL_FILE_SHELF));
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		this.scale = .1F;
		this.texture = HFClientProps.TEX_FSHELF;
		super.renderTileEntityAt(var1, var2, var4, var6, var8);
	}

}
