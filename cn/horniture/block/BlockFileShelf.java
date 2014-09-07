/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.horniture.HorrorFurniture;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author FolD
 *
 */
public class BlockFileShelf extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntityChest {
		
	}

	public BlockFileShelf() {
		super(Material.iron);
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_fileshelf");
		setBlockTextureName("leon:fshelf");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, .5D);
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	Vec3 v = super.getOffsetRotated(dir);
    	if(dir == 4 || dir == 5) {
    		v.zCoord = 0.5;
    	} else {
    		v.xCoord = 0.5;
    	}
    	return v;
    }

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(1, 1, 0, 2));
		list.add(new SubBlockPos(0, 1, 0, 3));
		list.add(new SubBlockPos(-1, 0, 0, 4));
		list.add(new SubBlockPos(-1, 1, 0, 5));
	}

}
