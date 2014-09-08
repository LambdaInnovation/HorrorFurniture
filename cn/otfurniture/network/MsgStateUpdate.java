/**
 * 
 */
package cn.otfurniture.network;

import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * @author FolD
 *
 */
public class MsgStateUpdate implements IMessage {
	
	boolean canInvestigate;

	public MsgStateUpdate(boolean b) {
		canInvestigate = b;
	}
	
	public MsgStateUpdate() { }

	@Override
	public void fromBytes(ByteBuf buf) {
		canInvestigate = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(canInvestigate);
	}
	
	public static class Handler implements IMessageHandler<MsgStateUpdate, IMessage> {

		@Override
		public IMessage onMessage(MsgStateUpdate msg, MessageContext ctx) {
			Investigator.INSTANCE.canInvestigate = msg.canInvestigate;
			return null;
		}
		
	}

}
