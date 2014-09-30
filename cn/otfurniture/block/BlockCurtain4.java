/**
 * 
 */
package cn.otfurniture.block;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.liutils.core.LIUtilsMod;
import cn.liutils.core.network.MsgTileDMulti;
import cn.otfurniture.block.BlockCurtain2.Tile;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author WeathFolD
 *
 */
public class BlockCurtain4 extends BlockCurtain2 {
	
	public static class Tile extends TileDirectionedMulti {
		
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
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    public boolean onBlockActivated(World wrld, int x, int y, int z, EntityPlayer player, int a,
    		float b, float c, float d)
    {
    	int meta = getMetadata(wrld, x, y, z);
    	
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
    		pos2.setMe(wrld, x, y, z, meta | (pos.id << 2), getReverse());
    	}
    	
    	//Set origin block
    	wrld.setBlock(x, y, z, getReverse(), meta, 0x03);
        return true;
    }
	
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
		list.add(new SubBlockPos(0, 2, 0, 2));
		list.add(new SubBlockPos(0, 3, 0, 3));
		list.add(new SubBlockPos(1, 0, 0, 4));
		list.add(new SubBlockPos(1, 1, 0, 5));
		list.add(new SubBlockPos(1, 2, 0, 6));
		list.add(new SubBlockPos(1, 3, 0, 7));
		list.add(new SubBlockPos(2, 0, 0, 8));
		list.add(new SubBlockPos(2, 1, 0, 9));
		list.add(new SubBlockPos(2, 2, 0, 10));
		list.add(new SubBlockPos(2, 3, 0, 11));
		list.add(new SubBlockPos(3, 0, 0, 12));
		list.add(new SubBlockPos(3, 1, 0, 13));
		list.add(new SubBlockPos(3, 2, 0, 14));
		list.add(new SubBlockPos(3, 3, 0, 15));
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
