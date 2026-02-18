package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LugarTitles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lugar_titles); // xml ng lugar

        UIHelpers.setupUniversalBackButton(this);

        // Mayon button
        ImageButton mayonButton = findViewById(R.id.imageButton13);
        mayonButton.setOnClickListener(v -> {
            Intent intent = new Intent(LugarTitles.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "lugar");
            intent.putExtra("story_id", "mayon");
            startActivity(intent);
        });

        // Kanlaon button
        ImageButton kanlaonButton = findViewById(R.id.imageButton14);
        kanlaonButton.setOnClickListener(v -> {
            Intent intent = new Intent(LugarTitles.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "lugar");
            intent.putExtra("story_id", "kanlaon");
            startActivity(intent);
        });

        // Bohol button
        ImageButton boholButton = findViewById(R.id.imageButton16);
        boholButton.setOnClickListener(v -> {
            Intent intent = new Intent(LugarTitles.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "lugar");
            intent.putExtra("story_id", "bohol");
            startActivity(intent);
        });

        // Maria Cristina button
        ImageButton mariaCristinaButton = findViewById(R.id.imageButton17);
        mariaCristinaButton.setOnClickListener(v -> {
            Intent intent = new Intent(LugarTitles.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "lugar");
            intent.putExtra("story_id", "mariac");
            startActivity(intent);
        });

        // Taal button
        ImageButton taalButton = findViewById(R.id.imageButton18);
        taalButton.setOnClickListener(v -> {
            Intent intent = new Intent(LugarTitles.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "lugar");
            intent.putExtra("story_id", "taal");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView16);
        AnimationHelper.animateFloat(header);
    }
}
