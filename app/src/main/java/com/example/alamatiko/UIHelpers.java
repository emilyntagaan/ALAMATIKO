package com.example.alamatiko;

import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class UIHelpers {

    public static void setupUniversalBackButton(AppCompatActivity activity) {
        ImageButton backButton = activity.findViewById(R.id.imageButton66);
        if (backButton != null) {
            backButton.setOnClickListener(v -> activity.onBackPressed());
        }
    }
}