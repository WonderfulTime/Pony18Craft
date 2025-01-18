package net.thewonderfultime.pony18craft.Item.custom.item;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.thewonderfultime.pony18craft.entity.custom.ThrowingGnomeProjectileEntity;
import net.thewonderfultime.pony18craft.sound.ModSounds;


public class ThrowingGnomeItem extends Item {


    public ThrowingGnomeItem(Settings settings) {
        super(settings);
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.GNOME_LAUGH_SOUND, SoundCategory.NEUTRAL,
                0.8f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            ThrowingGnomeProjectileEntity thrown_gnome = new ThrowingGnomeProjectileEntity(world, user);
            thrown_gnome.setVelocity(user, user.getPitch(), user.getYaw(),  0.0F, 1.5F, 1.0F);
            world.spawnEntity(thrown_gnome);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }

}