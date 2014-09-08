/**
 * 
 */
package cn.otfurniture.client.key;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import cn.liutils.api.client.key.IKeyHandler;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.network.MsgOpenGui;

/**
 * @author FolD
 *
 */
public class KeyInvestigate implements IKeyHandler {

	@Override
	public void onKeyDown(int keyCode, boolean tickEnd) {
		if(tickEnd) return;
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if(player == null) return;
		OldTownFurniture.netHandler.sendToServer(new MsgOpenGui.Request(0));
	}

	@Override
	public void onKeyUp(int keyCode, boolean tickEnd) {}

	@Override
	public void onKeyTick(int keyCode, boolean tickEnd) {}

}
