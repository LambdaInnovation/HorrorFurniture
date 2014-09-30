/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
public class BlockWritingDesk extends BlockDirectionedMulti implements ITextureProvider {

	public static class Tile extends TileDirectionedMulti {
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	int id;
	
	public BlockWritingDesk(int id) {
		super(Material.wood);
		setBlockName("hf_wdesk" + id);
		setBlockTextureName("leon:wdesk" + id);
		setCreativeTab(OldTownFurniture.cct);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	Vec3 v = super.getOffsetRotated(dir);
    	if(dir == 4 || dir == 5) {
    		v.zCoord = 0.5;
    	} else {
    		v.xCoord = 0.5;
    	}
    	return v;
    }
    
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, .5D);
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(-1, 0, 0, 1));
		list.add(new SubBlockPos(1, 0, 0, 2));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_WDESK[id];
	}

}
