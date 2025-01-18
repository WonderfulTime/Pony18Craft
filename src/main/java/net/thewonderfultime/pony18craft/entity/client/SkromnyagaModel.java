package net.thewonderfultime.pony18craft.entity.client;


import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.IronOreDudeEntity;
import software.bernie.geckolib.constant.DataTickets;

import software.bernie.geckolib.core.animatable.model.CoreGeoBone;

import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import net.thewonderfultime.pony18craft.entity.custom.SkromnyagaEntity;


public class SkromnyagaModel extends GeoModel<SkromnyagaEntity> {


    @Override
    public Identifier getModelResource(SkromnyagaEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/skromnyaga.geo.json");
    }

    @Override
    public Identifier getTextureResource(SkromnyagaEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/skromnyaga_texture.png");
    }

    @Override
    public Identifier getAnimationResource(SkromnyagaEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/skromnyaga.animation.json");
    }
}
