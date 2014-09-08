/**
 * 
 */
package cn.otfurniture.event;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.util.HudUtils;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.proxy.HFClientProps;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

/**
 * @author WeathFolD
 *
 */
public class OTEventListener {

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
		RenderUtils.loadTexture(HFClientProps.TEX_GUI_LEN);
		HudUtils.setTextureResolution(32, 32);
		HudUtils.drawTexturedModalRect(x0 - 8, y0 - 8, 16, 16);
		GL11.glDisable(GL11.GL_BLEND);
	}
}
