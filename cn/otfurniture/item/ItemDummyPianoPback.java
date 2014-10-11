/**
 * 
 */
package cn.otfurniture.item;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

/**
 * 钢琴回放会用到的伪唱片物品。
 * @author WeathFolD
 *
 */
public class ItemDummyPianoPback extends ItemRecord {

	public ItemDummyPianoPback(int id) {
		super("otp_" + id);
	}
	
    @Override
	public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation("leon:" + name);
    }

}
