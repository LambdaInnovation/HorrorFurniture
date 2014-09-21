/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.register.OFBlocks;

/**
 * 大量的抄代码
 * @author WeAthFolD
 */
public class BlockPiano extends BlockDirectionedMulti {
	
	public static class Tile extends TileEntityNote {
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
	    public void triggerNote(World world, int x, int y, int z)
	    {
	        if (world.getBlock(x, y + 1, z).getMaterial() == Material.air)
	        {
	            Material material = world.getBlock(x, y - 1, z).getMaterial();
	            
	            byte b0 = 0;

	            world.addBlockEvent(x, y, z, OFBlocks.piano, b0, this.note);
	        }
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	/**
	 * @param mat
	 */
	public BlockPiano() {
		super(Material.iron);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_piano");
		setBlockTextureName("leon:piano");
		setHardness(4.0F);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(0D, 0D, 0D);
	}
	
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
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        boolean flag = world.isBlockIndirectlyGettingPowered(x, y, z);
        TileEntityNote tileentitynote = (TileEntityNote)world.getTileEntity(x, y, z);
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
        float f = (float)Math.pow(2.0D, (double)(b - 12) / 12.0D);
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

        world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "note." + s, 3.0F, f);
        world.spawnParticle("note", (double)x + 0.5D, (double)y + 1.2D, (double)z + 0.5D, (double)b / 24.0D, 0.0D, 0.0D);
        return true;
    }
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d;
    	if(dir == 5) return Vec3.createVectorHelper(1, 0, 0);
    	if(dir == 3) return Vec3.createVectorHelper(1, 0, 1);
    	if(dir == 4) return Vec3.createVectorHelper(0, 0, 1);
    	return Vec3.createVectorHelper(0, 0, 0);
    }

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(1, 0, 1, 2));
		list.add(new SubBlockPos(0, 0, 1, 3));
		list.add(new SubBlockPos(0, 1, 0, 4));
		list.add(new SubBlockPos(1, 1, 0, 5));
	}

}
