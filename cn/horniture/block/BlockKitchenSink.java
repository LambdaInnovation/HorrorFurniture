/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
public class BlockKitchenSink extends BlockDirectionedMulti implements ITextureProvider {

	int id;
	
	public static class Tile extends TileEntity {
		
	}
	
	public BlockKitchenSink(int id) {
		super(Material.wood);
		this.id = id;
		setBlockName("hf_ksink" + id);
		setBlockTextureName("leon:ksink" + id);
		setCreativeTab(HorrorFurniture.cct);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(0.5D, 0D, 0.5D);
    }

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
	@Override
	public Vec3 getRenderOffset() {
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		
	}

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_KSINK[id];
	}

}