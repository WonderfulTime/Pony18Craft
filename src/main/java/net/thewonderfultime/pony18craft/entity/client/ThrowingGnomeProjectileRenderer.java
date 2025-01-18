package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.RotationAxis;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.ThrowingGnomeProjectileEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThrowingGnomeProjectileRenderer extends GeoEntityRenderer<ThrowingGnomeProjectileEntity> {

    public ThrowingGnomeProjectileRenderer(EntityRendererFactory.Context context) {
        super(context, new ThrowingGnomeProjectileModel());
    }

    @Override
    public Identifier getTextureLocation(ThrowingGnomeProjectileEntity entity) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome_texture.png");
    }

//    @Override
//    public void render(ThrowingGnomeProjectileEntity entity, float entityYaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
//        // Поворот на 90 градусов по оси Y
//        matrixStack.push();
//        matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90)); // Поворот на 90 градусов
//        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90)); // Поворот на 90 градусов
//        super.render(entity, entityYaw, tickDelta, matrixStack, vertexConsumerProvider, light);
//        matrixStack.pop();
//    }


    public int getRenderDistance() {
        return 400; // Устанавливаем большую дистанцию рендеринга
    }
}
