package net.thewonderfultime.pony18craft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.thewonderfultime.pony18craft.data.ModEntityLootTableGenerator;
import net.thewonderfultime.pony18craft.data.ModLootTableGenerator;
import net.thewonderfultime.pony18craft.data.ModModelProvider;
import net.thewonderfultime.pony18craft.data.ModRecipeGenerator;

public class Pony18CraftDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModEntityLootTableGenerator::new); // Добавляем генератор лута сущностей

    }
}
