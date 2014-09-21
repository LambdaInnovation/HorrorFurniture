/**
 * 
 */
package cn.otfurniture.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cn.liutils.api.block.BlockDirectionedMulti;
import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;

/**
 * @author WeathFolD
 *
 */
public class BlockMediumCurtain extends BlockCurtain2 {
	

	public BlockMediumCurtain(int idl) {
		super(idl);
		setBlockName("hf_mcurtain");
		setBlockTextureName("leon:mcurtain" + (id == 0 ? 0 : 1));
	}

	@Override
	public ResourceLocation[] getTextures() {
		return OFClientProps.TEX_MCURTAIN;
	}

	@Override
	public Block getReverse() {
		return OFBlocks.mcurtain[revMatrix[id]];
	}

}
