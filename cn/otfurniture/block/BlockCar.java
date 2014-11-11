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
		addSubBlock(0, 1, 0);
		addSubBlock(1, 0, 0);
		addSubBlock(1, 1, 0);
		addSubBlock(2, 0, 0);
		addSubBlock(-1, 0, 0);
		addSubBlock(2, 1, 0);
		addSubBlock(-2, 0, 0);
		addSubBlock(3, 0, 0);
		
		addSubBlock(0, 0, 1);
		addSubBlock(0, 1, 1);
		addSubBlock(1, 0, 1);
		addSubBlock(1, 1, 1);
		addSubBlock(2, 0, 1);
		addSubBlock(-1, 0, 1);
		addSubBlock(2, 1, 1);
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

}
