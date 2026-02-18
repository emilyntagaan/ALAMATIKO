package com.example.alamatiko;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import fi.harism.curl.CurlPage;
import fi.harism.curl.CurlView;

public class EmptyBook extends AppCompatActivity {

    private String[] pageFiles;
    private String storyFolder;
    private AssetManager assetManager;
    private MediaPlayer mediaPlayer;
    private ImageButton fairyButton;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_empty_book);

        // --- Edge to edge padding ---
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        UIHelpers.setupUniversalBackButton(this);


        // --- Get story ID from Intent ---
        String taleType = getIntent().getStringExtra("tale_type");
        String storyId = getIntent().getStringExtra("story_id");
        String category = getIntent().getStringExtra("category");

        if (taleType == null) taleType = "alamat";
        if (storyId == null) storyId = "default";
        if (category == null) category = "hayop";

        // --- Prepare narration file ---
        String audioName = taleType + "_" + category + "_" + storyId;
        int resId = getResources().getIdentifier(audioName, "raw", getPackageName());

        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(this, resId);
        }

        // --- Setup fairy button ---
        fairyButton = findViewById(R.id.fairyNarrate);
        fairyButton.setOnClickListener(v -> {
            if (mediaPlayer == null) return;

            if (isPlaying) {
                mediaPlayer.pause();
                isPlaying = false;
            } else {
                mediaPlayer.start();
                isPlaying = true;
            }
        });

        // --- Determine folder path for pages ---
        storyFolder = "stories/" + taleType + "/" + category + "/" + storyId;

        assetManager = getAssets();
        try {
            pageFiles = assetManager.list(storyFolder);
            if (pageFiles != null) Arrays.sort(pageFiles);
        } catch (IOException e) {
            e.printStackTrace();
            pageFiles = new String[0];
        }

        // --- Setup CurlView ---
        CurlView curlView = findViewById(R.id.page);
        curlView.setPageProvider(new PageProvider());

        curlView.setAllowLastPageCurl(false);
        int startIndex = 0;
        if (pageFiles != null && pageFiles.length > 0) {
            startIndex = Math.max(0, Math.min(startIndex, pageFiles.length - 1));
        }
        curlView.setCurrentIndex(startIndex);

//        curlView.setCurrentIndex(0);

        curlView.setSizeChangedObserver((width, height) -> {
            // handle resizing if needed
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        MusicService.lowerVolume();  // <-- Lower background music when EmptyBook is visible
    }

    @Override
    protected void onStop() {
        super.onStop();
        MusicService.restoreVolume();  // <-- Restore background music when leaving EmptyBook
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // --- PageProvider ---
    private class PageProvider implements CurlView.PageProvider {

        @Override
        public int getPageCount() {
            return pageFiles.length;
        }

        @Override
        public void updatePage(CurlPage page, int width, int height, int index) {
            if (pageFiles.length == 0) return;

            Bitmap front = null;
            try {
                InputStream is = assetManager.open(storyFolder + "/" + pageFiles[index]);
                front = BitmapFactory.decodeStream(is);
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            if (front != null) {
//                front = cropTransparentArea(front);
//                front = Bitmap.createScaledBitmap(front, width, height, true);
//                page.setTexture(front, CurlPage.SIDE_FRONT);
//            }

            if (front != null) {
                front = cropTransparentArea(front);
                front = fillTransparentPixels(front); // 👈 this fills the transparent areas
                front = Bitmap.createScaledBitmap(front, width, height, true);
                page.setTexture(front, CurlPage.SIDE_FRONT);
            }

            int dominantColor = getDominantColor(front);
            Bitmap back = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            back.eraseColor(dominantColor);

            CurlView curlView = findViewById(R.id.page);
            curlView.setBackgroundColor(Color.TRANSPARENT);

            page.setTexture(back, CurlPage.SIDE_BACK);
        }

        private Bitmap fillTransparentPixels(Bitmap src) {
            int width = src.getWidth();
            int height = src.getHeight();
            Bitmap result = src.copy(Bitmap.Config.ARGB_8888, true);
            int[] pixels = new int[width * height];
            result.getPixels(pixels, 0, width, 0, 0, width, height);

            // Compute the average color of *non-transparent* pixels
            long rSum = 0, gSum = 0, bSum = 0, count = 0;
            for (int color : pixels) {
                int alpha = (color >> 24) & 0xFF;
                if (alpha > 0) { // non-transparent
                    rSum += (color >> 16) & 0xFF;
                    gSum += (color >> 8) & 0xFF;
                    bSum += color & 0xFF;
                    count++;
                }
            }

            int avgColor = Color.BLACK;
            if (count > 0) {
                int r = (int) (rSum / count);
                int g = (int) (gSum / count);
                int b = (int) (bSum / count);
                avgColor = Color.rgb(r, g, b);
            }

            // Replace fully transparent pixels with the average color
            for (int i = 0; i < pixels.length; i++) {
                int alpha = (pixels[i] >> 24) & 0xFF;
                if (alpha == 0) {
                    pixels[i] = (0xFF << 24) | (avgColor & 0xFFFFFF);
                }
            }

            result.setPixels(pixels, 0, width, 0, 0, width, height);
            return result;
        }

        private Bitmap cropTransparentArea(Bitmap source) {
            int width = source.getWidth();
            int height = source.getHeight();
            int minX = width, minY = height, maxX = -1, maxY = -1;
            int[] pixels = new int[width * height];
            source.getPixels(pixels, 0, width, 0, 0, width, height);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int alpha = (pixels[y * width + x] >> 24) & 0xff;
                    if (alpha > 10) {
                        if (x < minX) minX = x;
                        if (x > maxX) maxX = x;
                        if (y < minY) minY = y;
                        if (y > maxY) maxY = y;
                    }
                }
            }

            if (maxX < minX || maxY < minY) return source;

            return Bitmap.createBitmap(source, minX, minY, maxX - minX + 1, maxY - minY + 1);
        }

        private int getDominantColor(Bitmap bitmap) {
            if (bitmap == null) return Color.WHITE;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int size = width * height;
            int[] pixels = new int[size];
            bitmap.getPixels(pixels, 0, width, 0, 0, width, height);

            long r = 0, g = 0, b = 0;
            int count = 0;
            for (int i = 0; i < size; i++) {
                int c = pixels[i];
                int alpha = Color.alpha(c);
                if (alpha > 50) {
                    r += Color.red(c);
                    g += Color.green(c);
                    b += Color.blue(c);
                    count++;
                }
            }

            if (count == 0) return Color.WHITE;
            return Color.rgb((int)(r / count), (int)(g / count), (int)(b / count));
        }

        @Override
        public void onPageSizeChanged(int width, int height) {}
    }
}
