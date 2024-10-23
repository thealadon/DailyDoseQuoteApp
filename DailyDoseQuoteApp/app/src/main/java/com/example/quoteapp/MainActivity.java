package com.example.quoteapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// MainActivity class for displaying emotions and categories and retrieving quotes
public class MainActivity extends AppCompatActivity {

    private EmotionAdapter emotionAdapter; // Adapter for emotion selection
    private CategoryAdapter categoryAdapter; // Adapter for category selection
    private ApiService apiService; // API service instance for fetching quotes
    private static final String CHANNEL_ID = "quote_channel"; // Notification channel ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lists of emotions and categories
        List<String> emotions = Arrays.asList("Scared", "Sad", "Tired", "Anxious");
        List<String> categories = Arrays.asList("Finance", "Education", "Relationship", "Work", "Friendship", "Family");

        // Set up RecyclerViews for emotions and categories
        RecyclerView emotionsRecyclerView = findViewById(R.id.emotionsRecyclerView);
        RecyclerView categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        Button submitButton = findViewById(R.id.submitButton);

        // Configure RecyclerView for emotions
        emotionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        emotionAdapter = new EmotionAdapter(emotions);
        emotionsRecyclerView.setAdapter(emotionAdapter);

        // Configure RecyclerView for categories
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(categories);
        categoriesRecyclerView.setAdapter(categoryAdapter);

        // Create Retrofit instance with error handling
        try {
            apiService = RetrofitClient.getClient().create(ApiService.class);
        } catch (Exception e) {
            Toast.makeText(this, "Failed to create API service: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            return; // Exit early to prevent further errors
        }

        // Create notification channel for quotes
        createNotificationChannel();

        // Set up submit button click listener
        submitButton.setOnClickListener(v -> {
            String selectedEmotion = emotionAdapter.getSelectedEmotion();
            String selectedCategory = categoryAdapter.getSelectedCategory();

            // Check if both emotion and category are selected
            if (selectedEmotion != null && selectedCategory != null) {
                getQuote(selectedEmotion, selectedCategory); // Fetch quote based on selections
                Toast.makeText(this, "Request Submitted! Please check Notification!", Toast.LENGTH_SHORT).show(); // Show the submit request message
            } else {
                Toast.makeText(this, "Please select both emotion and category", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to create notification channel for quotes
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Quote Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel for quote notifications");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel); // Register the channel
        }
    }

    // Method to fetch a quote based on the selected emotion and category
    private void getQuote(String emotion, String category) {
        apiService.getQuote(emotion, category).enqueue(new Callback<Quote>() {
            @Override
            public void onResponse(Call<Quote> call, Response<Quote> response) {
                if (response.isSuccessful() && response.body() != null) {
                    showNotification(response.body()); // Show notification with the fetched quote
                } else {
                    String errorMessage = "Error: " + response.message();
                    // Handle errors based on the response status code
                    switch (response.code()) {
                        case 404:
                            errorMessage = "Quote not found for the selected emotion and category.";
                            break;
                        case 500:
                            errorMessage = "Server error, please try again later.";
                            break;
                        default:
                            errorMessage = "Unexpected error: " + response.message();
                            break;
                    }
                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show(); // Show error message
                }
            }

            @Override
            public void onFailure(Call<Quote> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch quote: " + t.getMessage(), Toast.LENGTH_SHORT).show(); // Show failure message
            }
        });
    }

    // Method to show notification with the fetched quote
    private void showNotification(Quote quote) {
        // Create an explicit intent for the NotificationActivity to open when the notification is tapped
        Intent intent = new Intent(this, NotificationActivity.class); // Replace NotificationActivity with the appropriate activity
        intent.putExtra("quote", quote.getQuote()); // Pass the quote text to the activity
        intent.putExtra("author", quote.getAuthor()); // Pass the author of the quote
        intent.putExtra("category", quote.getCategory()); // Pass the category of the quote

        // Create a PendingIntent for the notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) // Set notification icon
                .setContentTitle(quote.getAuthor()) // Set notification title to the author's name
                .setContentText(quote.getQuote()) // Set notification content to the quote text
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Set notification priority
                .setAutoCancel(true) // Dismiss notification when tapped
                .setContentIntent(pendingIntent); // Set the intent to be fired when the notification is tapped

        // Show the notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build()); // Show notification with a unique ID
    }
}
