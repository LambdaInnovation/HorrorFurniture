/**
 * 
 */
package cn.otfurniture.block;

import cn.liutils.core.proxy.LIClientProps;
import cn.otfurniture.OldTownFurniture;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class BlockWine extends BlockContainer {
	
	public static class Tile extends TileEntity {
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	public BlockWine() {
		super(Material.glass);
		this.setStepSound(soundTypeGlass);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_wine");
		setBlockTextureName("leon:wine");
		setBlockBounds(0.3F, 0F, 0.3F, 0.7F, .8F, .7F);
	}


	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderType() {
		return LIClientProps.RENDER_TYPE_EMPTY;
	}
	
	@Override
    public boolean isOpaqueCube()
    {
		return false;
    }
	
	@Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
