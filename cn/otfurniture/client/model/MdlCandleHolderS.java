package cn.otfurniture.client.model;

import cn.liutils.api.client.model.ITileEntityModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class MdlCandleHolderS extends ModelBase implements ITileEntityModel {
	// fields
	ModelRenderer bottom1;
	ModelRenderer bottom2;
	ModelRenderer stick;
	ModelRenderer top;
	ModelRenderer candle1;

	public MdlCandleHolderS() {
		textureWidth = 36;
		textureHeight = 13;

		bottom1 = new ModelRenderer(this, 0, 6);
		bottom1.addBox(0F, 0F, 0F, 6, 1, 6);
		bottom1.setRotationPoint(-3F, 23F, -3F);
		bottom1.setTextureSize(36, 13);
		bottom1.mirror = true;
		setRotation(bottom1, 0F, 0F, 0F);
		bottom2 = new ModelRenderer(this, 0, 0);
		bottom2.addBox(0F, -1F, 0F, 4, 2, 4);
		bottom2.setRotationPoint(-2F, 22F, -2F);
		bottom2.setTextureSize(36, 13);
		bottom2.mirror = true;
		setRotation(bottom2, 0F, 0F, 0F);
		stick = new ModelRenderer(this, 12, 0);
		stick.addBox(0F, -2F, 0F, 6, 2, 2);
		stick.setRotationPoint(-1F, 15F, -1F);
		stick.setTextureSize(36, 13);
		stick.mirror = true;
		setRotation(stick, 0F, 0F, 1.58F);
		top = new ModelRenderer(this, 0, 0);
		top.addBox(0F, -1F, 0F, 4, 1, 4);
		top.setRotationPoint(-2F, 15F, -2F);
		top.setTextureSize(36, 13);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		candle1 = new ModelRenderer(this, 18, 4);
		candle1.addBox(0F, -2F, 0F, 4, 2, 2);
		candle1.setRotationPoint(-1F, 10F, -1F);
		candle1.setTextureSize(36, 13);
		candle1.mirror = true;
		setRotation(candle1, 0F, 0F, 1.58F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bottom1.render(f5);
		bottom2.render(f5);
		stick.render(f5);
		top.render(f5);
		candle1.render(f5);
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
		bottom1.render(1F);
		bottom2.render(1F);
		stick.render(1F);
		top.render(1F);
		candle1.render(1F);
	}

	@Override
	public void renderPart(TileEntity te, String name, float f1, float f) {
		throw new UnsupportedOperationException();
	}

}
