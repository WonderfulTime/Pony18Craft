package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.GnomeCockThiefEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GnomeCockThiefRenderer extends GeoEntityRenderer<GnomeCockThiefEntity> {


    public GnomeCockThiefRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GnomeCockThiefModel());
    }


    @Override
    public Identifier getTextureLocation(GnomeCockThiefEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome_cock_thief_texture.png");
    }


    @Override
    public void render(GnomeCockThiefEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        if (entity.isBaby()){

            poseStack.scale(0.7f, 0.7f, 0.7f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
