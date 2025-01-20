package net.thewonderfultime.pony18craft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Item.ModItemGroups;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.block.custom.PivoBlock;

public class ModBlocks {

//    создание блока и настройка его материала и твердости
    public static final Block BEER_BLOCK = registerBlock("beer_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3.0f).requiresTool().luminance(1).nonOpaque()),
        ModItemGroups.Pony18CraftGroup,
        "Обычный ящик с пивом");

    public static final Block PIVO_BLOCK = registerBlock("pivo_block",
            new PivoBlock(FabricBlockSettings.of(Material.GLASS).strength(1.0f).requiresTool().nonOpaque().luminance(1)),
            ModItemGroups.Pony18CraftGroup,
            "Слегка солоноватое пиво");

    private static Block registerBlock(String id, Block block, ItemGroup itemGroup, String description){
        ModItems.registerItem(id, new BlockItem(block, new FabricItemSettings()), itemGroup, description);

        return Registry.register(Registries.BLOCK, new Identifier(Pony18craft.MOD_ID, id), block);
    };

    private static Block registerBlock(String id, Block block, String description){
        ModItems.registerItem(id, new BlockItem(block, new FabricItemSettings()), description);

        return Registry.register(Registries.BLOCK, new Identifier(Pony18craft.MOD_ID, id), block);
    };

    public static void register(){

        Pony18craft.LOGGER.debug("Registering items for: " + Pony18craft.MOD_ID);

    }
}
