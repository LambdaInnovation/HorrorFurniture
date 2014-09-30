/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.block.BlockChandelierSmall.Tile;

/**
 * @author WeathFolD
 *
 */
public class BlockChandelierLarge extends BlockDirectionedMulti {

	public static class Tile extends TileEntity {

	}

	/**
	 * @param mat
	 */
	public BlockChandelierLarge() {
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setCreativeTab(OldTownFurniture.cct);
		setLightLevel(3.5F);
		setBlockName("chandeilerl");
		setBlockTextureName("leon:cdl");
		useRotation = false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return null;
	}
	
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(1, 0, 1, 2));
		list.add(new SubBlockPos(0, 0, 1, 3));
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d;
    	if(dir == 5) return Vec3.createVectorHelper(1, 0, 0);
    	if(dir == 3) return Vec3.createVectorHelper(1, 0, 1);
    	if(dir == 4) return Vec3.createVectorHelper(0, 0, 1);
    	return Vec3.createVectorHelper(0, 0, 0);
    }

}