/**
 * 
 */
package cn.otfurniture.register;

import cn.otfurniture.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 物品统一注册
 * @author WeathFolD
 */
public class OFItems {

	public static Item
		setter;
	public static ItemRecord dummyPianoPlayback[];
	
	public static void init() {
		setter = new ItemSetter();
		
		dummyPianoPlayback = new ItemRecord[1];
		for(int i = 0; i < 1; i++) {
			dummyPianoPlayback[i] = new ItemDummyPianoPback(i);
			GameRegistry.registerItem(dummyPianoPlayback[i], "hf_pback" + i);
		}
		
		GameRegistry.registerItem(setter, "hf_setter");
	}

}
