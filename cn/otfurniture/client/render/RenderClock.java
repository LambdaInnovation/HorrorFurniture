/**
 * 
 */
package cn.otfurniture.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.model.ITileEntityModel;
import cn.liutils.api.client.model.TileEntityModelCustom;
import cn.liutils.api.client.render.RenderTileModelSided;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.block.ITextureProvider;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author FolD
 *
 */
public class RenderClock extends RenderTileModelSided {

	public RenderClock() {
		super(new TileEntityModelCustom(HFClientProps.MDL_CLOCK));
	}
	
	@Override
	protected void renderAtOrigin(TileEntity te) {
		
		this.scale = 0.1F;
		if(te.getBlockMetadata() >> 2 != 0) return;
		int meta = te.getBlockMetadata();
		ResourceLocation tex = ((ITextureProvider) te.getBlockType()).getTexture();
		RenderUtils.loadTexture(tex);
		
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glPushMatrix(); {
			GL11.glTranslatef(0F, 2.2F, 0F);
			GL11.glRotatef(rotations[meta], 0F, 1F, 0F);
			GL11.glScalef(scale, scale, scale);
			
			GL11.glPushMatrix(); {
				GL11.glRotated(getTheta(Minecraft.getSystemTime()), 0, 0, 1);
				theModel.renderPart(te, "Swing", 0F, 0F);
			} GL11.glPopMatrix();
			
			theModel.renderPart(te, "Main", 0F, 0F);
			
		} GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);
	}
	
	protected double getTheta(long time) {
		return 6.7 * Math.sin(time / 400D);
	}

}
