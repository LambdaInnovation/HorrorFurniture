/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
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

	public BlockCurtain4(int idl) {
		super(idl);
		setBlockName("hf_lcurtain" + idl);
		setBlockTextureName("leon:lcurtain0");
	}
	
	@Override
	protected void addBlocks() {
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
