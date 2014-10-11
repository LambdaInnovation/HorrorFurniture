/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.liutils.core.proxy.LIClientProps;
import cn.otfurniture.OldTownFurniture;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class BlockCandleHolderSmall extends BlockContainer {

	public static class Tile extends TileEntity {

	}

	public BlockCandleHolderSmall() {
		super(Material.cloth);
		setCreativeTab(OldTownFurniture.cct);
		setHardness(1F);
		setBlockName("hf_cholder");
		setBlockTextureName("leon:cholders");
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

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(.3F, 0F, .3F, .7F, .95F, .7F);
	}


}
