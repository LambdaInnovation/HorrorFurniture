package cn.otfurniture.client.model;

import cn.liutils.api.client.model.ITileEntityModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class MdlCandleHolderL extends ModelBase implements ITileEntityModel {
	// fields
	ModelRenderer bottom1;
	ModelRenderer bottom2;
	ModelRenderer stick1;
	ModelRenderer stick2;
	ModelRenderer stick3;
	ModelRenderer stick4;
	ModelRenderer stick5;
	ModelRenderer stick6;
	ModelRenderer top1;
	ModelRenderer top2;
	ModelRenderer top3;
	ModelRenderer candle1;
	ModelRenderer candle2;
	ModelRenderer candle3;

	public MdlCandleHolderL() {
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
		stick1 = new ModelRenderer(this, 12, 0);
		stick1.addBox(0F, -2F, 0F, 6, 2, 2);
		stick1.setRotationPoint(-1F, 15F, -1F);
		stick1.setTextureSize(36, 13);
		stick1.mirror = true;
		setRotation(stick1, 0F, 0F, 1.58F);
		stick2 = new ModelRenderer(this, 12, 0);
		stick2.addBox(0F, -2F, 0F, 6, 2, 2);
		stick2.setRotationPoint(-1F, 9F, -1F);
		stick2.setTextureSize(36, 13);
		stick2.mirror = true;
		setRotation(stick2, 0F, 0F, 1.58F);
		stick3 = new ModelRenderer(this, 12, 0);
		stick3.addBox(0F, -2F, 0F, 4, 2, 2);
		stick3.setRotationPoint(1F, 15F, -1F);
		stick3.setTextureSize(36, 13);
		stick3.mirror = true;
		setRotation(stick3, 0F, 0F, 0F);
		stick4 = new ModelRenderer(this, 12, 0);
		stick4.addBox(0F, -2F, 0F, 4, 2, 2);
		stick4.setRotationPoint(-1F, 13F, -1F);
		stick4.setTextureSize(36, 13);
		stick4.mirror = true;
		setRotation(stick4, 0F, 0F, 3.16F);
		stick5 = new ModelRenderer(this, 12, 0);
		stick5.addBox(0F, -2F, 0F, 6, 2, 2);
		stick5.setRotationPoint(-7F, 9F, -1F);
		stick5.setTextureSize(36, 13);
		stick5.mirror = true;
		setRotation(stick5, 0F, 0F, 1.58F);
		stick6 = new ModelRenderer(this, 12, 0);
		stick6.addBox(0F, -2F, 0F, 6, 2, 2);
		stick6.setRotationPoint(5F, 9F, -1F);
		stick6.setTextureSize(36, 13);
		stick6.mirror = true;
		setRotation(stick6, 0F, 0F, 1.58F);
		top1 = new ModelRenderer(this, 0, 0);
		top1.addBox(0F, -1F, 0F, 4, 2, 4);
		top1.setRotationPoint(-2F, 8F, -2F);
		top1.setTextureSize(36, 13);
		top1.mirror = true;
		setRotation(top1, 0F, 0F, 0F);
		top2 = new ModelRenderer(this, 0, 0);
		top2.addBox(0F, -1F, 0F, 4, 1, 4);
		top2.setRotationPoint(-8F, 9F, -2F);
		top2.setTextureSize(36, 13);
		top2.mirror = true;
		setRotation(top2, 0F, 0F, 0F);
		top3 = new ModelRenderer(this, 0, 0);
		top3.addBox(0F, -1F, 0F, 4, 1, 4);
		top3.setRotationPoint(4F, 9F, -2F);
		top3.setTextureSize(36, 13);
		top3.mirror = true;
		setRotation(top3, 0F, 0F, 0F);
		candle1 = new ModelRenderer(this, 18, 4);
		candle1.addBox(0F, -2F, 0F, 4, 2, 2);
		candle1.setRotationPoint(-1F, 3F, -1F);
		candle1.setTextureSize(36, 13);
		candle1.mirror = true;
		setRotation(candle1, 0F, 0F, 1.58F);
		candle2 = new ModelRenderer(this, 18, 4);
		candle2.addBox(0F, -2F, 0F, 4, 2, 2);
		candle2.setRotationPoint(-7F, 4F, -1F);
		candle2.setTextureSize(36, 13);
		candle2.mirror = true;
		setRotation(candle2, 0F, 0F, 1.58F);
		candle3 = new ModelRenderer(this, 18, 4);
		candle3.addBox(0F, -8F, 0F, 4, 2, 2);
		candle3.setRotationPoint(-1F, 4F, -1F);
		candle3.setTextureSize(36, 13);
		candle3.mirror = true;
		setRotation(candle3, 0F, 0F, 1.58F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bottom1.render(f5);
		bottom2.render(f5);
		stick1.render(f5);
		stick2.render(f5);
		stick3.render(f5);
		stick4.render(f5);
		stick5.render(f5);
		stick6.render(f5);
		top1.render(f5);
		top2.render(f5);
		top3.render(f5);
		candle1.render(f5);
		candle2.render(f5);
		candle3.render(f5);
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
		float f5 = 1.0F;
		bottom1.render(f5);
		bottom2.render(f5);
		stick1.render(f5);
		stick2.render(f5);
		stick3.render(f5);
		stick4.render(f5);
		stick5.render(f5);
		stick6.render(f5);
		top1.render(f5);
		top2.render(f5);
		top3.render(f5);
		candle1.render(f5);
		candle2.render(f5);
		candle3.render(f5);
	}

	@Override
	public void renderPart(TileEntity te, String name, float f1, float f) {
		throw new UnsupportedOperationException();
	}

}
