/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.horniture.HorrorFurniture;
import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author FolD
 *
 */
public class BlockTShelf extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
		
	}

	final int id;
	
	public BlockTShelf(int i) {
		super(Material.wood);
		id = i;
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_tshelf" + i);
		setBlockTextureName("leon:tshelf" + i);
		setHardness(1.0F);
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

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
		list.add(new SubBlockPos(1, 1, 0, 2));
		list.add(new SubBlockPos(1, 0, 0, 3));
	}

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_TSHELF[id];
	}

}
