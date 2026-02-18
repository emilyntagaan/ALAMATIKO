package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaniniwalaTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paniniwala_title);

        UIHelpers.setupUniversalBackButton(this);

        // Mahiwagang Lupain
        ImageButton btnMahiwagang = findViewById(R.id.imageButton50);
        btnMahiwagang.setOnClickListener(v -> {
            Intent intent = new Intent(PaniniwalaTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paniniwala");
            intent.putExtra("story_id", "lupain");
            startActivity(intent);
        });

        // Banal Pinagmulan
        ImageButton btnBanalPinagmulan = findViewById(R.id.imageButton55);
        btnBanalPinagmulan.setOnClickListener(v -> {
            Intent intent = new Intent(PaniniwalaTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paniniwala");
            intent.putExtra("story_id", "pinagmulan");
            startActivity(intent);
        });

        // Banal na Gamit
        ImageButton btnBanalGamit = findViewById(R.id.imageButton56);
        btnBanalGamit.setOnClickListener(v -> {
            Intent intent = new Intent(PaniniwalaTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paniniwala");
            intent.putExtra("story_id", "gamit");
            startActivity(intent);
        });

        // Maratabat ng Diwata
        ImageButton btnMaratabat = findViewById(R.id.imageButton57);
        btnMaratabat.setOnClickListener(v -> {
            Intent intent = new Intent(PaniniwalaTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paniniwala");
            intent.putExtra("story_id", "diwata");
            startActivity(intent);
        });

        // Ugnayan ng Mundo
        ImageButton btnUgnayan = findViewById(R.id.imageButton58);
        btnUgnayan.setOnClickListener(v -> {
            Intent intent = new Intent(PaniniwalaTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paniniwala");
            intent.putExtra("story_id", "mundo");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView13);
        AnimationHelper.animateFloat(header);
    }
}
