/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
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
		addSubBlock(0, 1, 0); //1
		addSubBlock(1, 0, 0);
		addSubBlock(1, 1, 0); //3
		addSubBlock(2, 0, 0);
		addSubBlock(-1, 0, 0);
		addSubBlock(2, 1, 0); //6
		addSubBlock(-2, 0, 0);
		addSubBlock(3, 0, 0);
		
		addSubBlock(0, 0, 1);
		addSubBlock(0, 1, 1); //10
		addSubBlock(1, 0, 1);
		addSubBlock(1, 1, 1); //12
		addSubBlock(2, 0, 1);
		addSubBlock(-1, 0, 1);
		addSubBlock(2, 1, 1); //15
		addSubBlock(-2, 0, 1);
		addSubBlock(3, 0, 1);
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
	
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		switch(meta >> 2) {
		case 1:
		case 3:
		case 6:
		case 10:
		case 12:
		case 13:
			setBlockBounds(0, 0, 0, 1, 0.5F, 1);
			break;
		default:
			setBlockBounds(0, 0, 0, 1, 1, 1);
		}
	}

}
