package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourt);

        SoundEffects.init(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UIHelpers.setupUniversalBackButton(this);

        // existing: Lugar button
        ImageButton lugarButton = findViewById(R.id.imageButton5);
        lugarButton.setOnClickListener(v -> {
            Intent intent = new Intent(FourtActivity.this, LugarTitles.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(lugarButton);

        // existing: Hayop button
        ImageButton hayopButton = findViewById(R.id.imageButton6);
        hayopButton.setOnClickListener(v -> {
            Intent intent = new Intent(FourtActivity.this, HayopTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(hayopButton);

        // existing: Halaman button
        ImageButton halamanButton = findViewById(R.id.imageButton7);
        halamanButton.setOnClickListener(v -> {
            Intent intent = new Intent(FourtActivity.this, HalamanTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(halamanButton);

        // existing: Bagay button
        ImageButton bagayButton = findViewById(R.id.imageButton8);
        bagayButton.setOnClickListener(v -> {
            Intent intent = new Intent(FourtActivity.this, BagayTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(bagayButton);

        // NEW: Prutas at Gulay button -> open PrutasGulayTitle activity
        ImageButton prutasGulayButton = findViewById(R.id.imageButton9);
        prutasGulayButton.setOnClickListener(v -> {
            Intent intent = new Intent(FourtActivity.this, PrutasGulayTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(prutasGulayButton);
    }
}
