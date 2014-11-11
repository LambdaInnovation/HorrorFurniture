/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.liutils.api.client.ITextureProvider;

/**
 * @author FolD
 *
 */
public class BlockTShelf extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileDirectionedMulti {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	final int id;
	
	public BlockTShelf(int i) {
		super(Material.wood);
		id = i;
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_tshelf" + i);
		setBlockTextureName("leon:tshelf" + (id == 3 ? 1 : 0));
		setHardness(1.0F);
		addSubBlock(0, 1, 0);
		addSubBlock(1, 1, 0);
		addSubBlock(1, 0, 0);
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
		return Vec3.createVectorHelper(1, 0, 0.5);
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_TSHELF[id];
	}

}
