/**
 * 
 */
package cn.otfurniture.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import cn.otfurniture.OFGuiHandler;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * 
 * @author WeAthFolD
 *
 */
public class MsgInsvOpenGui implements IMessage {
	
	public String content;
	public int type;
	public int x, y, z;

	/**
	 * 
	 */
	public MsgInsvOpenGui(String str) {
		content = str;
		type = 0;
	}
	
	public MsgInsvOpenGui(String str, int x, int y, int z) {
		content = str;
		type = 1;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public MsgInsvOpenGui() {}

	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.network.simpleimpl.IMessage#fromBytes(io.netty.buffer.ByteBuf)
	 */
	@Override
	public void fromBytes(ByteBuf buf) {
		type = buf.readByte();
		if(type == 1) {
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
		content = ByteBufUtils.readUTF8String(buf);
	}

	/* (non-Javadoc)
	 * @see cpw.mods.fml.common.network.simpleimpl.IMessage#toBytes(io.netty.buffer.ByteBuf)
	 */
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeByte(type);
		if(type == 1) {
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}
		ByteBufUtils.writeUTF8String(buf, content);
	}
	
	public static class Handler implements IMessageHandler<MsgInsvOpenGui, IMessage> {

		@Override
		public IMessage onMessage(MsgInsvOpenGui msg, MessageContext ctx) {
			OFGuiHandler.currentContent = msg.content;
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			System.out.println("Now we are opening GUI");
			if(player != null)
				player.openGui(OldTownFurniture.INSTANCE, msg.type, player.worldObj, msg.x, msg.y, msg.z);
			return null;
		}
		
	}
	
	public static class Request implements IMessage {
		
		public int id;
		
		public Request(int i) {
			id = i;
		}
		
		public Request() {}

		@Override
		public void fromBytes(ByteBuf buf) {
			id = buf.readByte();
		}

		@Override
		public void toBytes(ByteBuf buf) {
			buf.writeByte(id);
		}
		
		public static class Handler implements IMessageHandler<Request, IMessage> {

			@Override
			public IMessage onMessage(Request message, MessageContext ctx) {
				EntityPlayerMP player = ctx.getServerHandler().playerEntity;
				MovingObjectPosition pos = Investigator.trace(player);
				if(pos != null && pos.typeOfHit == MovingObjectType.BLOCK) {
					String str = Investigator.INSTANCE.getMessage(player.worldObj,
							pos.blockX, pos.blockY, pos.blockZ);
					if(message.id == 1) {
						OldTownFurniture.netHandler.sendTo(new MsgInsvOpenGui(str == null ? "" : str, pos.blockX, pos.blockY, pos.blockZ), ctx.getServerHandler().playerEntity);
					} else {
						if(str != null)
							OldTownFurniture.netHandler.sendTo(new MsgInsvOpenGui(str), ctx.getServerHandler().playerEntity);
						else System.out.println("Attempted inv, but didn't find the matching block");
					}
				}
				return null;
			}
			
		}
		
	}

}