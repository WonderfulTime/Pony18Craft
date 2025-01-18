package net.thewonderfultime.pony18craft.Item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;

public class ModItemGroups {
    public static final ItemGroup Pony18CraftGroup = FabricItemGroup.builder(
            new Identifier(Pony18craft.MOD_ID,
            "pony18craft_group")).icon(() -> new ItemStack(ModItems.ORESHEK)).build();

}
