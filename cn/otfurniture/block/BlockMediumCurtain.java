/**
 * 
 */
package cn.otfurniture.block;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
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
