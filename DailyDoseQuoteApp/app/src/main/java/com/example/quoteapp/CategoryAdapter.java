package com.example.quoteapp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter class for displaying a list of categories in a RecyclerView
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final List<String> categories; // List of categories to be displayed
    private int selectedPosition = -1; // Position of the currently selected category

    // Constructor to initialize the categories list
    public CategoryAdapter(List<String> categories) {
        this.categories = categories; // Assign the list of categories to the adapter
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each category
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view); // Return a new ViewHolder instance
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Set the text of the category item
        holder.categoryItem.setText(categories.get(position));
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
        return categories.size(); // Return the total number of categories
    }

    // Method to get the currently selected category
    public String getSelectedCategory() {
        // Return the selected category or null if none is selected
        return selectedPosition != -1 ? categories.get(selectedPosition) : null;
    }

    // ViewHolder class to hold and bind views for each category item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryItem; // TextView for displaying the category text

        // Constructor to initialize the ViewHolder with the item view
        public ViewHolder(View itemView) {
            super(itemView);
            // Find the TextView within the item layout
            categoryItem = itemView.findViewById(R.id.category_item);
        }
    }
}
