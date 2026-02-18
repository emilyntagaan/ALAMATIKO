package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HalamanTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamantitle);

        UIHelpers.setupUniversalBackButton(this);

        // Narra button
        ImageButton narraButton = findViewById(R.id.imageButton24);
        narraButton.setOnClickListener(v -> {
            Intent intent = new Intent(HalamanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "halaman");
            intent.putExtra("story_id", "narra");
            startActivity(intent);
        });

        // Kawayan button
        ImageButton kawayanButton = findViewById(R.id.imageButton25);
        kawayanButton.setOnClickListener(v -> {
            Intent intent = new Intent(HalamanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "halaman");
            intent.putExtra("story_id", "kawayan");
            startActivity(intent);
        });

        // Sampaguita button
        ImageButton sampaguitaButton = findViewById(R.id.imageButton26);
        sampaguitaButton.setOnClickListener(v -> {
            Intent intent = new Intent(HalamanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "halaman");
            intent.putExtra("story_id", "sampaguita");
            startActivity(intent);
        });

        // Waling-waling button
        ImageButton walingButton = findViewById(R.id.imageButton27);
        walingButton.setOnClickListener(v -> {
            Intent intent = new Intent(HalamanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "halaman");
            intent.putExtra("story_id", "walingwaling");
            startActivity(intent);
        });

        // Ilang-Ilang button
        ImageButton ilangButton = findViewById(R.id.imageButton28);
        ilangButton.setOnClickListener(v -> {
            Intent intent = new Intent(HalamanTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "halaman");
            intent.putExtra("story_id", "ilangilang");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView16);
        AnimationHelper.animateFloat(header);
    }
}
