/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.client.ITextureProvider;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author FolD
 *
 */
public class BlockOilLamp extends BlockDirectionedMulti implements
		ITextureProvider {
	
	public static class Tile extends TileEntity {
	    @Override
		@SideOnly(Side.CLIENT)
	    public AxisAlignedBB getRenderBoundingBox()
	    {
	        return INFINITE_EXTENT_AABB;
	    }
	}

	final int lit;
	
	public BlockOilLamp(int i) {
		super(Material.iron);
		lit = i;
		if(lit == 1) this.setLightLevel(2.0F);
		this.useRotation = false;
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_oillamp" + lit);
		setBlockTextureName("leon:oillamp");
		setBlockBounds(.4F, 0F, .4F, .6F, 1F, .6F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	@Override
	public ResourceLocation getTexture() {
		return OFClientProps.TEX_OILLAMP[lit];
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if(lit == 0) super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
    }

	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(.5, 0.0, .5);
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	world.setBlock(x, y, z, getReversal());
        return true;
    }
	
	 private Block getReversal() {
		 return OFBlocks.oillamp[lit == 0 ? 1 : 0];
	 }

}
