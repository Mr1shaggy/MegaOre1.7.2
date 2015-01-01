
/*package com.main.mod;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCrucible extends ModelBlock
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Bottom;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer Side3;
    ModelRenderer Side4;
  
  public ModelCrucible()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(0F, 0F, 0F, 2, 2, 2);
      Leg1.setRotationPoint(-8F, 22F, -8F);
      Leg1.setTextureSize(128, 128);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(0F, 0F, 0F, 2, 2, 2);
      Leg2.setRotationPoint(6F, 22F, -8F);
      Leg2.setTextureSize(128, 128);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 0, 0);
      Leg3.addBox(0F, 0F, 0F, 2, 2, 2);
      Leg3.setRotationPoint(-8F, 22F, 6F);
      Leg3.setTextureSize(128, 128);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 0);
      Leg4.addBox(0F, 0F, 0F, 2, 2, 2);
      Leg4.setRotationPoint(6F, 22F, 6F);
      Leg4.setTextureSize(128, 128);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Bottom = new ModelRenderer(this, 10, 1);
      Bottom.addBox(0F, 0F, 0F, 16, 1, 16);
      Bottom.setRotationPoint(-8F, 21F, -8F);
      Bottom.setTextureSize(128, 128);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Side1 = new ModelRenderer(this, 0, 40);
      Side1.addBox(0F, 0F, 0F, 16, 16, 2);
      Side1.setRotationPoint(-8F, 5F, -8F);
      Side1.setTextureSize(128, 128);
      Side1.mirror = true;
      setRotation(Side1, 0F, 0F, 0F);
      Side2 = new ModelRenderer(this, 0, 19);
      Side2.addBox(0F, 0F, 0F, 16, 16, 2);
      Side2.setRotationPoint(-8F, 5F, 6F);
      Side2.setTextureSize(128, 128);
      Side2.mirror = true;
      setRotation(Side2, 0F, 0F, 0F);
      Side3 = new ModelRenderer(this, 37, 19);
      Side3.addBox(0F, 0F, 0F, 2, 16, 12);
      Side3.setRotationPoint(-8F, 5F, -6F);
      Side3.setTextureSize(128, 128);
      Side3.mirror = true;
      setRotation(Side3, 0F, 0F, 0F);
      Side4 = new ModelRenderer(this, 68, 19);
      Side4.addBox(0F, 0F, 0F, 2, 16, 12);
      Side4.setRotationPoint(6F, 5F, -6F);
      Side4.setTextureSize(128, 128);
      Side4.mirror = true;
      setRotation(Side4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Bottom.render(f5);
    Side1.render(f5);
    Side2.render(f5);
    Side3.render(f5);
    Side4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
*/