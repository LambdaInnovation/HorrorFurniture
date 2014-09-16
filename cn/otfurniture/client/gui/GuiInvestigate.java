/**
 * 
 */
package cn.otfurniture.client.gui;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.util.HudUtils;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.proxy.OFClientProps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.world.World;

/**
 * 方块调查界面。简单的显示文字啦~www
 */
public class GuiInvestigate extends GuiScreen {
	
	final String[] contents = new String[GuiModify.maxLines];
	
	float xSize = 256F, ySize = 90F;

	public GuiInvestigate(String content) {
		String[] ss = content.split("\n");
		for(int i = 0; i < GuiModify.maxLines && i < ss.length; i++)
			contents[i] = ss[i];
	}
	
    @Override
	public void drawScreen(int par1, int par2, float par3)
    {
    	float x0 = (width - xSize) / 2F;
		float y0 = (height - ySize) / 2F;
		
    	GL11.glPushMatrix(); {
    		GL11.glTranslatef(x0, y0, 0F);
    		drawAtOrigin();
    	} GL11.glPopMatrix();
    	
    	this.drawDefaultBackground();
    }
    
    /**
     * 在原点绘制GUI。
     */
    private void drawAtOrigin() {
    	HudUtils.setTextureResolution(256, 256);
    	RenderUtils.loadTexture(OFClientProps.TEX_GUI_DIALOGUE);
    	HudUtils.drawTexturedModalRect(0, 0, 0, 0, 256, 90);
    	
    	FontRenderer r = this.fontRendererObj;
    	int x0 = 20, h = 13;
    	int HEIGHT = 10;
    	for(int i = 0; i < GuiModify.maxLines; i++) {
    		String s = contents[i];
    		r.drawString(s, x0, h, 0xdec2ac);
    		h += HEIGHT;
    	}
    }

}
