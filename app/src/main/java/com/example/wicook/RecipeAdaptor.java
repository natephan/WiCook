package com.example.wicook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class RecipeAdaptor extends ArrayAdapter<Recipe> {
        private ArrayList<Recipe> recipes;
        private Context mContext;

        public RecipeAdaptor(@NonNull Context context, ArrayList<Recipe> recipes) {
            super(context, R.layout.recipe_items, recipes);
            this.recipes = recipes;
            this.mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            int index = position;

            if(convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate
                        (R.layout.recipe_items, parent, false);
            }

            ImageButton recipeImage = convertView.findViewById(R.id.recipeImage);
            TextView title = convertView.findViewById(R.id.recipeName);
            TextView description = convertView.findViewById(R.id.recipeQuickDesc);
            ImageView rating = convertView.findViewById(R.id.recipeRating);

            recipeImage.setImageResource(recipes.get(position).getRecipeImageId());
            title.setText(recipes.get(position).getRecipeName());
            description.setText(recipes.get(position).getDescription());
            rating.setImageResource(recipes.get(position).getRecipeRating());


            return convertView;
        }
}

