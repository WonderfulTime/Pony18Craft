package net.thewonderfultime.pony18craft.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.thewonderfultime.pony18craft.Pony18craft;

public class ModSounds {

    /**
     * музыка с дисков
     */
    public static SoundEvent MUDATON_MUSIC_DISC = registerSoundEvent("mudaton_music_disc");
    public static SoundEvent TONY_TONY_CHOPPER_MUSIC_DISC = registerSoundEvent("tony_tony_chopper_music_disc");
    public static SoundEvent PONY_WAIFU_MUSIC_DISC = registerSoundEvent("pony_waifu_music_disc");
    public static SoundEvent YARILO_MUSIC_DISC = registerSoundEvent("yarilo_music_disc");


    /**
     * звуки entity
     * всегда вносить в sounds.json !!!!!!!!!!!!!!!!!!!!!!
     */
    public static SoundEvent GNOME_LAUGH_SOUND = registerSoundEvent("gnome_laugh_sound");
    public static SoundEvent GNOME_TAKEN_DAMAGE_SOUND = registerSoundEvent("gnome_taken_damage_sound");
    public static SoundEvent GNOME_FOOTSTEPS_SOUND = registerSoundEvent("gnome_footsteps_sound");
    public static SoundEvent SKROMNYAGA_AMBIENT_SOUND = registerSoundEvent("skromnyaga_ambient_sound");




    private static SoundEvent registerSoundEvent(String name){

        Identifier id = new Identifier(Pony18craft.MOD_ID, name);

        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
