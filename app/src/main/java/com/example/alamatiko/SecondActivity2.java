package com.example.alamatiko;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity2 extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switch1, switch2;

    private SharedPreferences prefs;
    private static final String PREFS_NAME = "SettingsPrefs";
    private static final String MUSIC_SWITCH = "musicSwitch";
    private static final String OTHER_SWITCH = "otherSwitch"; // for your 2nd one

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second2);

        // handle insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        ImageButton homeButton = findViewById(R.id.imageButton4);

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // --- Load saved states ---
        boolean musicOn = prefs.getBoolean(MUSIC_SWITCH, true);
        boolean otherOn = prefs.getBoolean(OTHER_SWITCH, false);

        switch1.setChecked(musicOn);
        switch2.setChecked(otherOn);

        // Apply tint based on current state
        applySwitchTint(switch1, musicOn);
        applySwitchTint(switch2, otherOn);

        // --- Apply music state immediately ---
        if (musicOn) {
            MusicService.restoreVolume();
        } else {
            MusicService.mute();
        }

        // --- Listeners ---
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(MUSIC_SWITCH, isChecked);
            editor.apply();

            if (isChecked) {
                Toast.makeText(this, "Music ON", Toast.LENGTH_SHORT).show();
                MusicService.restoreVolume();
            } else {
                Toast.makeText(this, "Music OFF", Toast.LENGTH_SHORT).show();
                MusicService.mute();
            }
            applySwitchTint(switch1, isChecked);
        });

        boolean soundEnabled = SoundEffects.isSoundEnabled();
        switch2.setChecked(soundEnabled);
        applySwitchTint(switch2, soundEnabled);

// --- Listener ---
        switch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
            } else {
            }
            applySwitchTint(switch2, isChecked);

            // 🔊 Save new state globally
            SoundEffects.setSoundEnabled(SecondActivity2.this, isChecked);
        });


        homeButton.setOnClickListener(v -> {
            finish();
        });
    }

    @SuppressLint("ObsoleteSdkInt")
    private void applySwitchTint(@SuppressLint("UseSwitchCompatOrMaterialCode") Switch sw, boolean isOn) {
        Drawable thumb = sw.getThumbDrawable();
        Drawable track = sw.getTrackDrawable();

        if (thumb != null) {
            thumb.mutate();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                thumb.setTint(isOn ? Color.WHITE : Color.BLACK);
            }
        }

        if (track != null) {
            track.mutate();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                track.setTint(isOn ? Color.LTGRAY : Color.DKGRAY);
            }
        }

        sw.invalidate();
    }
}
