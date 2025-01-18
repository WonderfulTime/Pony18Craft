package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.GnomeEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GnomeRenderer extends GeoEntityRenderer<GnomeEntity> {

    public GnomeRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GnomeModel());
    }


    @Override
    public Identifier getTextureLocation(GnomeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome_texture.png");
    }


    @Override
    public void render(GnomeEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {



        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
