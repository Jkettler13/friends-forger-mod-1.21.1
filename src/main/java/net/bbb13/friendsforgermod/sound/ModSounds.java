package net.bbb13.friendsforgermod.sound;

import net.bbb13.friendsforgermod.FriendsForgerMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModSounds {
    //public static final JukeboxSong MARKEE_SONG =
    public static final SoundEvent MARKEE_SONG_MUSIC_DISC = registerSoundEvent("markee_song_music_disc");

    public static final SoundEvent MEDICINE_BLOCK_BREAK = registerSoundEvent("medicine_block_break");
    public static final SoundEvent MEDICINE_BLOCK_STEP = registerSoundEvent("medicine_block_step");
    public static final SoundEvent MEDICINE_BLOCK_PLACE = registerSoundEvent("medicine_block_place");
    public static final SoundEvent MEDICINE_BLOCK_HIT = registerSoundEvent("medicine_block_hit");
    public static final SoundEvent MEDICINE_BLOCK_FALL = registerSoundEvent("medicine_block_fall");

    public static final BlockSoundGroup MEDICINE_BLOCK_SOUNDS = new BlockSoundGroup(1,1,
            ModSounds.MEDICINE_BLOCK_BREAK, ModSounds.MEDICINE_BLOCK_STEP, ModSounds.MEDICINE_BLOCK_PLACE, ModSounds.MEDICINE_BLOCK_HIT, ModSounds.MEDICINE_BLOCK_FALL);



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(FriendsForgerMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        FriendsForgerMod.LOGGER.info("Registering sounds for " + FriendsForgerMod.MOD_ID);
    }
}
