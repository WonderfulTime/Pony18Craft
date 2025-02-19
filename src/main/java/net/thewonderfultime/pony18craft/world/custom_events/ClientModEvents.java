package net.thewonderfultime.pony18craft.world.custom_events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;
import net.thewonderfultime.pony18craft.particle.ModParticles;

public class ClientModEvents {
    public static final KeyBinding PEE_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.pony18craft.pee", // Уникальный ID
            InputUtil.Type.KEYSYM, // Тип клавиши (клавиатура)
            GLFW.GLFW_KEY_P, // Клавиша P
            "category.pony18craft.keys" // Категория в настройках управления
    ));

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (PEE_KEY.isPressed()) {
                if (client.player != null) {
                    createPeeStream(client);
                }
            }
        });
    }

    private static void createPeeStream(MinecraftClient client) {
        World world = client.world;
        if (world == null) return;

        Vec3d lookVector = client.player.getRotationVec(1.0F);
        double x = client.player.getX();
        double y = client.player.getY() + 0.8; // область паха
        double z = client.player.getZ();

        // Направление струи
        double velocityX = lookVector.x * 0.2;
        double velocityY = lookVector.y * 0.2 + 0.1; // Немного вверх
        double velocityZ = lookVector.z * 0.2;

        world.addParticle((ParticleEffect) ModParticles.PEE_PARTICLE, x, y, z, velocityX, velocityY, velocityZ);
    }
}
