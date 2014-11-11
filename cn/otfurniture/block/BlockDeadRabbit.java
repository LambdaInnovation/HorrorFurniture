/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author WeathFolD
 *
 */
public class BlockDeadRabbit extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntity {
		
	}

	/**
	 * @param mat
	 */
	public BlockDeadRabbit() {
		super(Material.cake);
		this.setStepSound(soundTypeSnow);
		this.useRotation = false;
		setBlockName("deadrabbit");
		setBlockTextureName("leon:deadrabbit");
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.3F, 0.7F);
		setCreativeTab(OldTownFurniture.cct);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0, 0, 0);
	}

}
