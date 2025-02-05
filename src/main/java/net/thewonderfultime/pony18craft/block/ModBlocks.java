package net.thewonderfultime.pony18craft.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Item.ModItemGroups;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.block.custom.KhmeliSuneliCropBlock;
import net.thewonderfultime.pony18craft.block.custom.PivoBlock;
import net.thewonderfultime.pony18craft.block.custom.SkewerWithPigBlock;
import net.thewonderfultime.pony18craft.block.custom.SkewerWithPigFriedBlock;

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


    /**
     * ростки
     */
    public static final Block KHMELI_SUNELI_CROP = registerBlockWithoutItem("khmeli_suneli_crop",
            new KhmeliSuneliCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));


    /**
     *
     * спец блоки
     */

    public static final Block SKEWER_WITH_PIG = registerBlock("skewer_with_pig",
            new SkewerWithPigBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f).nonOpaque().luminance(1)),
            ModItemGroups.Pony18CraftGroup,
            "Лучше сырым не есть...");


    public static final Block SKEWER_WITH_PIG_FRIED = registerBlock("skewer_with_pig_fried",
            new SkewerWithPigFriedBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f).nonOpaque().luminance(1)),
            ModItemGroups.Pony18CraftGroup,
            "О боже... что ты наделал...");


















    private static Block registerBlock(String id, Block block, ItemGroup itemGroup, String description){
        ModItems.registerItem(id, new BlockItem(block, new FabricItemSettings()), itemGroup, description);

        return Registry.register(Registries.BLOCK, new Identifier(Pony18craft.MOD_ID, id), block);
    };

    private static Block registerBlock(String id, Block block, String description){
        //регистрация блоков без группы
        ModItems.registerItem(id, new BlockItem(block, new FabricItemSettings()), description);

        return Registry.register(Registries.BLOCK, new Identifier(Pony18craft.MOD_ID, id), block);
    };


    private static Block registerBlockWithoutItem(String id, Block block){
        // регистрация всяких посевов и прочего


        return Registry.register(Registries.BLOCK, new Identifier(Pony18craft.MOD_ID, id), block);
    };

    public static void register(){

        Pony18craft.LOGGER.debug("Registering items for: " + Pony18craft.MOD_ID);

    }
}
