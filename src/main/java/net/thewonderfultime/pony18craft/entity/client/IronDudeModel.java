package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.IronOreDudeEntity;
import software.bernie.geckolib.model.GeoModel;


public class IronDudeModel extends GeoModel<IronOreDudeEntity>{

    @Override
    public Identifier getModelResource(IronOreDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/iron_ore_dude.geo.json");
    }

    @Override
    public Identifier getTextureResource(IronOreDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/iron_ore_texture.png");
    }

    @Override
    public Identifier getAnimationResource(IronOreDudeEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/iron_ore_dude.animation.json");
    }





}
