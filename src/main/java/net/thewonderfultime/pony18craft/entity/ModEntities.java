package net.thewonderfultime.pony18craft.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;
import net.thewonderfultime.pony18craft.entity.custom.*;

public class ModEntities {

    public static final EntityType<GnomeCockThiefEntity> GNOME_COCK_THIEF = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Pony18craft.MOD_ID, "gnome_cock_thief"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GnomeCockThiefEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.8f)).build() //хитбокс
    );

    public static final EntityType<IronOreDudeEntity> IRON_ORE_DUDE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Pony18craft.MOD_ID, "iron_ore_dude"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IronOreDudeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build() //хитбокс
    );

    public static final EntityType<WoodDudeEntity> WOOD_DUDE = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Pony18craft.MOD_ID, "wood_dude"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WoodDudeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build() //хитбокс
    );


    public static final EntityType<SkromnyagaEntity> SKROMNYAGA = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Pony18craft.MOD_ID, "skromnyaga"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SkromnyagaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.7f, 1.4f)).build() //хитбокс
    );

    public static final EntityType<GnomeEntity> GNOME = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(Pony18craft.MOD_ID, "gnome"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GnomeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.8f)).build() //хитбокс
    );

    public static final EntityType<ThrowingGnomeProjectileEntity> THROWING_GNOME_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("pony18craft", "throwing_gnome_projectile"),
            FabricEntityTypeBuilder.<ThrowingGnomeProjectileEntity>create(SpawnGroup.MISC, ThrowingGnomeProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)) // Размер сущности
                    .trackRangeBlocks(4)  // Дистанция отслеживания
                    .trackedUpdateRate(10) // Частота обновления
                    .build()
    );





}
