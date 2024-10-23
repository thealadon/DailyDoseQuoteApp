package com.example.quoteapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class NotificationActivity extends AppCompatActivity {

    private ConstraintLayout notificationLayout; // Reference to the entire layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Initialize UI components
        TextView quoteTextView = findViewById(R.id.quoteTextView);
        TextView authorTextView = findViewById(R.id.authorTextView);
        TextView categoryTextView = findViewById(R.id.categoryTextView);
        ImageView copyIcon = findViewById(R.id.copyIcon);
        ImageView saveIcon = findViewById(R.id.saveIcon);
        notificationLayout = findViewById(R.id.notificationLayout); // Get the layout

        // Retrieve the quote, author, and category from the intent
        String quote = getIntent().getStringExtra("quote");
        String author = getIntent().getStringExtra("author");
        String category = getIntent().getStringExtra("category");

        // Display the retrieved data in the TextViews
        quoteTextView.setText(quote);
        authorTextView.setText(author);
        categoryTextView.setText(category);

        // Set up the click listener for the copy icon
        copyIcon.setOnClickListener(v -> {
            String textToCopy = quote + "\n" + author;
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Quote", textToCopy);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(NotificationActivity.this, "Quote copied to clipboard!", Toast.LENGTH_SHORT).show();
        });

        // Set up the click listener for the save icon
        saveIcon.setOnClickListener(v -> saveQuoteAsImage());
    }

    private void saveQuoteAsImage() {
        // Find the copy and save icons
        ImageView copyIcon = findViewById(R.id.copyIcon);
        ImageView saveIcon = findViewById(R.id.saveIcon);

        // Temporarily hide the icons before capturing the layout
        copyIcon.setVisibility(View.INVISIBLE);
        saveIcon.setVisibility(View.INVISIBLE);

        // Create a bitmap from the ConstraintLayout
        Bitmap bitmap = createBitmapFromView(notificationLayout);

        // Restore the icons to their original visibility
        copyIcon.setVisibility(View.VISIBLE);
        saveIcon.setVisibility(View.VISIBLE);

        // Save the image using MediaStore or the old method for older Android versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.DISPLAY_NAME, "quote_" + System.currentTimeMillis() + ".png");
            values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
            values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/Quotes");

            Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            if (uri != null) {
                try (OutputStream out = getContentResolver().openOutputStream(uri)) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    Toast.makeText(this, "Quote saved as image!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            // For Android versions below 10, use the old method
            File dir = new File(Environment.getExternalStorageDirectory(), "Quotes");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "quote_" + System.currentTimeMillis() + ".png");
            try (FileOutputStream out = new FileOutputStream(file)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                Toast.makeText(this, "Quote saved as image!", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to create a bitmap from a view (layout)
    private Bitmap createBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}
