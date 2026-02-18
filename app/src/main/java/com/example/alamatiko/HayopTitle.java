package com.example.alamatiko;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HayopTitle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayop_title); // link sa hayop_title.xml

        UIHelpers.setupUniversalBackButton(this);

        // Aso button
        ImageButton asoButton = findViewById(R.id.imageButton19);
        asoButton.setOnClickListener(v -> {
            Intent intent = new Intent(HayopTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "hayop");
            intent.putExtra("story_id", "aso");
            startActivity(intent);
        });

        // Daga at Pusa button
        ImageButton dagaPusaButton = findViewById(R.id.imageButton20);
        dagaPusaButton.setOnClickListener(v -> {
            Intent intent = new Intent(HayopTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "hayop");
            intent.putExtra("story_id", "dagaatpusa");
            startActivity(intent);
        });

        // Butiki button
        ImageButton butikiButton = findViewById(R.id.imageButton21);
        butikiButton.setOnClickListener(v -> {
            Intent intent = new Intent(HayopTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "hayop");
            intent.putExtra("story_id", "butiki");
            startActivity(intent);
        });

        // Kalabaw button
        ImageButton kalabawButton = findViewById(R.id.imageButton22);
        kalabawButton.setOnClickListener(v -> {
            Intent intent = new Intent(HayopTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "hayop");
            intent.putExtra("story_id", "kalabaw");
            startActivity(intent);
        });

        // Unggoy button
        ImageButton unggoyButton = findViewById(R.id.imageButton23);
        unggoyButton.setOnClickListener(v -> {
            Intent intent = new Intent(HayopTitle.this, EmptyBook.class);
            intent.putExtra("tale_type", "alamat");
            intent.putExtra("category", "hayop");
            intent.putExtra("story_id", "unggoy");
            startActivity(intent);
        });
        ImageView header = findViewById(R.id.imageView16);
        AnimationHelper.animateFloat(header);
    }
}
