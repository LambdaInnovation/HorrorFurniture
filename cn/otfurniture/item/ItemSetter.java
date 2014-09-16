/**
 * 
 */
package cn.otfurniture.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.network.MsgInvsOpenGui;


/**
 * @author WeAthFolD
 *
 */
public class ItemSetter extends Item {
	
	public ItemSetter() {
		super();
		setCreativeTab(OldTownFurniture.cct);
		setUnlocalizedName("hf_wand");
		setTextureName("leon:setter");
		setMaxStackSize(1);
	}
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(!world.isRemote) {
    		String str = Investigator.INSTANCE.getMessage(world, x, y, z);
        	if(str == null) str = "";
    		OldTownFurniture.netHandler.sendTo(new MsgInvsOpenGui(str, x, y, z), (EntityPlayerMP) player);
    	}
        return true;
    }
}
