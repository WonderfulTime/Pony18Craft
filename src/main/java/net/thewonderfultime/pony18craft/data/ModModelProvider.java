package net.thewonderfultime.pony18craft.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.thewonderfultime.pony18craft.Item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        blockStateModelGenerator.registerParentedItemModel(ModItems.GNOME_COCK_THIEF_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        blockStateModelGenerator.registerParentedItemModel(ModItems.IRON_ORE_DUDE_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        blockStateModelGenerator.registerParentedItemModel(ModItems.SKROMNYAGA_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        blockStateModelGenerator.registerParentedItemModel(ModItems.GNOME_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        blockStateModelGenerator.registerParentedItemModel(ModItems.WOOD_DUDE_SPAWN_EGG,
                ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.MUDATON_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.TONY_TONY_CHOPPER_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.PONY_WAIFU_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.YARILO_MUSIC_DISC, Models.GENERATED);

    }
}
