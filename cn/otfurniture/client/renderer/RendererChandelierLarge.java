/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.client.model.ModelChandelierBig;
import cn.otfurniture.proxy.OFClientProps;

/**
 * 
 * @author WeathFolD
 */
public class RendererChandelierLarge extends RenderDirMultiModelled {

	public RendererChandelierLarge() {
		super(new ModelChandelierBig());
		this.setTechne(true);
		setModelTexture(OFClientProps.TEX_CHANDELIER);
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		GL11.glTranslatef(0.5F, 1.5F, -0.5F);
		super.renderAtOrigin(te);
	}

}
