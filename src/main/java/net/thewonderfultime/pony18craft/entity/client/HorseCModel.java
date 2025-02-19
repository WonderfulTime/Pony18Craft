package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.entity.custom.HorseCEntity;
import software.bernie.geckolib.model.GeoModel;


public class HorseCModel extends GeoModel<HorseCEntity> {



    @Override
    public Identifier getModelResource(HorseCEntity animatable) {
        return new Identifier("yourmodid", "geo/extra_limb.geo.json");
    }

    @Override
    public Identifier getTextureResource(HorseCEntity animatable) {
        return new Identifier("yourmodid", "textures/entity/extra_limb.png");
    }

    @Override
    public Identifier getAnimationResource(HorseCEntity animatable) {
        return new Identifier("yourmodid", "animations/extra_limb.animation.json");
    }
}
