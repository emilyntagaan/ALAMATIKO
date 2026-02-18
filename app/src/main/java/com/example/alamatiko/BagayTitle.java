package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BagayTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagay_title); // link sa bagay_title.xml

        UIHelpers.setupUniversalBackButton(this);

        // Gitara button
        ImageButton gitaraButton = findViewById(R.id.imageButton29);
        gitaraButton.setOnClickListener(v -> {
            Intent intent = new Intent(BagayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "bagay");
            intent.putExtra("story_id", "gitara");
            startActivity(intent);
        });

        // Salamin button
        ImageButton salaminButton = findViewById(R.id.imageButton30);
        salaminButton.setOnClickListener(v -> {
            Intent intent = new Intent(BagayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "bagay");
            intent.putExtra("story_id", "salamin");
            startActivity(intent);
        });

        // Alahas button
        ImageButton alahasButton = findViewById(R.id.imageButton31);
        alahasButton.setOnClickListener(v -> {
            Intent intent = new Intent(BagayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "bagay");
            intent.putExtra("story_id", "alahas");
            startActivity(intent);
        });

        // Piso button
        ImageButton pisoButton = findViewById(R.id.imageButton32);
        pisoButton.setOnClickListener(v -> {
            Intent intent = new Intent(BagayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "bagay");
            intent.putExtra("story_id", "piso");
            startActivity(intent);
        });

        // Paminggalan button
        ImageButton paminggalanButton = findViewById(R.id.imageButton33);
        paminggalanButton.setOnClickListener(v -> {
            Intent intent = new Intent(BagayTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "bagay");
            intent.putExtra("story_id", "paminggalan");
            startActivity(intent);
        });

        ImageView header = findViewById(R.id.imageView16);
        AnimationHelper.animateFloat(header);
    }
}
