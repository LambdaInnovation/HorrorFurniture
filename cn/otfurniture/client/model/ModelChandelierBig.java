package cn.otfurniture.client.model;

import cn.liutils.api.client.model.ITileEntityModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

/**
 * @author WeathFolD
 * @author 二目猫
 */
public class ModelChandelierBig extends ModelBase implements ITileEntityModel {
	
	ModelRenderer main;
	ModelRenderer branch1;
	ModelRenderer branch2;
	ModelRenderer branch3;
	ModelRenderer branch4;
	ModelRenderer branch11;
	ModelRenderer branch21;
	ModelRenderer branch31;
	ModelRenderer branch41;
	ModelRenderer light1;
	ModelRenderer light2;
	ModelRenderer light4;
	ModelRenderer light3;

	public ModelChandelierBig() {
		textureWidth = 32;
		textureHeight = 18;

		main = new ModelRenderer(this, 0, 0);
		main.addBox(0F, 0F, 0F, 2, 16, 2);
		main.setRotationPoint(7F, 8F, 7F);
		main.setTextureSize(32, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		branch1 = new ModelRenderer(this, 0, 0);
		branch1.addBox(0F, 0F, 0F, 2, 13, 2);
		branch1.setRotationPoint(7F, 24F, 7F);
		branch1.setTextureSize(32, 32);
		branch1.mirror = true;
		setRotation(branch1, 1.58F, -1.58F, 0F);
		branch2 = new ModelRenderer(this, 0, 0);
		branch2.addBox(0F, 0F, 0F, 2, 13, 2);
		branch2.setRotationPoint(7F, 24F, 9F);
		branch2.setTextureSize(32, 32);
		branch2.mirror = true;
		setRotation(branch2, 1.58F, 0F, 0F);
		branch3 = new ModelRenderer(this, 0, 0);
		branch3.addBox(0F, 0F, 0F, 2, 13, 2);
		branch3.setRotationPoint(9F, 24F, 9F);
		branch3.setTextureSize(32, 32);
		branch3.mirror = true;
		setRotation(branch3, 1.58F, 1.58F, 0F);
		branch4 = new ModelRenderer(this, 0, 0);
		branch4.addBox(0F, 0F, 0F, 2, 13, 2);
		branch4.setRotationPoint(9F, 24F, 7F);
		branch4.setTextureSize(32, 32);
		branch4.mirror = true;
		setRotation(branch4, 1.58F, 3.16F, 0F);
		branch11 = new ModelRenderer(this, 0, 0);
		branch11.addBox(0F, 0F, 0F, 2, 8, 2);
		branch11.setRotationPoint(-8F, 16F, 7F);
		branch11.setTextureSize(32, 32);
		branch11.mirror = true;
		setRotation(branch11, 0F, 0F, 0F);
		branch21 = new ModelRenderer(this, 0, 0);
		branch21.addBox(0F, 0F, 0F, 2, 8, 2);
		branch21.setRotationPoint(7F, 16F, 22F);
		branch21.setTextureSize(32, 32);
		branch21.mirror = true;
		setRotation(branch21, 0F, 0F, 0F);
		branch31 = new ModelRenderer(this, 0, 0);
		branch31.addBox(0F, 0F, 0F, 2, 8, 2);
		branch31.setRotationPoint(22F, 16F, 7F);
		branch31.setTextureSize(32, 32);
		branch31.mirror = true;
		setRotation(branch31, 0F, 0F, 0F);
		branch41 = new ModelRenderer(this, 0, 0);
		branch41.addBox(0F, 0F, 0F, 2, 8, 2);
		branch41.setRotationPoint(7F, 16F, -8F);
		branch41.setTextureSize(32, 32);
		branch41.mirror = true;
		setRotation(branch41, 0F, 0F, 0F);
		light1 = new ModelRenderer(this, 8, 0);
		light1.addBox(0F, 0F, 0F, 6, 7, 6);
		light1.setRotationPoint(-7F, 15F, 5F);
		light1.setTextureSize(32, 32);
		light1.mirror = true;
		setRotation(light1, 0F, 0F, 0F);
		light2 = new ModelRenderer(this, 8, 0);
		light2.addBox(0F, 0F, 0F, 6, 7, 6);
		light2.setRotationPoint(5F, 15F, 17F);
		light2.setTextureSize(32, 32);
		light2.mirror = true;
		setRotation(light2, 0F, 0F, 0F);
		light4 = new ModelRenderer(this, 8, 0);
		light4.addBox(0F, 0F, 0F, 6, 7, 6);
		light4.setRotationPoint(5F, 15F, -7F);
		light4.setTextureSize(32, 32);
		light4.mirror = true;
		setRotation(light4, 0F, 0F, 0F);
		light3 = new ModelRenderer(this, 8, 0);
		light3.addBox(0F, 0F, 0F, 6, 7, 6);
		light3.setRotationPoint(17F, 15F, 5F);
		light3.setTextureSize(32, 32);
		light3.mirror = true;
		setRotation(light3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		main.render(f5);
		branch1.render(f5);
		branch2.render(f5);
		branch3.render(f5);
		branch4.render(f5);
		branch11.render(f5);
		branch21.render(f5);
		branch31.render(f5);
		branch41.render(f5);
		light1.render(f5);
		light2.render(f5);
		light4.render(f5);
		light3.render(f5);
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
		
		main.render(1.0F);
		branch1.render(1.0F);
		branch2.render(1.0F);
		branch3.render(1.0F);
		branch4.render(1.0F);
		branch11.render(1.0F);
		branch21.render(1.0F);
		branch31.render(1.0F);
		branch41.render(1.0F);
		light1.render(1.0F);
		light2.render(1.0F);
		light4.render(1.0F);
		light3.render(1.0F);
	}

	@Override
	public void renderPart(TileEntity te, String name, float f1, float f) {
	}

}
