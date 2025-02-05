package net.thewonderfultime.pony18craft.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.thewonderfultime.pony18craft.block.ModBlocks;
import net.thewonderfultime.pony18craft.world.custom_events.BlockReplaceScheduler;
import net.thewonderfultime.pony18craft.world.custom_events.BlockReplaceTask;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SkewerWithPigBlock extends HorizontalFacingBlock {
    public SkewerWithPigBlock(Settings settings) {
        super(settings);
    }

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;



    /**
     * задаем шэйп, по объему объекта, чтобы можно было сталкиваться только с видимыми частями по объему фигуры
     */
    public static VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 32, 10);

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
//        мб поправить на getPlayerFacing
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }





    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }









    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.FLINT_AND_STEEL) {
            // Наносим урон огниву
            itemStack.damage(1, player, (p) -> p.sendToolBreakStatus(hand));

            // Воспроизводим звук использования огнива
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            // Проверяем, что мир является серверным (ServerWorld)
            if (world instanceof ServerWorld) {
                // Создаем задачу с задержкой 20 тиков (1 секунда)
                BlockReplaceTask task = new BlockReplaceTask(world, pos, 20);
                BlockReplaceScheduler.TASKS.add(task);
            }

            // Возвращаем успешный результат
            return ActionResult.SUCCESS;
        }

        // Если это не огниво, возвращаем PASS
        return ActionResult.PASS;
    }




//    public void tick(BlockState state, ServerWorld world, BlockPos pos, net.minecraft.util.math.random.Random random) {
//        // Заменяем текущий блок на жареную версию, сохраняя направление
//        world.setBlockState(pos, ModBlocks.SKEWER_WITH_PIG_FRIED.getDefaultState()
//                .with(FACING, state.get(FACING)));
//
//        // Добавляем звук и частицы готовки
//        world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH,
//                SoundCategory.BLOCKS, 1.0F, 1.0F);
//        world.spawnParticles(ParticleTypes.SMOKE,
//                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
//                10, 0.2, 0.2, 0.2, 0.02);
//    }

}
