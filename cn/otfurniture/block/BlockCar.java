/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author WeathFolD
 *
 */
public class BlockCar extends BlockDirectionedMulti {

	public static class Tile extends TileDirectionedMulti {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	public BlockCar() {
		super(Material.iron);
		this.setStepSound(soundTypeStone);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_car");
		setBlockTextureName("leon:car");
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	if(dir == 3) 
			return Vec3.createVectorHelper(1, 0, 1);
		if(dir == 4)
			return Vec3.createVectorHelper(0, 0, 1);
		if(dir == 2)
			return Vec3.createVectorHelper(0, 0, 0);
		return Vec3.createVectorHelper(1, 0, 0);
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0.0, 0.0, 0.0);
	}

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
		list.add(new SubBlockPos(1, 0, 0, 2));
		list.add(new SubBlockPos(1, 1, 0, 3));
		list.add(new SubBlockPos(2, 0, 0, 4));
		list.add(new SubBlockPos(-1, 0, 0, 5));
		list.add(new SubBlockPos(2, 1, 0, 6));
		list.add(new SubBlockPos(-2, 0, 0, 7));
		list.add(new SubBlockPos(3, 0, 0, 8));
		
		list.add(new SubBlockPos(0, 0, 1, 9));
		list.add(new SubBlockPos(0, 1, 1, 10));
		list.add(new SubBlockPos(1, 0, 1, 11));
		list.add(new SubBlockPos(1, 1, 1, 12));
		list.add(new SubBlockPos(2, 0, 1, 13));
		list.add(new SubBlockPos(-1, 0, 1, 14));
		list.add(new SubBlockPos(2, 1, 1, 15));
		list.add(new SubBlockPos(-2, 0, 1, 16));
		list.add(new SubBlockPos(3, 0, 1, 17));
	}

}
