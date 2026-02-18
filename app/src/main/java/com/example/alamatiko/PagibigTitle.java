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

public class PagibigTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagibig_title);

        UIHelpers.setupUniversalBackButton(this);

        // 🔹 Gandingan at Bantugen
        ImageButton gandinganBtn = findViewById(R.id.imageButton44);
        gandinganBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PagibigTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "pagibig");
            intent.putExtra("story_id", "gandingan");
            startActivity(intent);
        });

        // 🔹 Bidasari at Sultan
        ImageButton bidasariBtn = findViewById(R.id.imageButton45);
        bidasariBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PagibigTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "pagibig");
            intent.putExtra("story_id", "bidasari");
            startActivity(intent);
        });

        // 🔹 Tuwaang at Dalaga
        ImageButton tuwaangBtn = findViewById(R.id.imageButton46);
        tuwaangBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PagibigTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "pagibig");
            intent.putExtra("story_id", "tuwaang");
            startActivity(intent);
        });

        // 🔹 Pag-ibig ng Magkapatid
        ImageButton magkapatidBtn = findViewById(R.id.imageButton47);
        magkapatidBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PagibigTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "pagibig");
            intent.putExtra("story_id", "magkapatid");
            startActivity(intent);
        });

        // 🔹 Pagpapatawad sa Digmaan
        ImageButton digmaanBtn = findViewById(R.id.imageButton48);
        digmaanBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PagibigTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "epiko");
            intent.putExtra("category", "pagibig");
            intent.putExtra("story_id", "digmaan");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView13);
        AnimationHelper.animateFloat(header);
    }
}
