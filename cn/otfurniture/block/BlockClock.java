/**
 * 
 */
package cn.otfurniture.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * @author FolD
 *
 */
public class BlockClock extends BlockDirectionedMulti implements ITextureProvider {

	int id;
	
	public BlockClock(int id) {
		super(Material.wood);
		this.id = id;
		setBlockTextureName("leon:clock" + id);
		setBlockName("hf_clock" + id);
		setCreativeTab(OldTownFurniture.cct);
		setHardness(3.0F);
		addSubBlock(0, 1, 0);
		addSubBlock(0, 2, 0);
	}

	public static class Tile extends TileEntity {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getOffsetRotated(int dir) {
		  return Vec3.createVectorHelper(.5D, 0D, .5D);
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_CLOCK[id];
	}

}
