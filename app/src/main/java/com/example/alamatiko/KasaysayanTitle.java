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

public class KasaysayanTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasaysayan_title);

        UIHelpers.setupUniversalBackButton(this);

        // Hudhud
        ImageButton btnHudhud = findViewById(R.id.imageButton60);
        btnHudhud.setOnClickListener(v -> {
            Intent intent = new Intent(KasaysayanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "kasaysayan");
            intent.putExtra("story_id", "hudhud");
            startActivity(intent);
        });

        // Hinilawod
        ImageButton btnHinilawod = findViewById(R.id.imageButton59);
        btnHinilawod.setOnClickListener(v -> {
                    Intent intent = new Intent(KasaysayanTitle.this, EmptyBook.class);
                    intent.putExtra("tale_type", "epiko");
                    intent.putExtra("category", "kasaysayan");
                    intent.putExtra("story_id", "hinilawod");
                    startActivity(intent);
        });

        // Ulahingan
        ImageButton btnUlahingan = findViewById(R.id.imageButton61);
        btnUlahingan.setOnClickListener(v -> {
            Intent intent = new Intent(KasaysayanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "kasaysayan");
            intent.putExtra("story_id", "ulahingan");
            startActivity(intent);
        });

        // Dangen
        ImageButton btnDangen = findViewById(R.id.imageButton62);
        btnDangen.setOnClickListener(v -> {
            Intent intent = new Intent(KasaysayanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "kasaysayan");
            intent.putExtra("story_id", "darangen");
            startActivity(intent);
        });
        // Ibalon
        ImageButton btnIbalon = findViewById(R.id.imageButton63);
        btnIbalon.setOnClickListener(v -> {
            Intent intent = new Intent(KasaysayanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "kasaysayan");
            intent.putExtra("story_id", "ibalon");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView13);
        AnimationHelper.animateFloat(header);
    }
}
