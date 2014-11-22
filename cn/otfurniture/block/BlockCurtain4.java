/**
 * 
 */
package cn.otfurniture.block;

import java.util.HashSet;
import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public final class BlockCurtain4 extends BlockCurtain2 {
	
	public static class Tile extends TileDirectionedMulti {
		
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	    
	}
	
	protected static Set<Integer> boundVanishes;
	static {
		boundVanishes = new HashSet<Integer>();
		boundVanishes.add(4);
		boundVanishes.add(5);
		boundVanishes.add(6);
		boundVanishes.add(8);
		boundVanishes.add(9);
		boundVanishes.add(10);
	}

	public BlockCurtain4(int idl) {
		super(idl);
		setBlockName("hf_lcurtain" + idl);
		setBlockTextureName("leon:lcurtain0");
	}
	
	@Override
	protected final void addBlocks() {
		addSubBlock(0, 1, 0);
		addSubBlock(0, 2, 0);
		addSubBlock(0, 3, 0);
		addSubBlock(1, 0, 0);
		addSubBlock(1, 1, 0);
		addSubBlock(1, 2, 0);
		addSubBlock(1, 3, 0);
		addSubBlock(2, 0, 0);
		addSubBlock(2, 1, 0);
		addSubBlock(2, 2, 0);
		addSubBlock(2, 3, 0);
		addSubBlock(3, 0, 0);
		addSubBlock(3, 1, 0);
		addSubBlock(3, 2, 0);
		addSubBlock(3, 3, 0);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public ResourceLocation[] getTextures() {
		return OFClientProps.TEX_LCURTAIN;
	}

	@Override
	public Block getReverse() {
		return OFBlocks.lcurtain[revMatrix[id]];
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool
    (World world, int x, int y, int z)
    {
		int meta = getMetadata(world, x, y, z);
		if(id % 2 == 0 && boundVanishes.contains(meta >> 2)) {
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = getMetadata(world, x, y, z);
		int dir = getFacingDirection(meta).ordinal();
		if(id % 2 == 0 && boundVanishes.contains(meta >> 2)) {
			setBlockBounds(0, 0, 0, 0, 0, 0);
			return;
		}
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
