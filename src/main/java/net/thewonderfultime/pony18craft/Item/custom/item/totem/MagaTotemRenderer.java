package net.thewonderfultime.pony18craft.Item.custom.item.totem;

import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MagaTotemRenderer extends GeoItemRenderer<MagaTotemItem>  {
    public MagaTotemRenderer() {
        super(new MagaTotemModel());
    }
}
