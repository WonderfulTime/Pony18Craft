package net.thewonderfultime.pony18craft.world.custom_events;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.block.ModBlocks;

public class BlockReplaceTask {
    private final World world;
    private final BlockPos pos;
    private int ticksRemaining;

    public BlockReplaceTask(World world, BlockPos pos, int delayTicks) {
        this.world = world;
        this.pos = pos;
        this.ticksRemaining = delayTicks;
    }

    public boolean tick() {
        ticksRemaining--;
        if (ticksRemaining <= 0) {
            // Заменяем блок
            world.setBlockState(pos, ModBlocks.SKEWER_WITH_PIG_FRIED.getDefaultState());
            return true; // Задача завершена
        }
        return false; // Задача еще не завершена
    }
}
