package com.example.wicook;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    protected static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>() {{
        add(new Recipe("Chicken", "good", R.drawable.chicken, R.drawable.plus));
        add(new Recipe("Fried Chicken", "good", R.drawable.chicken, R.drawable.plus));
        add(new Recipe("Grilled Chicken", "good", R.drawable.chicken, R.drawable.plus));
        add(new Recipe("Chicken Tenders", "good", R.drawable.chicken, R.drawable.plus));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /*
        Resources res = getResources();
        String[] recipeTitles = res.getStringArray(R.array.recipes);
        String[] recipeDesc = res.getStringArray(R.array.Descriptions);

        createRecipes(recipeTitles, recipeDesc);
         */

        final Button signIn = (Button) findViewById(R.id.sign_in_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(login.this, home.class);
                startActivity(intent);
            }

        });
    }

    /*
    private void createRecipes(String[] recipeTitles, String[] recipeDesc) {

        allRecipes.add(new Recipe(recipeTitles[0], recipeDesc[0], R.drawable.chicken, R.drawable.plus));
    }

     */
}