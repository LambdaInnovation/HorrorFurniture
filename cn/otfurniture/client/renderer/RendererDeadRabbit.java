/**
 * 
 */
package cn.otfurniture.client.renderer;

import cn.liutils.api.client.render.RenderDirMultiModelled;
import cn.otfurniture.client.model.ModelDeadRabbit;
import cn.otfurniture.proxy.OFClientProps;

/**
 * @author WeathFolD
 *
 */
public class RendererDeadRabbit extends RenderDirMultiModelled {

	/**
	 * @param mdl
	 */
	public RendererDeadRabbit() {
		super(new ModelDeadRabbit());
		this.setTechne(true);
		this.setOffset(0.5, 1.5, 0.5);
		this.setModelTexture(OFClientProps.TEX_DEAD_RABBIT);
	}

}
