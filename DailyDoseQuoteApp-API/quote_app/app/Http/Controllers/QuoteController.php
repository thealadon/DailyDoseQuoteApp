<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Quote;

class QuoteController extends Controller
{
    public function getQuotes(Request $request)
    {
         // Retrieve the emotion and category from the query parameters
        $emotion = $request->query('emotion');
        $category = $request->query('category');
        
        // Fetch a random quote that matches the emotion and category
        $quote = Quote::where('emotions', $emotion)
                    ->where('category', $category)
                    ->inRandomOrder()// This will randomize the selection
                    ->first();// Fetch only one random quote

        return response()->json($quote);// Return the quote as a JSON response
    }
}
