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
package cn.otfurniture.tile;

import cn.otfurniture.entity.EntitySittable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

/**
 * @author WeAthFolD
 *
 */
public class TileSittable extends TileEntity {
	
	private EntitySittable ent = null;
	
	protected float offsetY = 0.0F;
	
	public TileSittable() {
	}
	
	public void updateEntity() {
		if(!worldObj.isRemote && ent == null) {
			ent = new EntitySittable(worldObj, this.xCoord + .5F, this.yCoord + .5F + offsetY, this.zCoord + .5F);
			worldObj.spawnEntityInWorld(ent);
		}
	}
	
	public void onTileActivated(EntityPlayer player) {
		if(ent == null) return;
		if(player.equals(ent.mountedPlayer)) {
			ent.disMount();
		} else if(!ent.isMounted()) {
			ent.mount(player);
		}
	}
	
	@Override
    public void invalidate()
    {
		if(ent != null) {
			if(ent.mountedPlayer != null)
				ent.mountedPlayer.mountEntity((Entity) null);
			ent.setDead();
		}
		super.invalidate();
    }


}
