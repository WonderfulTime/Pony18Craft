package net.thewonderfultime.pony18craft.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.GnomeCockThiefEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GnomeCockThiefModel extends GeoModel<GnomeCockThiefEntity> {
    @Override
    public Identifier getModelResource(GnomeCockThiefEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/gnome_cock_thief.geo.json");
    }

    @Override
    public Identifier getTextureResource(GnomeCockThiefEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/entity/gnome_cock_thief_texture.png");
    }

    @Override
    public Identifier getAnimationResource(GnomeCockThiefEntity animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/gnome_cock_thief.animation.json");
    }


    @Override
    public void setCustomAnimations(GnomeCockThiefEntity animatable, long instanceId, AnimationState<GnomeCockThiefEntity> animationState) {
        /**
         * походу это заставляет существо вертеть голову в разные стороны
         */
        CoreGeoBone head = getAnimationProcessor().getBone("Head");
        CoreGeoBone beard = getAnimationProcessor().getBone("Beard");
        CoreGeoBone hat = getAnimationProcessor().getBone("Hat");
        CoreGeoBone hat_head_beard = getAnimationProcessor().getBone("Hat_Head_Beard");

        if (head != null){

            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            hat_head_beard.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            hat_head_beard.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);

//            beard.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
//            beard.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
//
//            hat.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
//            hat.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);


        }



    }
}
