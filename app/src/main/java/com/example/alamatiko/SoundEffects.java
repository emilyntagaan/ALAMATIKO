package com.example.alamatiko;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundEffects {

    private static SoundPool soundPool;
    private static int clickSound;
    private static boolean soundEnabled = true; // default ON

    private static final String PREFS_NAME = "AppSettings";
    private static final String KEY_SOUND = "sound_enabled";

    // Call this once in MainActivity or app start
    public static void init(Context context) {
        if (soundPool == null) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();

            clickSound = soundPool.load(context, R.raw.button_click, 1);
        }

        // Load saved setting
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        soundEnabled = prefs.getBoolean(KEY_SOUND, true); // default ON
    }

    // 🔉 Play sound only if enabled
    public static void playClick() {
        if (soundPool != null && soundEnabled) {
            soundPool.play(clickSound, 0.25F, 0.25F, 1, 0, 1);
        }
    }

    // 🔇 Enable/disable and save preference
    public static void setSoundEnabled(Context context, boolean enabled) {
        soundEnabled = enabled;
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_SOUND, enabled).apply();
    }

    public static boolean isSoundEnabled() {
        return soundEnabled;
    }

    public static void release() {
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }
}
