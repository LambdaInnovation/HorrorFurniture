/**
 * Copyright (C) Lambda-Innovation, 2013-2014
 * This code is open-source. Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 */
package cn.otfurniture.network;

import cn.otfurniture.investigate.Investigator;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

/**
 * 调查信息同步的Message
 * @author WeAthFolD
 *
 */
public class MsgInvsContentUpdate implements IMessage {
	
	String content;
	int x, y, z;

	public MsgInvsContentUpdate(int a, int b, int c, String str) {
		content = str;
		x = a;
		y = b;
		z = c;
	}
	
	public MsgInvsContentUpdate() {}

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
	
	public static class Handler implements IMessageHandler<MsgInvsContentUpdate, IMessage> {

		@Override
		public IMessage onMessage(MsgInvsContentUpdate msg, MessageContext ctx) {
			Investigator.INSTANCE.modifyMessage(ctx.getServerHandler().playerEntity.worldObj,
					msg.x, msg.y, msg.z, msg.content);
			return null;
		}
		
	}

}
