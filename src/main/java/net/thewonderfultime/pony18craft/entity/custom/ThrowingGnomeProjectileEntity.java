package net.thewonderfultime.pony18craft.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.Item.ModItems;
import net.thewonderfultime.pony18craft.entity.ModEntities;
import net.minecraft.util.math.Direction;
import org.joml.Vector2f;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ThrowingGnomeProjectileEntity extends PersistentProjectileEntity implements GeoAnimatable {

    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache( this);

    private float rotation;
    public Vector2f groundedOffset;

    // Конструктор
    public ThrowingGnomeProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }


    public ThrowingGnomeProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.THROWING_GNOME_PROJECTILE, player, world);
    }

    // Рендеринг вращения

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    // Проверка на нахождение на земле

    public boolean isGrounded() {
        return inGround;
    }

    // Столкновение с сущностью
    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity entity = entityHitResult.getEntity();
        // Наносим 4 сердечка урона
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 8.0F);

        // Превращаемся в обычного гнома после столкновения
        if (!this.getWorld().isClient()) {
            spawnIdleGnome();  // Спавн обычного гнома
            this.discard();    // Убираем метательный объект
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        // Превращаемся в обычного гнома после приземления
        if (!this.getWorld().isClient()) {
            spawnIdleGnome();  // Спавн обычного гнома
            this.discard();    // Убираем метательный объект
        }
    }

    // Метод для спавна обычного GnomeEntity
    private void spawnIdleGnome() {
        GnomeEntity gnome = new GnomeEntity(ModEntities.GNOME, this.getWorld());
        gnome.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), this.getPitch());
        this.getWorld().spawnEntity(gnome);
    }






    // Метод для использования предмета
    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.THROWING_GNOME); // Возвращаем ItemStack для метаемого гнома
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object o) {
        return 0;
    }
}
