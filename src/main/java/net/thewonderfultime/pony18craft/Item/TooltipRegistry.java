package net.thewonderfultime.pony18craft.Item;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.Map;

public class TooltipRegistry {

    private static final Map<Item, String> tooltips = new HashMap<>();

    public static void registerTooltip(Item item, String tooltip) {
        tooltips.put(item, tooltip);
    }

    public static void initialize() {
        ItemTooltipCallback.EVENT.register((stack, context, lines) -> {
            Item item = stack.getItem();
            if (tooltips.containsKey(item)) {
                lines.add(Text.literal(tooltips.get(item)).formatted(Formatting.GRAY));
            }
        });
    }
}
