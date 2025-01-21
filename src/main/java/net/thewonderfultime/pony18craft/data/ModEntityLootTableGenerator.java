package net.thewonderfultime.pony18craft.data;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.item.Items;
import net.thewonderfultime.pony18craft.entity.ModEntities;

import java.util.function.BiConsumer;


public class ModEntityLootTableGenerator extends SimpleFabricLootTableProvider {

    public ModEntityLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        // Таблица лута для сущности IRON_ORE_DUDE
        identifierBuilderBiConsumer.accept(
                ModEntities.IRON_ORE_DUDE.getLootTableId(), // ID таблицы лута
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(UniformLootNumberProvider.create(1.0F, 2.0F)) // Количество пулов: 1
                                .with(ItemEntry.builder(Items.STONE))
                                .with(ItemEntry.builder(Items.RAW_IRON)// Что будет выпадать

                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))) // От 1 до 3 штук
                                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Шанс дропа: 100%
                                )
                        )
        );

        // Таблица лута для сущности WOOD_DUDE
        identifierBuilderBiConsumer.accept(
                ModEntities.WOOD_DUDE.getLootTableId(), // ID таблицы лута
                LootTable.builder()
                        .pool(LootPool.builder()
                                .rolls(UniformLootNumberProvider.create(1.0F, 1.0F)) // Количество пулов: 1
                                .with(ItemEntry.builder(Items.OAK_WOOD)// Что будет выпадать

                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F)))
                                        .conditionally(RandomChanceLootCondition.builder(0.5f)) // Шанс дропа: 100%
                                )
                        )
        );
    }




}
