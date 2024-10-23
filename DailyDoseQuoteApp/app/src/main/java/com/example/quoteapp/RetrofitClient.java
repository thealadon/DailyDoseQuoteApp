package com.example.quoteapp;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// RetrofitClient class responsible for creating and managing the Retrofit instance
public class RetrofitClient {
    private static final String BASE_URL = "http://192.168.1.176:8000/api/"; // Base URL for the API
    private static Retrofit retrofit = null; // Retrofit instance, initialized to null

    // Method to get the Retrofit client instance
    public static Retrofit getClient() {
        // Check if the Retrofit instance is not already created
        if (retrofit == null) {
            // Build an OkHttpClient with specified timeout settings
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS) // Connection timeout
                    .readTimeout(30, TimeUnit.SECONDS)    // Read timeout
                    .writeTimeout(30, TimeUnit.SECONDS)   // Write timeout
                    .build();

            // Create the Retrofit instance
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // Set the base URL
                    .client(okHttpClient) // Set the OkHttpClient
                    .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter for JSON parsing
                    .build();
        }
        return retrofit; // Return the Retrofit instance
    }
}
