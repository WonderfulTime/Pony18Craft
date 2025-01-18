package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.WoodDudeEntity;
import software.bernie.geckolib.model.GeoModel;

public class WoodDudeModel extends GeoModel<WoodDudeEntity> {


    @Override
    public Identifier getModelResource(WoodDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/wood_dude_entity.geo.json");
    }

    @Override
    public Identifier getTextureResource(WoodDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/wood_dude_texture.png");
    }

    @Override
    public Identifier getAnimationResource(WoodDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/wood_dude.animation.json");
    }
}
