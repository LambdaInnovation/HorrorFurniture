/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.IMetadataProvider;
import cn.liutils.core.LIUtilsMod;
import cn.liutils.core.network.MsgTileDMulti;
import cn.otfurniture.OldTownFurniture;

/**
 * @author FolD
 *
 */
public class BlockFileShelf extends BlockDirectionedMulti {

	public static class Tile extends TileEntityChest implements
			IMetadataProvider {

		@Override
		@SideOnly(Side.CLIENT)
		public AxisAlignedBB getRenderBoundingBox() {
			return INFINITE_EXTENT_AABB;
		}

		//#boilerplate0
		private boolean synced = false;
		private int ticksUntilReq = 4;
		int metadata = -1;
		
		@Override
		public void updateEntity() {
			if(metadata == -1) {
				metadata = this.getBlockMetadata();
			}
			if(worldObj.isRemote && !synced && ++ticksUntilReq == 5) {
				ticksUntilReq = 0;
				LIUtilsMod.netHandler.sendToServer(new MsgTileDMulti.Request(this));
			}
		}
		
		@Override
		public void setMetadata(int meta) {
			synced = true;
			metadata = meta;
		}
		
	    @Override
		public void readFromNBT(NBTTagCompound nbt)
	    {
	    	metadata = nbt.getInteger("meta");
	        super.readFromNBT(nbt);
	    }

	    @Override
		public void writeToNBT(NBTTagCompound nbt)
	    {
	    	nbt.setInteger("meta", metadata);
	        super.writeToNBT(nbt);
	    }

		@Override
		public int getMetadata() {
			if(metadata == -1)
				metadata = this.getBlockMetadata();
			return metadata;
		}
		//#end boilerplate0
	}

	public BlockFileShelf() {
		super(Material.iron);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_fileshelf");
		setBlockTextureName("leon:fshelf");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, .5D);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getOffsetRotated(int dir) {
		Vec3 v = super.getOffsetRotated(dir);
		if (dir == 4 || dir == 5) {
			v.zCoord = 0.5;
		} else {
			v.xCoord = 0.5;
		}
		return v;
	}

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(1, 1, 0, 2));
		list.add(new SubBlockPos(0, 1, 0, 3));
		list.add(new SubBlockPos(-1, 0, 0, 4));
		list.add(new SubBlockPos(-1, 1, 0, 5));
	}

}
