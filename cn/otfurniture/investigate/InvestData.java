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
package cn.otfurniture.investigate;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;
import cn.liutils.api.util.BlockPos;

/**
 * 一个世界的调查信息数据表
 * @author WeAthFolD
 */
public class InvestData extends WorldSavedData {
	
	Map<BlockPos, String> dataMap = new HashMap();

	public InvestData(String str) {
		super(str);
	}
	
	public Map<BlockPos, String> getMap() {
		this.setDirty(true);
		return dataMap;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
//		System.out.println("ReadFromNBT called");
		for(int i = 0; ; i++) {
			int[] arr = nbt.getIntArray("crd" + i);
			if(arr == null || arr.length == 0) break;
			String str = nbt.getString("con" + i);
			dataMap.put(new BlockPos(arr[0], arr[1], arr[2]), str);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		int i = 0;
//		System.out.println("WriteToNBT called");
		nbt = new NBTTagCompound();
		for(Map.Entry<BlockPos, String> entry : dataMap.entrySet()) {
			nbt.setIntArray("crd" + i, new int[] { entry.getKey().x, entry.getKey().y, entry.getKey().z});
			nbt.setString("con" + i, entry.getValue());
			i++;
		}
	}

}
