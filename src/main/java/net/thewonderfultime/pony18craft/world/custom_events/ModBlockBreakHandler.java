package net.thewonderfultime.pony18craft.world.custom_events;


import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.thewonderfultime.pony18craft.entity.ModEntities;

public class ModBlockBreakHandler {
    /**
     * этот класс предназначен для спауна "Рудовичка",
     * этот Entity появляется с шансом при разрушении руды и старается убегать от игрока
     */

    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            // Проверяем, если блок — железная руда
            if (!world.isClient() && state.isOf(Blocks.IRON_ORE)) {
                // Вероятность спауна
                if (world.getRandom().nextFloat() < 0.1) { // 10% шанс
                    // Спавним моба
                    spawnGnomeCockThief((ServerWorld) world, pos);
                }
            }
        });
    }

    private static void spawnGnomeCockThief(ServerWorld world, BlockPos pos) {
        var rudovichok = ModEntities.IRON_ORE_DUDE.create(world);
        if (rudovichok != null) {
            rudovichok.refreshPositionAndAngles(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, world.random.nextFloat() * 360F, 0);
            world.spawnEntity(rudovichok);
        }
    }

}
