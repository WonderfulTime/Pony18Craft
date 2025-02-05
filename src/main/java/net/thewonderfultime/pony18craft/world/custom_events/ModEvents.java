package net.thewonderfultime.pony18craft.world.custom_events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class ModEvents {
    public static void register() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            // Обрабатываем все активные задачи
            BlockReplaceScheduler.TASKS.removeIf(task -> task.tick());
        });
    }
}
