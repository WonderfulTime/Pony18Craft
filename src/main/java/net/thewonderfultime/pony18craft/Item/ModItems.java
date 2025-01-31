package net.thewonderfultime.pony18craft.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Item.custom.GayMagicWand;
import net.thewonderfultime.pony18craft.Item.custom.food.CustomFoodWithEffects;

import net.thewonderfultime.pony18craft.Item.custom.item.ThrowingGnomeItem;
import net.thewonderfultime.pony18craft.Item.custom.trinkets.FlyAmuletTrinket;
import net.thewonderfultime.pony18craft.Item.custom.trinkets.SchizophreniaRingTrinket;
import net.thewonderfultime.pony18craft.Item.materials.CommonToolMaterial;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.block.ModBlocks;
import net.thewonderfultime.pony18craft.entity.ModEntities;

import net.thewonderfultime.pony18craft.sound.ModSounds;

public class ModItems {


    /**
     * предметы
     */


    public static final Item GNOME_COCK_THIEF_SPAWN_EGG = registerItem("gnome_cock_thief_spawn_egg",
            new SpawnEggItem(ModEntities.GNOME_COCK_THIEF, 0x9F1313, 0x0037379F,
                    new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");
//    C++ HEX

    public static final Item IRON_ORE_DUDE_SPAWN_EGG = registerItem("iron_ore_dude_spawn_egg",
            new SpawnEggItem(ModEntities.IRON_ORE_DUDE, 0x7F7F7F, 0xD8AF93,
                    new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");


    public static final Item SKROMNYAGA_SPAWN_EGG = registerItem("skromnyaga_spawn_egg",
            new SpawnEggItem(ModEntities.SKROMNYAGA, 0x00A3877C, 0x00AEA9D6,
                    new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item GNOME_SPAWN_EGG = registerItem("gnome_spawn_egg",
            new SpawnEggItem(ModEntities.GNOME, 0x00803526, 0x00CEC9C5,
                    new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item WOOD_DUDE_SPAWN_EGG = registerItem("wood_dude_spawn_egg",
            new SpawnEggItem(ModEntities.WOOD_DUDE, 0x00497898, 0x00263D4C,
                    new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item HANS_COIN_SILVER = registerItem("hans_coin_silver",
            new Item(new FabricItemSettings()),
            ModItemGroups.Pony18CraftGroup,
            "Универсальная валюта"
    );

    public static final Item HANS_COIN_GOLD = registerItem("hans_coin_gold",
            new Item(new FabricItemSettings()),
            ModItemGroups.Pony18CraftGroup,
            "Универсальная валюта"
    );


    /**
     * посевы
     */
    public static final Item KHMELI_SUNELI_SEEDS = registerItem("khmeli_suneli_seeds",
            new AliasedBlockItem(ModBlocks.KHMELI_SUNELI_CROP,
                     new FabricItemSettings()), ModItemGroups.Pony18CraftGroup,
            "");

    /**
     * музык диски
     */
    public static final Item MUDATON_MUSIC_DISC = registerItem("mudaton_music_disc",
            new MusicDiscItem(6, ModSounds.MUDATON_MUSIC_DISC, new FabricItemSettings().maxCount(1),
                    179), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item TONY_TONY_CHOPPER_MUSIC_DISC = registerItem("tony_tony_chopper_music_disc",
            new MusicDiscItem(8, ModSounds.TONY_TONY_CHOPPER_MUSIC_DISC, new FabricItemSettings().maxCount(1),
                    218), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item PONY_WAIFU_MUSIC_DISC = registerItem("pony_waifu_music_disc",
            new MusicDiscItem(7, ModSounds.PONY_WAIFU_MUSIC_DISC, new FabricItemSettings().maxCount(1),
                    175), ModItemGroups.Pony18CraftGroup,
            "");

    public static final Item YARILO_MUSIC_DISC = registerItem("yarilo_music_disc",
            new MusicDiscItem(6, ModSounds.YARILO_MUSIC_DISC, new FabricItemSettings().maxCount(1),
                    223), ModItemGroups.Pony18CraftGroup,
            "");


    /**
     * кастомные предметы
     */
    public static final Item GAY_MAGIC_WAND = registerItem("gay_magic_wand",
            new GayMagicWand(new FabricItemSettings().maxDamage(30)), ModItemGroups.Pony18CraftGroup,
            "");


    public static final Item THROWING_GNOME = registerItem("throwing_gnome",
            new ThrowingGnomeItem(new FabricItemSettings().maxCount(64)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );


    /**
     * тринкеты
     */
    public static final Item FLY_AMULET_TRINKET = registerItem(
            "fly_amulet_trinket",
            new FlyAmuletTrinket(new FabricItemSettings().maxCount(1)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );

    public static final Item SCHIZOPHRENIA_RING_TRINKET = registerItem(
            "schizophrenia_ring_trinket",
            new SchizophreniaRingTrinket(new FabricItemSettings().maxCount(1)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );



    /**
     * инструменты
     *
     * -2.4f — стандартная скорость атаки мечей в Minecraft.
     */

    public static  ToolItem GAY_BOARD_SWORD = (ToolItem) registerItem("gay_board_sword", new SwordItem( CommonToolMaterial.INSTANCE,
                    0, -3.4f, new FabricItemSettings()),
            ModItemGroups.Pony18CraftGroup,
            "");

    public static  ToolItem GNOME_PICKAXE = (ToolItem) registerItem("gnome_pickaxe", new PickaxeItem(ToolMaterials.IRON,
                    1, 9, new FabricItemSettings()),
            ModItemGroups.Pony18CraftGroup,
            "Маленбкая жестб");


    /**
     * еда
     */
    public static final Item BAKED_ORESHEK = registerItem("baked_oreshek",
            new Item(new FabricItemSettings().food(CustomFoodWithEffects.REGENERATION_FOOD_COMPONENT)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );

    public static final Item ORESHEK = registerItem("oreshek",
            new Item(new FabricItemSettings().food(CustomFoodWithEffects.RAW_ORESHEK)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );

    public static final Item KHMELI_SUNELI = registerItem("khmeli_suneli",
            new Item(new FabricItemSettings()),
            ModItemGroups.Pony18CraftGroup,
            "Приправа на все случаи жизни"
    );

    public static final Item CHASHUSHULI = registerItem("chashushuli",
            new Item(new FabricItemSettings().food(CustomFoodWithEffects.CHASHUSHULI)),
            ModItemGroups.Pony18CraftGroup,
            "Томлёная в томатном соусе телятина со сладким перцем, луком, чесноком, кинзой и домашней аджикой."
    );

    public static final Item GYROS = registerItem("gyros",
            new Item(new FabricItemSettings().food(CustomFoodWithEffects.BOSS_KFC_FOOD)),
            ModItemGroups.Pony18CraftGroup,
            ""
    );







    /**
     *
     * регистрация для блоков
     */
    public static Item registerItem(String id, Item item, String description){



        return Registry.register(Registries.ITEM, new Identifier(Pony18craft.MOD_ID, id), item);




    }



















    /**
     *
     * регистрация для предметов
     */
    public static Item registerItem(String id, Item item, ItemGroup itemGroup, String description){


        Item returnItem = Registry.register(Registries.ITEM, new Identifier(Pony18craft.MOD_ID, id), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(returnItem));

        // Если есть описание, добавляем его через тултип
        if (description != null && !description.isEmpty()) {
            TooltipRegistry.registerTooltip(returnItem, description);
        }

        return returnItem;


    }



    public static void register(){
        Pony18craft.LOGGER.debug("Registering items for: " + Pony18craft.MOD_ID);

    }
}
