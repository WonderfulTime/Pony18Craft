package net.thewonderfultime.pony18craft.effects.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.thewonderfultime.pony18craft.entity.custom.IronOreDudeEntity;
import net.thewonderfultime.pony18craft.entity.custom.WoodDudeEntity;

public class SchizophreniaEffect extends StatusEffect {

    // Конструктор с категорией и цветом эффекта
    public SchizophreniaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient && entity.age % 40 == 0) {  // Проверка каждые 40 тиков
            ServerWorld serverWorld = (ServerWorld) entity.getWorld();
            BlockPos playerPos = entity.getBlockPos();

            // Проход по блокам в радиусе 50 блоков
            for (BlockPos pos : BlockPos.iterateOutwards(playerPos, 20, 10, 20)) {
                BlockState blockState = serverWorld.getBlockState(pos);

                // Проверка, что это лог из дерева и рядом есть листья
                if (isNaturalTreeLog(serverWorld, pos, blockState)) {
                    transformTreeToEntity(serverWorld, pos);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;  // Эффект всегда активен
    }

    // Проверка, что это именно ствол дерева
    private boolean isNaturalTreeLog(World world, BlockPos pos, BlockState state) {
        // Проверка, является ли блок древесным стволом
        if (!state.isIn(BlockTags.LOGS)) {
            return false;
        }

        // Проверка наличия листвы рядом
        for (BlockPos offsetPos : BlockPos.iterateOutwards(pos, 2, 8, 2)) {
            BlockState nearbyState = world.getBlockState(offsetPos);
            if (nearbyState.isIn(BlockTags.LEAVES)) {
                return true;  // Если рядом есть листья, это дерево
            }
        }

        return false;
    }

    // Замена блока на сущность
    private void transformTreeToEntity(ServerWorld world, BlockPos pos) {
        world.removeBlock(pos, false);  // Удаляем блок

        // Превращаем в сущность (пока используем летучую мышь для теста)
        WoodDudeEntity treeEntity = new WoodDudeEntity(ModEntities.WOOD_DUDE, world);
        treeEntity.refreshPositionAndAngles(pos, 0.0F, 0.0F);

        world.spawnEntity(treeEntity);

        // Визуальный эффект (частицы)
//        world.spawnParticles(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 10, 0.5, 0.5, 0.5, 0.01);
    }







}