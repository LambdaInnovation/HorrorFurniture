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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.block.BlockPiano.Tile;
import cn.otfurniture.register.OFBlocks;

/**
 * @author WeathFolD
 *
 */
public class BlockPianoBase extends BlockDirectionedMulti {

	public static class Tile extends TileEntity {
	}

	public BlockPianoBase() {
		super(Material.iron);
		setCreativeTab(OldTownFurniture.cct);
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
