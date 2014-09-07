/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.horniture.HorrorFurniture;
import cn.horniture.proxy.HFClientProps;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author FolD
 *
 */
public class BlockClock extends BlockDirectionedMulti implements ITextureProvider {

	int id;
	
	public BlockClock(int id) {
		super(Material.wood);
		this.id = id;
		setBlockTextureName("leon:clock" + id);
		setBlockName("hf_clock" + id);
		setCreativeTab(HorrorFurniture.cct);
		setHardness(3.0F);
	}

	public static class Tile extends TileEntity {
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public Vec3 getRenderOffset() {
		return null;
	}

	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
		list.add(new SubBlockPos(0, 2, 0, 1));
	}
	
	@SideOnly(Side.CLIENT)
	public Vec3 getOffsetRotated(int dir) {
		  return Vec3.createVectorHelper(.5D, 0D, .5D);
	}

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_CLOCK[id];
	}

}
