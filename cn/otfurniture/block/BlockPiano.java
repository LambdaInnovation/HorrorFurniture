/**
 * 
 */
package cn.otfurniture.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.IMetadataProvider;
import cn.liutils.core.LIUtils;
import cn.liutils.core.network.MsgTileDirMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.register.OFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 大量的抄代码
 * @author WeAthFolD
 */
public class BlockPiano extends BlockPianoBase {
	
	public static class Tile extends TileEntityNote implements IMetadataProvider {
		
	    /**
	     * change pitch by -> (currentPitch + 1) % 25
	     */
		@Override
	    public void changePitch()
	    {
	        byte old = note;
	        this.note = (byte)((this.note + 1) % 25);
	    }

	    /**
	     * plays the stored note
	     */
	    @Override
		public void triggerNote(World world, int x, int y, int z)
	    {
	        if (world.getBlock(x, y + 1, z).getMaterial() == Material.air)
	        {
	            Material material = world.getBlock(x, y - 1, z).getMaterial();
	            
	            byte b0 = 0;

	            world.addBlockEvent(x, y, z, OFBlocks.piano, b0, this.note);
	        }
	    }
	    
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
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
				LIUtils.netHandler.sendToServer(new MsgTileDirMulti.Request(this));
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

	public BlockPiano() {
		super();
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_piano");
		setBlockTextureName("leon:piano");
		setHardness(4.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, 0D);
	}
	
    @Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
    {
    	int meta = world.getBlockMetadata(x, y, z) >> 2;
    	if(meta != 2 && meta != 3)
    		return;
        if (!world.isRemote)
        {
            TileEntityNote note = (TileEntityNote)world.getTileEntity(x, y, z);

            if (note != null)
            {
                note.triggerNote(world, x, y, z);
            }
        }
    }
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    @Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z);
        TileEntity te = world.getTileEntity(x, y, z);
        if(te == null || !(te instanceof TileEntityNote))
        	return;
        TileEntityNote tileentitynote = (TileEntityNote)te;
        int meta = world.getBlockMetadata(x, y, z) >> 2;
        if(meta != 3 && meta != 2)
        	return;
        
        if (tileentitynote != null && tileentitynote.previousRedstoneState != flag)
        {
            if (flag)
            {
                tileentitynote.triggerNote(world, x, y, z);
            }

            tileentitynote.previousRedstoneState = flag;
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {										
        	int meta = world.getBlockMetadata(x, y, z) >> 2;
          	if(meta != 3 && meta != 2)
          		return false;
            Tile tileentitynote = (Tile)world.getTileEntity(x, y, z);

            if (tileentitynote != null)
            {
                int old = tileentitynote.note;
                tileentitynote.changePitch();
                //if (old == tileentitynote.note) return false;
		                tileentitynote.triggerNote(world, x, y, z);
		            }

            return true;
        }
    }
    
    @Override
    public boolean onBlockEventReceived(World world, int x, int y, int z, int a, int b)
    {
        int meta = world.getBlockMetadata(x, y, z);
        net.minecraftforge.event.world.NoteBlockEvent.Play 
        	e = new net.minecraftforge.event.world.NoteBlockEvent.Play(world, x, y, z, meta, b, a);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(e)) return false;
        a = e.instrument.ordinal();
        b = e.getVanillaNoteId(); 
        float f = (float)Math.pow(2.0D, (b - 12) / 12.0D);
        String s = "harp";

        if (a == 1)
        {
            s = "bd";
        }

        if (a == 2)
        {
            s = "snare";
        }

        if (a == 3)
        {
            s = "hat";
        }

        if (a == 4)
        {
            s = "bassattack";
        }

        world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, "note." + s, 3.0F, f);
        world.spawnParticle("note", x + 0.5D, y + 1.2D, z + 0.5D, b / 24.0D, 0.0D, 0.0D);
        return true;
    }

}
