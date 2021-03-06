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
 * @author FolD
 *
 */
public class BlockKitchenSink extends BlockDirectionedMulti implements ITextureProvider {

	int id;
	
	public static class Tile extends TileEntity {
	}
	
	public BlockKitchenSink(int id) {
		super(Material.wood);
		this.id = id;
		setBlockName("hf_ksink" + id);
		setBlockTextureName("leon:ksink" + id);
		setCreativeTab(OldTownFurniture.cct);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	return Vec3.createVectorHelper(0.5D, 0D, 0.5D);
    }

	@Override
	public Vec3 getRenderOffset() {
		return null;
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_KSINK[id];
	}

}
