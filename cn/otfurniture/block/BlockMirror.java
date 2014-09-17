/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeathFolD
 *
 */
public class BlockMirror extends BlockDirectionedMulti implements ITextureProvider {
	
	public static class Tile extends TileEntity {
		
	}

	public final int id;
	
	public BlockMirror(int i) {
		super(Material.glass);
		id = i;
		this.setStepSound(soundTypeGlass);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_mirror" + i);
		setBlockTextureName("leon:hf_mirror");
	}
	
    @SideOnly(Side.CLIENT)
    public Vec3 getOffsetRotated(int dir) {
    	ForgeDirection d = ForgeDirection.values()[dir];
    	double a = 0.98, b = 0.02;
    	if(dir == 2)
    		return makeV(0, 0, a);
    	if(dir == 3)
    		return makeV(1, 0, b);
    	if(dir == 4)
    		return makeV(a, 0, 1);
    	return makeV(0, 0, 0);
    }
    
    private Vec3 makeV(double a, double b, double c) {
    	return Vec3.createVectorHelper(a, b, c);
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
		list.add(new SubBlockPos(1, 1, 0, 2));
		list.add(new SubBlockPos(1, 0, 0, 3));
	}
	
	private int sgn(int x) {
		return x == 0 ? 0 : x > 0 ? 1 : -1;
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_MIRROR[id];
	}

}
