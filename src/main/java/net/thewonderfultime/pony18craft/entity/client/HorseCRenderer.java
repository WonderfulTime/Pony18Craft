package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.thewonderfultime.pony18craft.entity.custom.HorseCEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HorseCRenderer  extends GeoEntityRenderer<HorseCEntity> {
    public HorseCRenderer(EntityRendererFactory.Context renderManager, GeoModel<HorseCEntity> model) {
        super(renderManager, model);
    }
}
