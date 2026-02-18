package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PaglalabanTitle extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paglalaban_title);

        UIHelpers.setupUniversalBackButton(this);

        // Lakbay Dagat at Solu
        ImageButton btn49 = findViewById(R.id.imageButton49);
        btn49.setOnClickListener(v -> {
            Intent intent = new Intent(PaglalabanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paglalakbay");
            intent.putExtra("story_id", "sulu");
            startActivity(intent);
        });

        // Lakbay Bayan at Diyos
        ImageButton btn51 = findViewById(R.id.imageButton51);
        btn51.setOnClickListener(v -> {
            Intent intent = new Intent(PaglalabanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paglalakbay");
            intent.putExtra("story_id", "diyos");
            startActivity(intent);
        });

        // Paghahanap kay Faelmar
        ImageButton btn52 = findViewById(R.id.imageButton52);
        btn52.setOnClickListener(v -> {
            Intent intent = new Intent(PaglalabanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paglalakbay");
            intent.putExtra("story_id", "faelmar");
            startActivity(intent);
        });

        // Lakbay Pa-langit
        ImageButton btn53 = findViewById(R.id.imageButton53);
        btn53.setOnClickListener(v -> {
            Intent intent = new Intent(PaglalabanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paglalakbay");
            intent.putExtra("story_id", "langit");
            startActivity(intent);
        });

        // Hanap kay Panyudangan
        ImageButton btn54 = findViewById(R.id.imageButton54);
        btn54.setOnClickListener(v -> {
            Intent intent = new Intent(PaglalabanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "paglalakbay");
            intent.putExtra("story_id", "panyudangan");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView13);
        AnimationHelper.animateFloat(header);
    }
}
