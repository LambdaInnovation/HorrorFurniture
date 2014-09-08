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
 * @author WeAthFolD
 */
public class OTGuiHandler implements IGuiHandler {
	
	public static String queue = "";

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		System.out.println(ID);
		return ID == 0 ? new GuiInvestigate(queue) : new GuiModify(x, y, z, queue);
	}

}
