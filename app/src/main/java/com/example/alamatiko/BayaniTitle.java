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

public class BayaniTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayani_title);

        UIHelpers.setupUniversalBackButton(this);

        // Hudhud ni Aliguyon
        ImageButton hudhudButton = findViewById(R.id.imageButton39);
        hudhudButton.setOnClickListener(v -> {
            Intent intent = new Intent(BayaniTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "bayani");
            intent.putExtra("story_id", "aliguyon");
            startActivity(intent);
        });

        // Biag ni Lam-ang
        ImageButton lamangButton = findViewById(R.id.imageButton40);
        lamangButton.setOnClickListener(v -> {
            Intent intent = new Intent(BayaniTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "bayani");
            intent.putExtra("story_id", "biag");
            startActivity(intent);
        });

        // Darangen
        ImageButton darangenButton = findViewById(R.id.imageButton41);
        darangenButton.setOnClickListener(v -> {
            Intent intent = new Intent(BayaniTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "bayani");
            intent.putExtra("story_id", "darangen");
            startActivity(intent);
        });

        // Handiong
        ImageButton handiongButton = findViewById(R.id.imageButton42);
        handiongButton.setOnClickListener(v -> {
            Intent intent = new Intent(BayaniTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "bayani");
            intent.putExtra("story_id", "handiong");
            startActivity(intent);
        });

        // Labaw Donggon
        ImageButton labawButton = findViewById(R.id.imageButton43);
        labawButton.setOnClickListener(v -> {
            Intent intent = new Intent(BayaniTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "bayani");
            intent.putExtra("story_id", "labaw");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView13);
        AnimationHelper.animateFloat(header);
    }
}
