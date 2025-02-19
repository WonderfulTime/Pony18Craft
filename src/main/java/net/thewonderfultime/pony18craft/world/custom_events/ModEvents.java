package net.thewonderfultime.pony18craft.world.custom_events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ModEvents {
    public static void register() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            // Обрабатываем все активные задачи
            BlockReplaceScheduler.TASKS.removeIf(task -> task.tick());

            // Обрабатываем создание струи
            server.getWorlds().forEach(world -> {
                if (world instanceof ServerWorld) {
                    // Здесь можно добавить логику для создания струи
                }
            });
        });
    }

    public static void createPeeStream(World world, Vec3d position, Vec3d direction) {
        // Логика для создания струи
        // Например, спавн частиц или вызов кастомного метода
    }
}
