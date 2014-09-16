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
package cn.otfurniture.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * TileSittable的支持实体~
 * @author WeAthFolD
 */
public class EntitySittable extends Entity {
	
	public EntityPlayer mountedPlayer;
	Vec3 startPt;

	public EntitySittable(World wrld, float x, float y, float z) {
		super(wrld);
		setPosition(x, y, z);
		setSize(0.01F, 0.01F);
		startPt = Vec3.createVectorHelper(x,y,z);
	}
	
	public EntitySittable(World wrld) {
		super(wrld);
		setSize(0.01F, 0.01F);
	}
	
	public void mount(EntityPlayer player) {
		player.mountEntity(this);
		mountedPlayer = player;
	}
	
	public void disMount() {
		if(mountedPlayer != null) {
			mountedPlayer.mountEntity((Entity)null);
			mountedPlayer = null;
		}
	}
	
	public boolean isMounted() {
		return mountedPlayer != null;
	}
	
	@Override
	public void onUpdate() {
		if(!worldObj.isRemote)
			if(startPt != null) {
				posX = startPt.xCoord;
				posY = startPt.yCoord;
				posZ = startPt.zCoord;
			} else setDead();
	}

	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
	}

}
