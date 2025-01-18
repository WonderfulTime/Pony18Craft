package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.WoodDudeEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WoodDudeRenderer extends GeoEntityRenderer<WoodDudeEntity> {

    public WoodDudeRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new WoodDudeModel());
    }


    @Override
    public Identifier getTextureLocation(WoodDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/wood_dude_texture.png");
    }


    @Override
    public void render(WoodDudeEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {



        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
