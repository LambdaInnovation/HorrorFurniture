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
import cn.horniture.block.BlockOilLamp.Tile;
import cn.horniture.proxy.HFClientProps;
import cn.horniture.register.HFBlocks;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.liutils.api.block.BlockDirectionedMulti.SubBlockPos;

/**
 * @author FolD
 *
 */
public class BlockHanger extends BlockDirectionedMulti implements ITextureProvider {

	public static class Tile extends TileEntity {
		
	}
	/**
	 * @param mat
	 */
	public BlockHanger() {
		super(Material.wood);
		this.useRotation = false;
		setCreativeTab(HorrorFurniture.cct);
		setBlockName("hf_hanger");
		setBlockTextureName("leon:hanger");
	}

	/* (non-Javadoc)
	 * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
	 */
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new Tile();
	}
	
	@Override
	public ResourceLocation getTexture() {
		return HFClientProps.TEX_HANGER;
	}
	
	@Override
	public Vec3 getRenderOffset() {
		return Vec3.createVectorHelper(.5, 0.0, .5);
	}

	/* (non-Javadoc)
	 * @see cn.liutils.api.block.BlockDirectionedMulti#addSubBlocks(java.util.List)
	 */
	@Override
	public void addSubBlocks(List<SubBlockPos> list) {
		list.add(new SubBlockPos(0, 1, 0, 1));
		list.add(new SubBlockPos(0, 2, 0, 1));
	}

}