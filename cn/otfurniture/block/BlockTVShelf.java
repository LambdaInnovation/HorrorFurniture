/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.liutils.api.client.ITextureProvider;

/**
 * @author FolD
 *
 */
public class BlockTVShelf extends BlockDirectionedMulti implements
		ITextureProvider {

	public static class Tile extends TileEntity {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	public BlockTVShelf() {
		super(Material.wood);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_tvshelf");
		setBlockTextureName("leon:tvshelf");
		addSubBlock(1, 0, 0);
		setBlockBounds(0, 0, 0, 1, 0.75F, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_TVSHELF;
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(1D, 0D, .5D);
	}

}
