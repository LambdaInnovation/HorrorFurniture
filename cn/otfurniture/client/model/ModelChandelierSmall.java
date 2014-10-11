package cn.otfurniture.client.model;

import cn.liutils.api.client.model.ITileEntityModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelChandelierSmall extends ModelBase implements ITileEntityModel {
	// fields
	ModelRenderer main;
	ModelRenderer light3;

	public ModelChandelierSmall() {
		textureWidth = 32;
		textureHeight = 18;

		main = new ModelRenderer(this, 0, 0);
		main.addBox(0F, 0F, 0F, 2, 9, 2);
		main.setRotationPoint(-1F, 8F, -1F);
		main.setTextureSize(32, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		light3 = new ModelRenderer(this, 8, 0);
		light3.addBox(0F, 0F, 0F, 6, 7, 6);
		light3.setRotationPoint(-3F, 17F, -3F);
		light3.setTextureSize(32, 32);
		light3.mirror = true;
		setRotation(light3, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		main.render(f5);
		light3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void render(TileEntity is, float f1, float f) {
		main.render(1F);
		light3.render(1F);
	}

	@Override
	public void renderPart(TileEntity te, String name, float f1, float f) {
	}

}
