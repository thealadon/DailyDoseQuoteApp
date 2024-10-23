package com.example.quoteapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Interface defining the API service for retrieving quotes
public interface ApiService {
    // Method to get a quote based on the specified emotion and category
    @GET("quotes") // HTTP GET request to the "quotes" endpoint
    Call<Quote> getQuote(@Query("emotion") String emotion, @Query("category") String category);
}
