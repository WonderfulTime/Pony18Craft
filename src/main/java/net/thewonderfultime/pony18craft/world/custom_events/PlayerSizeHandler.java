package net.thewonderfultime.pony18craft.world.custom_events;



import net.fabricmc.fabric.api.entity.event.v1.ServerEntityWorldChangeEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import java.util.HashMap;
import java.util.UUID;

public class PlayerSizeHandler {
    private static final HashMap<UUID, Float> stretchFactors = new HashMap<>();

    public static void register() {
        // Регистрируем изменение хитбокса на каждый тик
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            for (PlayerEntity player : world.getPlayers()) {
                if (stretchFactors.containsKey(player.getUuid())) {
                    float factor = stretchFactors.get(player.getUuid());
                    updatePlayerSize(player, factor);
                }
            }
        });

        // Сбрасываем размеры при смене мира
        ServerEntityWorldChangeEvents.AFTER_PLAYER_CHANGE_WORLD.register((original, destination, reason) -> {
            stretchFactors.remove(original.getUuid());
        });
    }

    public static void setPlayerStretchFactor(PlayerEntity player, float factor) {
        stretchFactors.put(player.getUuid(), factor);
    }

    private static void updatePlayerSize(PlayerEntity player, float factor) {
        float baseWidth = 0.6f;
        float baseHeight = 1.8f;
        float newWidth = baseWidth * factor;
        player.setBoundingBox(new Box(
                player.getX() - newWidth / 2, player.getY(), player.getZ() - newWidth / 2,
                player.getX() + newWidth / 2, player.getY() + baseHeight, player.getZ() + newWidth / 2
        ));
    }
}

