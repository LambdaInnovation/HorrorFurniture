/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;

/**
 * @author WeathFolD
 *
 */
public class BlockSmallCurtain extends BlockDirectionedMulti implements ITextureProvider {
	
	public static final class Tile extends TileEntity {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	private static final int rev_matrix[] = {
		1, 0, 3, 2
	};
	
	public final int id;
	
	public BlockSmallCurtain(int i) {
		super(Material.cloth);
		id = i;
		setStepSound(soundTypeCloth);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_scurtain");
		setBlockTextureName("leon:scurtain" + (id == 0 ? 0 : 1));
	}
	
    @Override
	public boolean onBlockActivated(World wrld, int x, int y, int z, EntityPlayer player,
    		int a, float b, float c, float d) {
    	int meta = wrld.getBlockMetadata(x, y, z);
    	wrld.setBlock(x, y, z, OFBlocks.scurtain[rev_matrix[id]], meta, 0x03);
    	return true;
    }
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d = ForgeDirection.values()[dir];
    	double a = 0.98, b = 0.02;
    	if(dir == 2)
    		return makeV(1, 0, a);
    	if(dir == 3)
    		return makeV(0, 0, b);
    	if(dir == 4)
    		return makeV(a, 0, 0);
    	return makeV(0, 0, 1);
    }
    
    private Vec3 makeV(double a, double b, double c) {
    	return Vec3.createVectorHelper(a, b, c);
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
	public void addSubBlocks(List<SubBlockPos> list) {
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs ct, List list)
    {
    	if(id == 0 || id == 2)
    		super.getSubBlocks(item, ct, list);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_SCURTAIN[id];
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int dir = getFacingDirection(getMetadata(world, x, y, z)).ordinal();
		float a = 0.1F, b = 0.9F;
		if(dir == 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, a, 1.0F, 1.0F);
		} else if(dir == 4) {
			this.setBlockBounds(b, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		} else if(dir == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, a);
		} else {
			this.setBlockBounds(0.0F, 0.0F, b, 1.0F, 1.0F, 1.0F);
		}
	}

}
