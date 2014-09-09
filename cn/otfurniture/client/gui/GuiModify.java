/**
 * 
 */
package cn.otfurniture.client.gui;

import org.lwjgl.opengl.GL11;

import cn.liutils.api.client.util.HudUtils;
import cn.liutils.api.client.util.RenderUtils;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.network.MsgContentUpdate;
import cn.otfurniture.proxy.HFClientProps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

/**
 * @author WeAthFolD
 *
 */
public class GuiModify extends GuiScreen {
	
	int x, y, z;
	String[] contents = new String[maxLines];
	
	public static final int maxLines = 6, charPerLine = 40;
	int editLine = 0;
	
	float xSize = 256F, ySize = 90F;
	
	public GuiModify() {
		for(int i = 0; i < maxLines; i++)
			contents[i] = new String();
	}

	public String getContent() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < maxLines; i++)
			sb.append(contents[i]).append("\n");
		return sb.toString();
	}
	
	public void onGuiClosed() {
		System.out.println("Change invoked");
		invokeChange();
	}
	
	/**
	 * 
	 */
	public GuiModify(int a, int b, int c, String d) {
		x = a;
		y = b;
		z = c;
		String[] s = d.split("\n");
		for(int i = 0; i < maxLines; i++)
			contents[i] = new String();
		for(int i = 0; i < s.length && i < maxLines; i++)
			contents[i] = s[i];
	}
	
	protected void invokeChange() {
		OldTownFurniture.netHandler.sendToServer(new MsgContentUpdate(x, y, z, getContent()));
	}
	
	@Override
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == 200)
        {
            this.editLine--;
            if(editLine < 0) editLine = 0;
        } else

        if (par2 == 208 || par2 == 28 || par2 == 156)
        {
            this.editLine++;
            if(editLine >= maxLines) editLine = maxLines - 1;
        } else

        if (par2 == 14 && contents[this.editLine].length() > 0)
        {
            contents[this.editLine] = contents[this.editLine].substring(0, contents[this.editLine].length() - 1);
        }

        if (ChatAllowedCharacters.isAllowedCharacter(par1) && contents[this.editLine].length() < charPerLine)
        {
        	contents[this.editLine] = contents[this.editLine] + par1;
        }
        
        super.keyTyped(par1, par2);
    }
	
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
    
    private void drawAtOrigin() {
    	HudUtils.setTextureResolution(256, 256);
    	RenderUtils.loadTexture(HFClientProps.TEX_GUI_DIALOGUE);
    	HudUtils.drawTexturedModalRect(0, 0, 0, 0, 256, 90);
    	
    	FontRenderer r = this.fontRendererObj;
    	int x0 = 20, h = 13;
    	int HEIGHT = 10;
    	for(int i = 0; i < maxLines; i++) {
    		String s = contents[i];
    		if((Minecraft.getSystemTime() % 1000) < 500 && editLine == i) {
    			s = s.concat(" |");
    		}
    		r.drawString(s, x0, h, 0xdec2ac);
    		h += HEIGHT;
    	}
    }
}
