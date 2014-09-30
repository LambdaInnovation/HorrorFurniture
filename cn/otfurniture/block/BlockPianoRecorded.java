/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.util.Random;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.otfurniture.block.BlockPianoBase.Tile;
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
		
		public void updateEntity() {
			int meta = this.getBlockMetadata();
			if(meta >> 2 != 2 && meta >> 2 != 3)
				return;
			if((++ticksExisted + offset) % timeTable[id] == 0 && RNG.nextDouble() > 0.6) {
				int[] cd = getOrigin(worldObj, xCoord, yCoord, zCoord, meta);
				if(((Tile)worldObj.getTileEntity(cd[0], cd[1], cd[2])).isPlaying)
					worldObj.spawnParticle("note", (double)xCoord + 0.5D, (double)yCoord + 1.2D, (double)zCoord + 0.5D, (double)(RNG.nextDouble() + .5D) / .5D, 0.0D, 0.0D);
			}
		}
		
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
		setBlockTextureName("leon:piano");
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	//Currently don't support public playing, need to further figure out why
        if (world.isRemote)
        {
        	int meta = world.getBlockMetadata(x, y, z);
        	if(meta >> 2 != 2 && meta >> 2 != 3) return false;
        	
        	int[] crds = this.getOrigin(world, x, y, z, meta);
        	x = crds[0];
        	y = crds[1];
        	z = crds[2];
        	System.out.println(x + " " + y + " " + z);
        	
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
