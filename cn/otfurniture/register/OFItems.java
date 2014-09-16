/**
 * 
 */
package cn.otfurniture.register;

import cn.otfurniture.item.*;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 物品统一注册
 * @author WeathFolD
 */
public class OFItems {

	public static Item
		setter;
	
	public static void init() {
		setter = new ItemSetter();
		
		GameRegistry.registerItem(setter, "hf_setter");
	}

}
