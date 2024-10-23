package com.example.quoteapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter class for displaying a list of emotions in a RecyclerView
public class EmotionAdapter extends RecyclerView.Adapter<EmotionAdapter.ViewHolder> {

    private final List<String> emotions; // List of emotions to be displayed
    private int selectedPosition = -1; // Position of the currently selected emotion

    // Constructor to initialize the emotions list
    public EmotionAdapter(List<String> emotions) {
        this.emotions = emotions; // Assign the list of emotions to the adapter
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each emotion
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emotion, parent, false);
        return new ViewHolder(view); // Return a new ViewHolder instance
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the text of the emotion item
        String emotion = emotions.get(position);
        holder.emotionItem.setText(emotion);

        // Set the appropriate icon based on the emotion
        switch (emotion) {
            case "Scared":
                holder.emotionIcon.setImageResource(R.drawable.ic_scared);
                break;
            case "Sad":
                holder.emotionIcon.setImageResource(R.drawable.ic_sad);
                break;
            case "Tired":
                holder.emotionIcon.setImageResource(R.drawable.ic_tired);
                break;
            case "Anxious":
                holder.emotionIcon.setImageResource(R.drawable.ic_anxious);
                break;
            default:
                holder.emotionIcon.setImageResource(R.drawable.ic_launcher_background); // Default icon
                break;
        }

        // Change the background color if this item is selected, using color resources
        holder.itemView.setBackgroundColor(selectedPosition == position ?
                ContextCompat.getColor(holder.itemView.getContext(), R.color.white) :
                ContextCompat.getColor(holder.itemView.getContext(), R.color.lightgray));

        // Set an OnClickListener to handle item selection
        holder.itemView.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition(); // Update selected position
            notifyDataSetChanged(); // Refresh the RecyclerView to reflect changes
        });
    }

    @Override
    public int getItemCount() {
        return emotions.size(); // Return the total number of emotions
    }

    // Method to get the currently selected emotion
    public String getSelectedEmotion() {
        // Return the selected emotion or null if none is selected
        return selectedPosition != -1 ? emotions.get(selectedPosition) : null;
    }

    // ViewHolder class to hold and bind views for each emotion item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView emotionItem; // TextView for displaying the emotion text
        ImageView emotionIcon; // ImageView for displaying the emotion icon

        // Constructor to initialize the ViewHolder with the item view
        public ViewHolder(View itemView) {
            super(itemView);
            // Find the TextView and ImageView within the item layout
            emotionItem = itemView.findViewById(R.id.emotion_item);
            emotionIcon = itemView.findViewById(R.id.emotion_icon);
        }
    }
}
