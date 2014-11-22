/**
 * 
 */
package cn.otfurniture.client.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.render.RenderTileDirMulti;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.BlockCurtain4;

/**
 * 4x4型窗帘的渲染。
 * @author WeathFolD
 */
public class RendererCurtain4 extends RenderTileDirMulti {

	public RendererCurtain4() {
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		int meta = ((BlockCurtain4.Tile)var1).getMetadata();
		if(meta >> 2 != 0) return;
		Vec3 rotate = ((BlockDirectionedMulti)var1.getBlockType()).getOffsetRotated(BlockDirectionedMulti.getFacingDirection(meta).ordinal());
		GL11.glPushMatrix(); {
			GL11.glTranslated(var2 + offX + rotate.xCoord, var4 + offY + rotate.yCoord, var6 + offZ + rotate.zCoord);
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
			renderAtOrigin(var1);
		} GL11.glPopMatrix();
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
			t.addVertexWithUV(4.0, 0.0, 0.0, 1.0, 1.0);
			t.addVertexWithUV(4.0, 4.0, 0.0, 1.0, 0.0);
			t.addVertexWithUV(0.0, 4.0, 0.0, 0.0, 0.0);
			t.draw();
			
		} GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}

}
