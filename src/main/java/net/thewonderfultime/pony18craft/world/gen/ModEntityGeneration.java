package net.thewonderfultime.pony18craft.world.gen;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.thewonderfultime.pony18craft.entity.ModEntities;

public class ModEntityGeneration {

    public static void addSpawns(){
        /*
        в каких биомах спаун моба
         */
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST,
                BiomeKeys.FLOWER_FOREST,
                BiomeKeys.BIRCH_FOREST,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.CRIMSON_FOREST,
                BiomeKeys.WARPED_FOREST,
                BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                BiomeKeys.WINDSWEPT_FOREST), SpawnGroup.CREATURE, ModEntities.GNOME_COCK_THIEF,
                35,1, 1);

        /*
        в каком месте спаун, на земле, в небе и тд
         */
        SpawnRestriction.register(
                ModEntities.GNOME_COCK_THIEF,  // Сущность
                SpawnRestriction.Location.ON_GROUND,  // Локация спауна
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,  // Тип карты высоты
                AnimalEntity::isValidNaturalSpawn  // Условие спауна
        );



        // Добавляем спаун SKROMNYAGA в подземных биомах
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),  // Все биомы Верхнего мира
                SpawnGroup.MONSTER,
                ModEntities.SKROMNYAGA,
                30, 1, 1
        );

// Кастомное ограничение спауна для SKROMNYAGA (только ниже уровня 30)
        SpawnRestriction.register(
                ModEntities.SKROMNYAGA,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING,
                (type, world, spawnReason, pos, random) -> pos.getY() < 30 && PathAwareEntity.canMobSpawn(type,
                        world, spawnReason, pos, random)
        );



        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST,
                        BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.BIRCH_FOREST,
                        BiomeKeys.DARK_FOREST,
                        BiomeKeys.CRIMSON_FOREST,
                        BiomeKeys.WARPED_FOREST,
                        BiomeKeys.OLD_GROWTH_BIRCH_FOREST,
                        BiomeKeys.WINDSWEPT_FOREST), SpawnGroup.CREATURE, ModEntities.GNOME,
                40,1, 2);

        /*
        в каком месте спаун, на земле, в небе и тд
         */
        SpawnRestriction.register(
                ModEntities.GNOME,  // Сущность
                SpawnRestriction.Location.ON_GROUND,  // Локация спауна
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,  // Тип карты высоты
                PathAwareEntity::canMobSpawn  // Условие спауна
        );


    }

}
