/**
 * 
 */
package cn.otfurniture.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cn.otfurniture.OldTownFurniture;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class BlockMyDoor extends BlockDoor {
	
	private IIcon iconLower, iconUpper;

	public BlockMyDoor(int i) {
		super(Material.wood);
		setCreativeTab(OldTownFurniture.cct);
		setBlockName("hf_door" + i);
		setBlockTextureName("leon:door" + i);
		
		this.setHardness(3F);
		this.disableStats();
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
    	iconLower = ir.registerIcon(getTextureName() + "_lower");
    	iconUpper = ir.registerIcon(getTextureName() + "_upper");
    }
	
    @Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	return (p_149691_2_ & 8) == 0 ? iconLower : iconUpper;
    }
	
	@Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack)
    {
		int l = (MathHelper.floor_double(placer.rotationYaw * 4.0F / 360.0F + 0.5D) - 1) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 0x03);
		world.setBlock(x, y + 1, z, this, l | 8, 3);
    }
	
    @Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
    	return Item.getItemFromBlock(this);
    }

    @Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int m)
    {
    	int meta = world.getBlockMetadata(x, y, z);
    	return (meta & 8) == 0 ? iconLower : iconUpper;
    }
}
