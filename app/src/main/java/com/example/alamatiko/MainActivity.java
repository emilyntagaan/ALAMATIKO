package com.example.alamatiko; // siguraduhin tumutugma sa package mo

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton2;
    ImageView settingsImage;
    ImageView fairystart; // 🧚 for animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent musicIntent = new Intent(this, MusicService.class);
        startService(musicIntent);

        SoundEffects.init(this);

        // START button (leaf_button)
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, thirdActivity.class);
                SoundEffects.playClick();
                startActivity(intent);
            }
        });

        // Settings (imageView6)
        settingsImage = findViewById(R.id.imageView6);
        settingsImage.setClickable(true);
        settingsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);
            }
        });

        // 🧚 Fairy animation start
        fairystart = findViewById(R.id.imageView9);
        if (fairystart != null) {
            animateFairy(fairystart);
        }
    }

    /**
     * 🧚 Creates a continuous floating animation for the fairy.
     */
    private void animateFairy(final ImageView view) {
        // Move up
        view.animate()
                .translationYBy(-50f)
                .setDuration(1500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        // Move down
                        view.animate()
                                .translationYBy(50f)
                                .setDuration(1500)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                        // Repeat forever
                                        animateFairy(view);
                                    }
                                });
                    }
                });
    }
}
