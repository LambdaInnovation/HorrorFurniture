/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author WeathFolD
 *
 */
public abstract class BlockCurtain2 extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}
	
	protected final int[] revMatrix = {
			1, 0, 3, 2
	};
	
	public final int id;

	public BlockCurtain2(int idl) {
		super(Material.cloth);
		id = idl;
		setCreativeTab(OldTownFurniture.cct);
		setStepSound(soundTypeCloth);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @SideOnly(Side.CLIENT)
    @Override
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
	public Vec3 getRenderOffset() {
		return null;
	}
	
    public boolean onBlockActivated(World wrld, int x, int y, int z, EntityPlayer player, int a,
    		float b, float c, float d)
    {
    	int meta = wrld.getBlockMetadata(x, y, z);
    	{
    		//Get back to origin
    		int[] crds = this.getOrigin(wrld, x, y, z, meta);
    		x = crds[0];
    		y = crds[1];
    		z = crds[2];
    		meta &= 0x03;
    	}
    	
    	for(SubBlockPos pos : this.subBlocks) {
    		//Set all the subBlocks
    		SubBlockPos pos2 = this.applyRotation(pos, this.getFacingDirection(meta).ordinal());
    		pos2.setMe(wrld, x, y, z, meta + (pos.id << 2), getReverse());
    	}
    	//Set origin block
    	wrld.setBlock(x, y, z, getReverse(), meta, 0x03);
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
    	if(id == 0 || id == 2)
    		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
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
	
	@SideOnly(Side.CLIENT)
	public abstract ResourceLocation[] getTextures();
	
	public abstract Block getReverse();
	
	@Override
	public ResourceLocation getTexture() {
		return getTextures()[id];
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
