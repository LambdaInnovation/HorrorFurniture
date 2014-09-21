/**
 * 
 */
package cn.otfurniture.client.key;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cn.liutils.api.client.key.IKeyHandler;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.network.MsgInvsOpenGui;

/**
 * @author WeAthFolD
 */
public class KeyInvestigate implements IKeyHandler {

	@Override
	public void onKeyDown(int keyCode, boolean tickEnd) {
		if(tickEnd) return;
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if(player == null) return;
		//向服务端发送操作请求
		OldTownFurniture.netHandler.sendToServer(new MsgInvsOpenGui.Request(0));
	}

	@Override
	public void onKeyUp(int keyCode, boolean tickEnd) {}

	@Override
	public void onKeyTick(int keyCode, boolean tickEnd) {}

}
