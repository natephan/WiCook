package com.example.wicook;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdaptor extends ArrayAdapter<Recipe> implements Filterable {
        private ArrayList<Recipe> recipes;
        private ArrayList<Recipe> filteredRecipes;
        private Context mContext;

    public RecipeAdaptor(@NonNull Context context, ArrayList<Recipe> recipes) {
        super(context,  R.layout.recipe_items, recipes);
        this.recipes = recipes;
        this.filteredRecipes = recipes;
        this.mContext = context;
    }

    @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            int index = position;

            if(convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate
                        (R.layout.recipe_items, parent, false);
            }

            ImageButton recipeImage = convertView.findViewById(R.id.recipeImage);
            TextView title = convertView.findViewById(R.id.recipeName);
            TextView description = convertView.findViewById(R.id.recipeQuickDesc);
            ImageView rating = convertView.findViewById(R.id.recipeRating);

            recipeImage.setImageResource(recipes.get(position).getRecipeImageId());
            title.setText(recipes.get(position).getRecipeName());
            title.setTextColor(Color.BLACK);
            description.setText(recipes.get(position).getDescription());
            description.setTextColor(Color.BLACK);
            rating.setImageResource(recipes.get(position).getRecipeRating());


            return convertView;
        }

        @Override
        public int getCount() {
            return filteredRecipes.size();
        }

        @Nullable
        @Override
        public Recipe getItem(int position) {
            return filteredRecipes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public Filter getFilter() {

            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();

                    if(constraint == null || constraint.length() == 0) {
                        results.count = recipes.size();
                        results.values = recipes;
                    }
                    else {
                        ArrayList<Recipe> filteredResults = new ArrayList<>();
                        String filterString = constraint.toString().toLowerCase();

                        for (Recipe r : recipes) {
                            if (r.getRecipeName().toLowerCase().contains(filterString)){
                                filteredResults.add(r);
                            }
                        }
                        results.count = filteredResults.size();
                        results.values = filteredResults;
                    }

                    return results;
                }

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    if (results.count ==0) {
                        notifyDataSetInvalidated();
                    } else {
                        filteredRecipes = (ArrayList<Recipe>) results.values;

                        notifyDataSetChanged();
                        clear();
                        for (Recipe r : filteredRecipes) {
                            add(r);
                        }
                    }

                }
            };
        }



};

