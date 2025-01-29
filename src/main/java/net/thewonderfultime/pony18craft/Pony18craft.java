package net.thewonderfultime.pony18craft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.Item.TooltipRegistry;
import net.thewonderfultime.pony18craft.block.ModBlocks;
import net.thewonderfultime.pony18craft.effects.ModEffects;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.entity.custom.*;
import net.thewonderfultime.pony18craft.painting.ModPaintings;
import net.thewonderfultime.pony18craft.world.custom_events.ModBlockBreakHandler;
import net.thewonderfultime.pony18craft.world.custom_events.PlayerSizeHandler;
import net.thewonderfultime.pony18craft.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pony18craft implements ModInitializer {

	public static final String MOD_ID = "pony18craft";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		System.out.println("[DEBUG] Initializing Pony18Craft mod...");
		System.out.println("[DEBUG] Trinkets API is loaded: " + FabricLoader.getInstance().isModLoaded("trinkets"));

		ModItems.register();
		ModBlocks.register();

		ModPaintings.registerPaintings();

		ModWorldGeneration.generateModWorldGen();

		TooltipRegistry.initialize();

		ModEffects.registerModEffects();

		ModBlockBreakHandler.register();

		PlayerSizeHandler.register(); // Запускаем логику изменения хитбокса

		FabricDefaultAttributeRegistry.register(ModEntities.GNOME_COCK_THIEF, GnomeCockThiefEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.IRON_ORE_DUDE, IronOreDudeEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SKROMNYAGA, SkromnyagaEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GNOME, GnomeEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WOOD_DUDE, WoodDudeEntity.setAttributes());






	}
}
