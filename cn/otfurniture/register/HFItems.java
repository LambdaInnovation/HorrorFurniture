/**
 * 
 */
package cn.otfurniture.register;

import cn.otfurniture.item.*;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @author WeathFolD
 *
 */
public class HFItems {

	public static Item
		setter;
	
	public static void init() {
		setter = new ItemWand();
		
		GameRegistry.registerItem(setter, "hf_setter");
	}

}
