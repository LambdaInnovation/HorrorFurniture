/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class BlockCandleHolderLarge extends BlockDirectionedMulti {

	public static class Tile extends TileEntity {

	}

	public BlockCandleHolderLarge() {
		super(Material.cloth);
		setCreativeTab(OldTownFurniture.cct);
		setHardness(1F);
		setBlockName("hf_cholder");
		setBlockTextureName("leon:cholderl");
		useRotation = false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(.3F, 0F, .3F, .7F, .95F, .7F);
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(.5, 0, .5);
	}
}
