package net.thewonderfultime.pony18craft.entity.client;

import net.thewonderfultime.pony18craft.entity.custom.SkromnyagaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.IronOreDudeEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SkromnyagaRenderer extends GeoEntityRenderer<SkromnyagaEntity> {

    public SkromnyagaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SkromnyagaModel());
    }


    @Override
    public Identifier getTextureLocation(SkromnyagaEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/skromnyaga_texture.png");
    }


    @Override
    public void render(SkromnyagaEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {



        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
