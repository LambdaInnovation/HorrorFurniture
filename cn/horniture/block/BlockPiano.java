/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.horniture.HorrorFurniture;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author FolD
 *
 */
public class BlockPiano extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntity {
		
	}

	/**
	 * @param mat
	 */
	public BlockPiano() {
		super(Material.iron);
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_piano");
		setBlockTextureName("leon:piano");
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, 0D);
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d;
    	if(dir == 5) return Vec3.createVectorHelper(1, 0, 0);
    	if(dir == 3) return Vec3.createVectorHelper(1, 0, 1);
    	if(dir == 4) return Vec3.createVectorHelper(0, 0, 1);
    	return Vec3.createVectorHelper(0, 0, 0);
    }

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(1, 0, 1, 2));
		list.add(new SubBlockPos(0, 0, 1, 3));
		list.add(new SubBlockPos(0, 1, 0, 4));
		list.add(new SubBlockPos(1, 1, 0, 5));
	}

}
