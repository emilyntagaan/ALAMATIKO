package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);

        SoundEffects.init(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UIHelpers.setupUniversalBackButton(this);

        // Bayani button -> open BayaniTitle activity
        ImageButton bayaniButton = findViewById(R.id.imageButton10);
        bayaniButton.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, BayaniTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(bayaniButton);

        // Pag-ibig button -> open PagibigTitle activity
        ImageButton pagibigButton = findViewById(R.id.imageView10);
        pagibigButton.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, PagibigTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(pagibigButton);

        // Paglalaban button -> open PaglalabanTitle activity
        ImageButton paglalabanButton = findViewById(R.id.imageButton11);
        paglalabanButton.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, PaglalabanTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(paglalabanButton);

        // Paniniwala button -> open PaniniwalaTitle activity
        ImageButton paniniwalaButton = findViewById(R.id.imageButton15);
        paniniwalaButton.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, PaniniwalaTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(paniniwalaButton);

        //  Kasaysayan button -> open KasaysayanTitle activity
        ImageButton kasaysayanButton = findViewById(R.id.imageButton12);
        kasaysayanButton.setOnClickListener(v -> {
            Intent intent = new Intent(FifthActivity.this, KasaysayanTitle.class);
            SoundEffects.playClick();
            startActivity(intent);
        });
        AnimationHelper.animateFloat(kasaysayanButton);
    }
}
