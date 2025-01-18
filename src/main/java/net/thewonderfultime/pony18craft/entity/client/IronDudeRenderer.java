package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.IronOreDudeEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IronDudeRenderer extends GeoEntityRenderer<IronOreDudeEntity> {

    public IronDudeRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new IronDudeModel());
    }


    @Override
    public Identifier getTextureLocation(IronOreDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/iron_ore_texture.png");
    }


    @Override
    public void render(IronOreDudeEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {



        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
