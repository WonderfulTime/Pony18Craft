package net.thewonderfultime.pony18craft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.entity.ModEntities;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {


    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        // Добавляем дроп "oreshek" для всех типов листвы
        addDrop(Blocks.OAK_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.SPRUCE_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.BIRCH_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.JUNGLE_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.ACACIA_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.DARK_OAK_LEAVES, leavesWithDrop(ModItems.ORESHEK));
        addDrop(Blocks.MANGROVE_LEAVES, leavesWithDrop(ModItems.ORESHEK));


    }

    private LootTable.Builder leavesWithDrop(Item dropItem) {
        return BlockLootTableGenerator.dropsWithSilkTouchOrShears(
                Blocks.OAK_LEAVES, // можно заменить на любой блок листвы
                ItemEntry.builder(dropItem)
                        .conditionally(RandomChanceLootCondition.builder(0.10f)) // 10% шанс выпадения
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 1.0F))) // вероятность дропа в количестве предметов
        );
    }


}