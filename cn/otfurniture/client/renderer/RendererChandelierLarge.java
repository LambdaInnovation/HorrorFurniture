/**
 * 
 */
package cn.otfurniture.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.client.model.ModelChandelierBig;
import cn.otfurniture.client.model.ModelChandelierSmall;
import cn.otfurniture.proxy.OFClientProps;

/**
 * 
 * @author WeathFolD
 */
public class RendererChandelierLarge extends RenderTileModelSided {

	public RendererChandelierLarge() {
		super(new ModelChandelierBig());
		this.setTechne(true);
		setModelTexture(OFClientProps.TEX_CHANDELIER);
	}
	
	protected void renderAtOrigin(TileEntity te) {
		GL11.glTranslatef(0.5F, 1.5F, -0.5F);
		super.renderAtOrigin(te);
	}

}
