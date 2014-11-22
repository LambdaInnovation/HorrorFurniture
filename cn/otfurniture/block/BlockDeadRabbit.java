/**
 * 
 */
package cn.otfurniture.block;

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

	public BlockDeadRabbit() {
		super(Material.cake);
		this.setStepSound(soundTypeSnow);
		this.useRotation = false;
		setBlockName("deadrabbit");
		setBlockTextureName("leon:deadrabbit");
		this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.3F, 0.7F);
		setCreativeTab(OldTownFurniture.cct);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0, 0, 0);
	}

}
