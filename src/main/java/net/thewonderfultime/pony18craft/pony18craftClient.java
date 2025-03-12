package net.thewonderfultime.pony18craft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.Item.custom.item.totem.MagaTotemItem;
import net.thewonderfultime.pony18craft.Item.custom.item.totem.MagaTotemRenderer;
import net.thewonderfultime.pony18craft.block.ModBlocks;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.entity.client.*;
import net.thewonderfultime.pony18craft.entity.custom.SkromnyagaEntity;
import net.thewonderfultime.pony18craft.particle.ModParticles;
import net.thewonderfultime.pony18craft.particle.PeeParticle;
import net.thewonderfultime.pony18craft.world.custom_events.ClientModEvents;
import software.bernie.geckolib.GeckoLib;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class pony18craftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KHMELI_SUNELI_CROP, RenderLayer.getCutout());

        ModParticles.registerParticles(); // регистрация партиклов

        ClientModEvents.register(); // Регистрируем обработчик клавиш

        ParticleFactoryRegistry.getInstance().register(ModParticles.PEE_PARTICLE, PeeParticle.Factory::new);


        EntityRendererRegistry.register(ModEntities.GNOME_COCK_THIEF, GnomeCockThiefRenderer::new);
        EntityRendererRegistry.register(ModEntities.IRON_ORE_DUDE, IronDudeRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKROMNYAGA, SkromnyagaRenderer::new);
        EntityRendererRegistry.register(ModEntities.GNOME, GnomeRenderer::new);
        EntityRendererRegistry.register(ModEntities.WOOD_DUDE, WoodDudeRenderer::new);
        EntityRendererRegistry.register(ModEntities.THROWING_GNOME_PROJECTILE, ThrowingGnomeProjectileRenderer::new);


//        // Регистрируем рендер кастомного тотема
//        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.MAGA_TOTEM, new MagaTotemRenderer());


        GeckoLib.initialize();
    }
}
