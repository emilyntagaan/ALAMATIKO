package com.example.alamatiko;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Handler;
import android.view.View;

import java.util.Random;

public class AnimationHelper {

    private static final Random random = new Random();

    // 🧚 Floating up and down with optional delay
    public static void animateFloat(final View view) {
        animateFloat(view, random.nextInt(1500)); // random delay between 0–1500ms
    }

    public static void animateFloat(final View view, long delay) {
        if (view == null) return;

        new Handler().postDelayed(() -> {
            view.animate()
                    .translationYBy(-50f)
                    .setDuration(1500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.animate()
                                    .translationYBy(50f)
                                    .setDuration(1500)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);
                                            // Repeat forever
                                            animateFloat(view, 0);
                                        }
                                    });
                        }
                    });
        }, delay);
    }

    // 💫 Pulse animation with random delay
    public static void animatePulse(final View view) {
        animatePulse(view, random.nextInt(1000)); // 0–1s random delay
    }

    public static void animatePulse(final View view, long delay) {
        if (view == null) return;

        new Handler().postDelayed(() -> {
            view.animate()
                    .scaleX(1.1f)
                    .scaleY(1.1f)
                    .setDuration(700)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(700)
                                    .setListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);
                                            animatePulse(view, 0);
                                        }
                                    });
                        }
                    });
        }, delay);
    }
}
