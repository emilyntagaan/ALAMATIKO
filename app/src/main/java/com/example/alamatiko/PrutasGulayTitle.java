package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PrutasGulayTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prutas_gulay_title);

        UIHelpers.setupUniversalBackButton(this);

        // 🔹 Pinya Button
        ImageButton pinyaButton = findViewById(R.id.imageButton34);
        pinyaButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrutasGulayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "prutas_gulay");
            intent.putExtra("story_id", "pinya");
            startActivity(intent);
        });

        // 🔹 Saging Button
        ImageButton sagingButton = findViewById(R.id.imageButton35);
        sagingButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrutasGulayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "prutas_gulay");
            intent.putExtra("story_id", "saging");
            startActivity(intent);
        });

        // 🔹 Mangga Button
        ImageButton manggaButton = findViewById(R.id.imageButton36);
        manggaButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrutasGulayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "prutas_gulay");
            intent.putExtra("story_id", "mangga");
            startActivity(intent);
        });

        // 🔹 Bayabas Button
        ImageButton bayabasButton = findViewById(R.id.imageButton37);
        bayabasButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrutasGulayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "prutas_gulay");
            intent.putExtra("story_id", "bayabas");
            startActivity(intent);
        });

        // 🔹 Ampalaya Button
        ImageButton ampalayaButton = findViewById(R.id.imageButton38);
        ampalayaButton.setOnClickListener(v -> {
            Intent intent = new Intent(PrutasGulayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "prutas_gulay");
            intent.putExtra("story_id", "ampalaya");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView16);
        AnimationHelper.animateFloat(header);
    }
}
