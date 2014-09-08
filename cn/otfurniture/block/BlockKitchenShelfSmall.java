/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.HFClientProps;

/**
 * @author WeAthFolD
 *
 */
public class BlockKitchenShelfSmall extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
		
	}
	
	final int id;

	public BlockKitchenShelfSmall(int i) {
		super(Material.wood);
		id = i;
		setBlockName("hf_ksshelf" + i);
		setBlockTextureName("leon:ksshelf" + i);
		setCreativeTab(OldTownFurniture.cct);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
	@Override
	public Vec3 getRenderOffset() {
		return null;
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(.5, 0, .5);
    }


	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
	}

	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_KSSHELF[id];
	}

}
