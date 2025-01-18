package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.GnomeEntity;
import net.thewonderfultime.pony18craft.entity.custom.SkromnyagaEntity;
import software.bernie.geckolib.model.GeoModel;

public class GnomeModel extends GeoModel<GnomeEntity> {


    @Override
    public Identifier getModelResource(GnomeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/gnome.geo.json");
    }

    @Override
    public Identifier getTextureResource(GnomeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome_texture.png");
    }

    @Override
    public Identifier getAnimationResource(GnomeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/gnome.animation.json");
    }
}
