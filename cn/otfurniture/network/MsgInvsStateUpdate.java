/**
 * 
 */
package cn.otfurniture.network;

import cn.otfurniture.investigate.Investigator;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * @author FolD
 *
 */
public class MsgInvsStateUpdate implements IMessage {
	
	boolean canInvestigate;

	public MsgInvsStateUpdate(boolean b) {
		canInvestigate = b;
	}
	
	public MsgInvsStateUpdate() { }

	@Override
	public void fromBytes(ByteBuf buf) {
		canInvestigate = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(canInvestigate);
	}
	
	public static class Handler implements IMessageHandler<MsgInvsStateUpdate, IMessage> {

		@Override
		public IMessage onMessage(MsgInvsStateUpdate msg, MessageContext ctx) {
			Investigator.INSTANCE.canInvestigate = msg.canInvestigate;
			return null;
		}
		
	}

}
