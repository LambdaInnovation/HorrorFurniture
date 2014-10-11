/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.TileDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * @author FolD
 *
 */
public class BlockKitchenShelf extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileDirectionedMulti {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	final int id;
	
	public BlockKitchenShelf(int i) {
		super(Material.glass);
		id = i;
		setBlockName("hf_kshelf" + i);
		setBlockTextureName("leon:kshelf" + id);
		setCreativeTab(OldTownFurniture.cct);
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
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d;
    	if(dir == 5) return Vec3.createVectorHelper(1, 0, 0);
    	if(dir == 3) return Vec3.createVectorHelper(1, 0, 1);
    	if(dir == 4) return Vec3.createVectorHelper(0, 0, 1);
    	return Vec3.createVectorHelper(0, 0, 0);
    }

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(1, 0, 0, 1));
		list.add(new SubBlockPos(0, 0, 1, 2));
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_KSHELF[id];
	}

}
