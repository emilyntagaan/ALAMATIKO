package com.example.alamatiko;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class thirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);

        SoundEffects.init(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UIHelpers.setupUniversalBackButton(this);

        // 🔹 Alamat button
        ImageButton alamatButton = findViewById(R.id.imageButton);
        alamatButton.setOnClickListener(v -> {
            Intent intent = new Intent(thirdActivity.this, FourtActivity.class);
            SoundEffects.playClick();
            startActivity(intent);
        });

// 🔹 Epiko button
        ImageButton epikoButton = findViewById(R.id.imageButton3);
        epikoButton.setOnClickListener(v -> {
            Intent intent = new Intent(thirdActivity.this, FifthActivity.class);
            SoundEffects.playClick();
            startActivity(intent);
        });

        ImageView fairy = findViewById(R.id.imageView8);

        AnimationHelper.animateFloat(fairy);
        AnimationHelper.animateFloat(alamatButton);
        AnimationHelper.animateFloat(epikoButton);

    }
}
