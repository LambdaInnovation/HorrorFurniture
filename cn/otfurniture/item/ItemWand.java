/**
 * 
 */
package cn.otfurniture.item;

import cn.otfurniture.OldTownFurniture;
import cn.otfurniture.investigate.Investigator;
import cn.otfurniture.network.MsgOpenGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * @author WeAthFolD
 *
 */
public class ItemWand extends Item {
	
	public ItemWand() {
		super();
		setCreativeTab(OldTownFurniture.cct);
		setUnlocalizedName("hf_wand");
		setTextureName("leon:setter");
		setMaxStackSize(1);
	}
	
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
    	if(world.isRemote)
    		OldTownFurniture.netHandler.sendToServer(new MsgOpenGui.Request(1));
        return true;
    }
}
