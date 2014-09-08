/**
 * 
 */
package cn.otfurniture.investigate;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;
import cn.liutils.api.util.BlockPos;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

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
		return dataMap;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		System.out.println("ReadFromNBT called");
		for(int i = 0; ; i++) {
			int[] arr = nbt.getIntArray("crd" + i);
			if(arr == null) break;
			String str = nbt.getString("con" + i);
			dataMap.put(new BlockPos(arr[0], arr[1], arr[2]), str);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		int i = 0;
		System.out.println("WriteToNBT called");
		for(Map.Entry<BlockPos, String> entry : dataMap.entrySet()) {
			nbt.setIntArray("crd" + i, new int[] { entry.getKey().x, entry.getKey().y, entry.getKey().z});
			nbt.setString("con" + i, entry.getValue());
			i++;
		} 
		
		int[] crds;
		while((crds = nbt.getIntArray("crd" + i)) != null) {
			nbt.setIntArray("crd" + i, null);
		}
	}


}
