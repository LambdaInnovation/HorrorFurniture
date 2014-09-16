/**
 * 
 */
package cn.otfurniture;

import cn.otfurniture.client.gui.GuiInvestigate;
import cn.otfurniture.client.gui.GuiModify;
import cn.otfurniture.investigate.Investigator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * OTF的GUIFactory.
 * @author WeAthFolD
 */
public class OFGuiHandler implements IGuiHandler {
	
	//当前操作方块的调查内容。用来解决从服务器发包的问题
	public static String currentContent = "";

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return ID == 0 ? new GuiInvestigate(currentContent) : new GuiModify(x, y, z, currentContent);
	}

}
