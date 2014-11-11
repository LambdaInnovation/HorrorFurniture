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
public class BlockChandelierSmall extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntity {
		
	}

	/**
	 * @param mat
	 */
	public BlockChandelierSmall() {
		super(Material.glass);
		setStepSound(soundTypeGlass);
		setCreativeTab(OldTownFurniture.cct);
		setLightLevel(2.0F);
		setBlockName("chandeilers");
		setBlockTextureName("leon:cds");
		useRotation = false;
		setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0.5D, 0D, 0.5D);
	}

}
