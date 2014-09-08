/**b
 * 
 */
package cn.otfurniture.event;

import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.network.MsgStateUpdate;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 事件侦听类
 * @author WeAthFolD
 */
public class OTTickEventListener {
	
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		if(event.phase == Phase.END) return;
		EntityPlayer player = event.player;
		if(!player.worldObj.isRemote) serverPlayerTick(player);
	}
	
	final int updtFreq = 4;
	int tick0;
	private void serverPlayerTick(EntityPlayer player) {
		if(++tick0 > updtFreq) {
			tick0 = 0;
			
			MovingObjectPosition pos = player.rayTrace(3.5, 0.0F);
			boolean b = false;
			if(pos != null && pos.typeOfHit == MovingObjectType.BLOCK) {
				Block block = player.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				System.out.println("Hitted, " + block);
				if(Investigator.INSTANCE.canInvestigate(player.worldObj, pos.blockX, pos.blockY, pos.blockZ))
					b = true;
			}
			System.out.println(b);
			OldTownFurniture.netHandler.sendTo(new MsgStateUpdate(b), (EntityPlayerMP) player);
		}
	}
	
}
