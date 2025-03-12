package net.thewonderfultime.pony18craft.Item.custom.item.totem;


import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import software.bernie.geckolib.model.GeoModel;
public class MagaTotemModel extends GeoModel<MagaTotemItem>{
    @Override
    public Identifier getModelResource(MagaTotemItem animatable) {
        return new Identifier(Pony18craft.MOD_ID, "geo/maga_totem.geo.json");
    }

    @Override
    public Identifier getTextureResource(MagaTotemItem animatable) {
        return new Identifier(Pony18craft.MOD_ID, "textures/item/maga_totem_texture.png");
    }

    @Override
    public Identifier getAnimationResource(MagaTotemItem animatable) {
        return new Identifier(Pony18craft.MOD_ID, "animations/maga_totem.animation.json");
    }
}
