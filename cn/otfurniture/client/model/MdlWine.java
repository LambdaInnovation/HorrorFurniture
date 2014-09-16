package cn.otfurniture.client.model;

import cn.liutils.api.client.model.ITileEntityModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class MdlWine extends ModelBase implements ITileEntityModel {
	// fields
	ModelRenderer bottle1;
	ModelRenderer bottle2;

	public MdlWine() {
		textureWidth = 16;
		textureHeight = 14;

		bottle1 = new ModelRenderer(this, 0, 0);
		bottle1.addBox(0F, 22F, 0F, 4, 10, 4);
		bottle1.setRotationPoint(-2F, -8F, -2F);
		bottle1.setTextureSize(16, 14);
		bottle1.mirror = true;
		setRotation(bottle1, 0F, 0F, 0F);
		bottle2 = new ModelRenderer(this, 4, 7);
		bottle2.addBox(0F, 0F, 0F, 2, 5, 2);
		bottle2.setRotationPoint(-1F, 9F, -1F);
		bottle2.setTextureSize(16, 14);
		bottle2.mirror = true;
		setRotation(bottle2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bottle1.render(f5);
		bottle2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5) {
	}

	@Override
	public void render(TileEntity is, float f1, float f) {
		bottle1.render(1F);
		bottle2.render(1F);
	}

	@Override
	public void renderPart(TileEntity te, String name, float f1, float f) {
		throw new UnsupportedOperationException();
	}

}
