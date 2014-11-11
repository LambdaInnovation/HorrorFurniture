/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.util.Random;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.register.OFItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class BlockPianoRecorded extends BlockPianoBase {
	
	private static final int timeTable[] = {
		10
	};
	
	public class Tile extends TileDirectionedMulti {
		
		public boolean isPlaying;
		private int ticksExisted;
		private final Random RNG = new Random();
		private final int offset = RNG.nextInt(200);
		
		@Override
		public void updateEntity() {
			super.updateEntity();
			int meta = this.getBlockMetadata();
			if(meta >> 2 != 2 && meta >> 2 != 3)
				return;
			if((++ticksExisted + offset) % timeTable[id] == 0 && RNG.nextDouble() > 0.6) {
				int[] cd = getOrigin(worldObj, xCoord, yCoord, zCoord, meta);
				Tile te = typesafe(worldObj.getTileEntity(cd[0], cd[1], cd[2]));
				if(te != null && isPlaying)
					worldObj.spawnParticle("note", xCoord + 0.5D, yCoord + 1.2D, zCoord + 0.5D, (RNG.nextDouble() + .5D) / .5D, 0.0D, 0.0D);
			}
		}
		
		private Tile typesafe(TileEntity te) {
			return (Tile) (te instanceof Tile ? te : null);
		}
		
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	    	return INFINITE_EXTENT_AABB;
	    }
		
	}
	
	final int id;
	final ItemRecord recItem;

	public BlockPianoRecorded(int i) {
		id = i;
		recItem = OFItems.dummyPianoPlayback[i];
		setBlockName("pianor" + i);
		setBlockTextureName("leon:pianos");
	}
	
    @Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	//Currently don't support public playing, need to further figure out why
        if (world.isRemote)
        {
        	int meta = getMetadata(world, x, y, z);
        	if(meta >> 2 != 2 && meta >> 2 != 3) return false;
        	
        	int[] crds = this.getOrigin(world, x, y, z, meta);
        	x = crds[0];
        	y = crds[1];
        	z = crds[2];
//        	System.out.println(x + " " + y + " " + z);
        	
        	Tile te = (Tile) world.getTileEntity(x, y, z);

        	world.playAuxSFXAtEntity(null, 1005, x, y, z, te.isPlaying ? 0 : Item.getIdFromItem(recItem));
        	//world.playRecord(te.isPlaying ? "" : "records.otp_" + id, x, y, z);
        	te.isPlaying = !te.isPlaying;
        	
        	return true;
        }
        return false;
    }
    
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

}
