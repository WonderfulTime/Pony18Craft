package net.thewonderfultime.pony18craft.world.custom_events;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final KeyBinding PEE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.pony18craft.pee", // Уникальный ID
            InputUtil.Type.KEYSYM, // Тип клавиши (клавиатура)
            GLFW.GLFW_KEY_P, // Клавиша P
            "category.pony18craft.keys" // Категория в настройках управления
    ));
}
