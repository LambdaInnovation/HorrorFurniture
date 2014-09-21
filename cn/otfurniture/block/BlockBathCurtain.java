/**
 * 
 */
package cn.otfurniture.block;

import cn.otfurniture.proxy.OFClientProps;
import cn.otfurniture.register.OFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * @author WeathFolD
 *
 */
public class BlockBathCurtain extends BlockCurtain2 {
	

	public BlockBathCurtain(int idl) {
		super(idl);
		setBlockName("hf_bcurtain");
		setBlockTextureName("leon:bcurtain" + (id == 0 ? 0 : 1));
	}

	@Override
	public ResourceLocation[] getTextures() {
		return OFClientProps.TEX_BCURTAIN;
	}

	@Override
	public Block getReverse() {
		return OFBlocks.bcurtain[revMatrix[id]];
	}



}
