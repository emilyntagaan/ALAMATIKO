package com.example.alamatiko;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    private static MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bg_music);
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // These will be used by your narration logic
    public static void lowerVolume() {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.05f, 0.05f);  // lower volume
        }
    }

    public static void restoreVolume() {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);  // restore full volume after narration
        }
    }

    // Completely mute the background music
    public static void mute() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.setVolume(0f, 0f);  // completely silent
        }
    }
}
