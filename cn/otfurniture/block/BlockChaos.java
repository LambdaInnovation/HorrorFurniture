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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author WeathFolD
 *
 */
public class BlockChaos extends BlockDirectionedMulti {

	public static final class Tile extends TileEntity {
	}
	
	public BlockChaos() {
		super(Material.cloth);
		setStepSound(soundTypeCloth);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_chaos");
		setBlockTextureName("leon:chaos");
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d = ForgeDirection.values()[dir];
    	double a = 0.98, b = 0.02;
    	if(dir == 2)
    		return makeV(1, 0, a);
    	if(dir == 3)
    		return makeV(0, 0, b);
    	if(dir == 4)
    		return makeV(a, 0, 0);
    	return makeV(b, 0, 1);
    }
    
    private Vec3 makeV(double a, double b, double c) {
    	return Vec3.createVectorHelper(a, b, c);
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
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int dir = getFacingDirection(getMetadata(world, x, y, z)).ordinal();
		float a = 0.1F, b = 0.9F;
		if(dir == 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, a, 1.0F, 1.0F);
		} else if(dir == 4) {
			this.setBlockBounds(b, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else if(dir == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, a);
		} else {
			this.setBlockBounds(0.0F, 0.0F, b, 1.0F, 1.0F, 1.0F);
		}
	}

}
