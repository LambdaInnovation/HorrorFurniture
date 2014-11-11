/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.tile.TileSittable;
import cn.liutils.api.client.ITextureProvider;

/**
 * @author WeAthFolD
 *
 */
public class BlockSmallChair extends BlockDirectionedMulti implements ITextureProvider {

	public static class Tile extends TileSittable {
		
		public Tile() {
			offsetY = .3F;
		}
	}
	
	int id;
	
	/**
	 * @param mat
	 */
	public BlockSmallChair(int id) {
		super(Material.wood);
		setCreativeTab(OldTownFurniture.cct);
		this.id = id;
		setBlockName("hf_schair" + id);
		setBlockTextureName("leon:schair" + id);
		this.setBlockBounds(0F, 0F, 0F, 1F, .8F, 1F);
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
		return null;
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(.5F, 0F, .5F);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_SCHAIR[id];
	}
	
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float a, float b, float c)
    {
    	if(world.isRemote) return false;
    	Tile te = (Tile) world.getTileEntity(x, y, z);
    	te.onTileActivated(player);
        return true;
    }

}
