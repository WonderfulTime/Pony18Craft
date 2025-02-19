//package net.thewonderfultime.pony18craft.entity.client;
//
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.render.entity.EntityRendererFactory;
//import net.minecraft.client.render.entity.HorseEntityRenderer;
//
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.passive.HorseEntity;
//import net.minecraft.util.Identifier;
//
//public class CustomHorseRenderer extends HorseEntityRenderer {
//    private final HorseCRenderer extraLimbRenderer;
//
//    public CustomHorseRenderer(EntityRendererFactory.Context ctx) {
//        super(ctx);
//        this.extraLimbRenderer = new HorseCRenderer(ctx);
//    }
//
//    @Override
//    public void render(HorseEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//        // Рендерим стандартную модель лошади
//        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
//
//        // Рендерим дополнительную конечность
//        matrices.push();
//        {
//            // Позиционируем конечность относительно модели лошади
//            matrices.translate(0.5, 1.0, 0.0); // Пример: смещаем конечность вправо и вверх
//            matrices.scale(1.0F, 1.0F, 1.0F); // Масштабируем конечность (если нужно)
//
//            // Рендерим конечность
//            this.extraLimbRenderer.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
//        }
//        matrices.pop();
//    }
//}
