/**
 * 
 */
package cn.otfurniture.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
/**
 * @author WeAthFolD
 *
 */
public class BlockKitchenShelfSmall extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity { }
	
	final int id;

	public BlockKitchenShelfSmall(int i) {
		super(Material.wood);
		id = i;
		setBlockName("hf_ksshelf" + i);
		setBlockTextureName("leon:ksshelf" + i);
		setCreativeTab(OldTownFurniture.cct);
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
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(.5, 0, .5);
    }

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_KSSHELF[id];
	}

}
