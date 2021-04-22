package com.example.wicook;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class explore extends AppCompatActivity {
    ImageButton exploreBtn;

    protected ArrayList<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        exploreBtn = (ImageButton) findViewById(R.id.EnavExplorBtn);
        exploreBtn.setBackgroundColor(Color.parseColor("#816DA5"));

        recipes = new ArrayList<>();

        Resources res = getResources();
        String[] recipeTitles = res.getStringArray(R.array.recipes);
        String[] recipeDesc = res.getStringArray(R.array.Descriptions);

        createRecipes(recipeTitles, recipeDesc);

        RecipeAdaptor adaptor = new RecipeAdaptor(getApplicationContext(), recipes);
        ListView listview = findViewById(R.id.exploreListView);
        listview.setAdapter(adaptor);

        final ImageButton navHome = (ImageButton) findViewById(R.id.EnavHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton navSocial = (ImageButton) findViewById(R.id.EnavSocialBtn);
        navSocial.setOnClickListener(e-> {
            Intent intent = new Intent(explore.this, social.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.EnavCBookBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(explore.this, cookbook.class);
            startActivity(intent);
        });
    }

    private void createRecipes(String[] recipeTitles, String[] recipeDesc) {

        recipes.add(new Recipe(recipeTitles[0], recipeDesc[0], R.drawable.chicken, R.drawable.plus));
    }
}