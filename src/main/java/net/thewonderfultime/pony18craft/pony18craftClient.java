package net.thewonderfultime.pony18craft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.entity.client.*;
import net.thewonderfultime.pony18craft.entity.custom.SkromnyagaEntity;

public class pony18craftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityRendererRegistry.register(ModEntities.GNOME_COCK_THIEF, GnomeCockThiefRenderer::new);
        EntityRendererRegistry.register(ModEntities.IRON_ORE_DUDE, IronDudeRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKROMNYAGA, SkromnyagaRenderer::new);
        EntityRendererRegistry.register(ModEntities.GNOME, GnomeRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOOD_DUDE, WoodDudeRenderer::new);
        EntityRendererRegistry.register(ModEntities.THROWING_GNOME_PROJECTILE, ThrowingGnomeProjectileRenderer::new);




    }
}
