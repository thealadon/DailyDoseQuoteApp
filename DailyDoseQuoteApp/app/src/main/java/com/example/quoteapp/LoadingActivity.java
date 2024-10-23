package com.example.quoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // Start loading animation
        //ImageView loadingImage = findViewById(R.id.loading_image);
        //loadingImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.loading_animation));

        // Initialize ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // Simulate loading process
        new Handler().postDelayed(() -> {
            // Hide ProgressBar after loading
            progressBar.setVisibility(ProgressBar.GONE);
            // Start your main activity
            Intent intent = new Intent(LoadingActivity.this, MainActivity.class); // Replace with your main activity
            startActivity(intent);
            finish(); // Close this activity
        }, 3000); // Delay for 3 seconds
    }
}
