/**
 * 
 */
package cn.otfurniture.block;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;
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
	
	public class Tile extends TileEntity {
		public int tMeta;
		
		boolean init = false;
		
		public void updateEntity() {
			
			if(tMeta == 0)
				tMeta = getBlockMetadata();
			
			if((tMeta >> 2 == 0) && !init) {
				//System.out.println("Syncing all tMeta " + tMeta);
				BlockCurtain4 bt = (BlockCurtain4) this.getBlockType();
				
				boolean b = true;
				for(SubBlockPos pos : bt.subBlocks) {
					if(pos.id == 0) continue;
					SubBlockPos pos2 = bt.applyRotation(pos, getFacingDirection(tMeta).ordinal());
					TileEntity te = worldObj.getTileEntity(xCoord + pos2.offX, yCoord + pos2.offY, zCoord + pos2.offZ);
					if(te != null && te instanceof Tile) {
						Tile tee = (Tile) te;
						int meta = tee.tMeta;
						
						if(meta >> 2 <= 0) {
							b = false;
							tee.tMeta = tMeta + (pos.id << 2);
							System.out.println("Setting " + pos.id + " " + tee.tMeta);
						}
					} else b = false;
				}
				
				init = b;
			}
		}
		
		@Override
	    public void readFromNBT(NBTTagCompound nbt)
	    {
	        super.readFromNBT(nbt);
	        tMeta = nbt.getInteger("meta");
	    }

		@Override
	    public void writeToNBT(NBTTagCompound nbt)
	    {
	    	super.writeToNBT(nbt);
	    	nbt.setInteger("meta", tMeta);
	    }
		
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
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack)
    {
		System.out.println("ONBlockPlacedBy");
        int metadata = MathHelper.floor_double(placer.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        
        ForgeDirection dir = getFacingDirection(metadata);
        Iterator<SubBlockPos> iter = subBlocks.iterator();
        iter.next();
        
        while(iter.hasNext()) {
        	SubBlockPos pos = iter.next();
        	SubBlockPos pos2 = applyRotation(pos, dir.ordinal());
        	pos2.setMe(world, x, y, z, -4, this);
        }
        Tile te = (Tile) world.getTileEntity(x, y, z);
        te.tMeta = metadata;
    }
	
    public boolean onBlockActivated(World wrld, int x, int y, int z, EntityPlayer player, int a,
    		float b, float c, float d)
    {
    	int meta = getMetadata(wrld, x, y, z);
    	System.out.println(meta + " " + (meta & 3) + " " + (meta >> 2));
    	if(meta >> 2 < 0) return true;
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
    		pos2.setMe(wrld, x, y, z, -4, getReverse());
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
	public int getMetadata(IBlockAccess world, int x, int y, int z) {
		Tile te = (Tile) world.getTileEntity(x, y, z);
		return te.tMeta;
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
