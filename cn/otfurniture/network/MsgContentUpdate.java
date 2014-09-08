/**
 * 
 */
package cn.otfurniture.network;

import cn.otfurniture.investigate.Investigator;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * @author FolD
 *
 */
public class MsgContentUpdate implements IMessage {
	
	String content;
	int x, y, z;

	public MsgContentUpdate(int a, int b, int c, String str) {
		content = str;
		x = a;
		y = b;
		z = c;
	}
	
	public MsgContentUpdate() {}

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
		content = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		ByteBufUtils.writeUTF8String(buf, content);
	}
	
	public static class Handler implements IMessageHandler<MsgContentUpdate, IMessage> {

		@Override
		public IMessage onMessage(MsgContentUpdate msg, MessageContext ctx) {
			Investigator.INSTANCE.modifyMessage(ctx.getServerHandler().playerEntity.worldObj,
					msg.x, msg.y, msg.z, msg.content);
			return null;
		}
		
	}

}
