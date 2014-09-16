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
package cn.otfurniture.event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.network.MsgInvsStateUpdate;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

/**
 * Tick事件侦听
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
			
			MovingObjectPosition pos = Investigator.trace(player);
			boolean b = false;
			if(pos != null && pos.typeOfHit == MovingObjectType.BLOCK) {
				Block block = player.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				if(Investigator.INSTANCE.canInvestigate(player.worldObj, pos.blockX, pos.blockY, pos.blockZ))
					b = true;
			}
			OldTownFurniture.netHandler.sendTo(new MsgInvsStateUpdate(b), (EntityPlayerMP) player);
		}
	}
	
}
