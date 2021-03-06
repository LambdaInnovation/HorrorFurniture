/**
 * 
 */
package cn.otfurniture.investigate;

import java.util.Map;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldServer;
import cn.liutils.api.util.BlockPos;
import cn.liutils.api.util.Motion3D;

/**
 * @author WeAthFolD
 *
 */
public class Investigator {

	public static Investigator INSTANCE = new Investigator(); //单例大法好
	
	@SideOnly(Side.CLIENT)
	public boolean canInvestigate;
	
	/**
	 * 返回当前方块是否拥有调查信息。
	 */
	public boolean canInvestigate(World wrld, int x, int y, int z) {
		Map<BlockPos, String> map = loadMap(wrld);
		return map.containsKey(new BlockPos(x, y, z));
	}
	
	/**
	 * 获取某方块的调查信息。如果不存在，返回null。
	 */
	public String getMessage(World world, int x, int y, int z) {
		Map<BlockPos, String> map = loadMap(world);
		String str = map.get(new BlockPos(x, y, z));
		return str;
	}
	
	/**
	 * 修改某方块的调查信息。注意当前方块的破坏和替换等动作并没有被侦听。<br/>
	 * 如果str为null，则会抹除信息，请务必注意
	 */
	public void modifyMessage(World wrld, int x, int y, int z, String str) {
		Map<BlockPos, String> map = loadMap(wrld);
		if(str != null)
			map.put(new BlockPos(x, y, z), str);
		else map.remove(new BlockPos(x, y, z));
	}
	
	/**
	 * 加载一个世界对应的方块调查信息。
	 */
	private Map<BlockPos, String> loadMap(World world) {
		if(!world.isRemote) {
			WorldServer ws = (WorldServer) world;
			WorldSavedData data = ws.perWorldStorage.loadData(InvestData.class, "investigation");
			if(data == null) {
				data = new InvestData("investigation");
				ws.perWorldStorage.setData("investigation", data);
			}
			return ((InvestData)data).getMap();
		} else {
			throw new UnsupportedOperationException("Can't load the datamap in client!");
		}
	}
	
	public static MovingObjectPosition trace(EntityPlayer player) {
		Motion3D mo = new Motion3D(player, true);
		Vec3 v1 = mo.getPosVec(player.worldObj),
				v2 = mo.move(3.5).getPosVec(player.worldObj);
		return player.worldObj.rayTraceBlocks(v1, v2);
	}

}
