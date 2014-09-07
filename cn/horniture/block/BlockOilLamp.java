/**
 * 
 */
package cn.horniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.horniture.HorrorFurniture;
import cn.horniture.proxy.HFClientProps;
import cn.horniture.register.HFBlocks;
import cn.liutils.api.block.BlockDirectionedMulti;

/**
 * @author FolD
 *
 */
public class BlockOilLamp extends BlockDirectionedMulti implements
		ITextureProvider {
	
	public static class Tile extends TileEntity {
		
	}

	final int lit;
	
	/**
	 * @param mat
	 */
	public BlockOilLamp(boolean b) {
		super(Material.iron);
		lit = b ? 1 : 0;
		if(lit == 1) this.setLightLevel(2.0F);
		this.useRotation = false;
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_oillamp" + lit);
		setBlockTextureName("leon:oillamp" + lit);
		setBlockBounds(.4F, 0F, .4F, .6F, 1F, .6F);
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}

	/* (non-Javadoc)
	 * @see cn.horniture.block.ITextureProvider#getTexture()
	 */
	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_OILLAMP[lit];
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        if(lit == 0) super.getSubBlocks(p_149666_1_, p_149666_2_, p_149666_3_);
    }

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#getRenderOffset()
	 */
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

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
	}
	
	 private Block getReversal() {
		 return HFBlocks.oillamp[lit == 0 ? 1 : 0];
	 }

}
