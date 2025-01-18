package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.ThrowingGnomeProjectileEntity;
import software.bernie.geckolib.model.GeoModel;

public class ThrowingGnomeProjectileModel extends GeoModel<ThrowingGnomeProjectileEntity> {

    @Override
    public Identifier getModelResource(ThrowingGnomeProjectileEntity entity) {
        return new Identifier(Pony18craft.MOD_ID, "geo/gnome.geo.json");
    }

    @Override
    public Identifier getTextureResource(ThrowingGnomeProjectileEntity entity) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome.png");
    }

    @Override
    public Identifier getAnimationResource(ThrowingGnomeProjectileEntity entity) {
        return new Identifier(Pony18craft.MOD_ID, "animations/gnome.animation.json");
    }
}
