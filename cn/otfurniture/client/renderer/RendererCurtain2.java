/**
 * 
 */
package cn.otfurniture.client.renderer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import cn.liutils.api.client.render.RenderTileSided;
import cn.liutils.api.client.util.RenderUtils;

/**
 * 2x2型窗帘的渲染~
 * @author WeathFolD
 */
public class RendererCurtain2 extends RenderTileSided {

	public RendererCurtain2() {
	}

	@Override
	protected void renderAtOrigin(TileEntity te) {
		Tessellator t = Tessellator.instance;
		RenderUtils.loadTexture(this.getTexture(te));
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glPushMatrix(); {
			
			t.startDrawingQuads();
			t.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 1.0);
			t.addVertexWithUV(2.0, 0.0, 0.0, 1.0, 1.0);
			t.addVertexWithUV(2.0, 2.0, 0.0, 1.0, 0.0);
			t.addVertexWithUV(0.0, 2.0, 0.0, 0.0, 0.0);
			t.draw();
			
		} GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}

}
