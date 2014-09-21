/**
 * 
 */
package cn.otfurniture.event;

import java.util.HashSet;
import java.util.Set;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.util.HudUtils;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.proxy.OFClientProps;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

/**
 * 一般事件侦听
 * @author WeathFolD
 */
public class OTEventListener {

	@SideOnly(Side.CLIENT)
	private static Set<Class<? extends Block>> ignoredBlocks = new HashSet();
	
	@SideOnly(Side.CLIENT)
	public static void addHighlightIgnoring(Class<? extends Block> bc) {
		ignoredBlocks.add(bc);
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void drawHighlight(DrawBlockHighlightEvent event) {
		if(event.target.typeOfHit == MovingObjectType.BLOCK) {
			Block bk = event.player.worldObj.getBlock(
					event.target.blockX, event.target.blockY, event.target.blockZ
			);
			if(ignoredBlocks.contains(bk.getClass())) 
				event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent ev) {
		if(ev.type == ElementType.CROSSHAIRS) {
			if(Investigator.INSTANCE.canInvestigate) {
				drawScope(ev.resolution.getScaledWidth(), ev.resolution.getScaledHeight());
				ev.setCanceled(true);
			}
		}
	}
	
	private void drawScope(int w, int h) {
		float x0 = w / 2F, y0 = h / 2F;
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1F, 1F, 1F, .5F);
		RenderUtils.loadTexture(OFClientProps.TEX_GUI_LEN);
		HudUtils.setTextureResolution(32, 32);
		HudUtils.drawTexturedModalRect(x0 - 8, y0 - 8, 16, 16);
		GL11.glDisable(GL11.GL_BLEND);
	}
}
