/**
 * 
 */
package cn.otfurniture.item;

import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author WeathFolD
 *
 */
public class ItemEraser extends Item {

	public ItemEraser() {
		super();
		setCreativeTab(OldTownFurniture.cct);
		setUnlocalizedName("hf_eraser");
		setTextureName("leon:eraser");
		setMaxStackSize(1);
	}
	
    @Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(!world.isRemote) {
    		Investigator.INSTANCE.modifyMessage(world, x, y, z, null);
    	}
        return true;
    }

}
