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
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author WeathFolD
 *
 */
public class BlockPianoBase extends BlockDirectionedMulti {

	public static class Tile extends TileDirectionedMulti {
	}

	public BlockPianoBase() {
		super(Material.iron);
		setCreativeTab(OldTownFurniture.cct);
		setHardness(4.0F);
		addSubBlock(1, 0, 0);
		addSubBlock(1, 0, 1);
		addSubBlock(0, 0, 1);
		addSubBlock(0, 1, 0);
		addSubBlock(1, 1, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, 0D);
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d;
    	if(dir == 5) return Vec3.createVectorHelper(1, 0, 0);
    	if(dir == 3) return Vec3.createVectorHelper(1, 0, 1);
    	if(dir == 4) return Vec3.createVectorHelper(0, 0, 1);
    	return Vec3.createVectorHelper(0, 0, 0);
    }

}
