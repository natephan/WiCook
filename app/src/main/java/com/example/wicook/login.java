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
        add(new Recipe("Chicken", "good",
                R.drawable.chicken, R.drawable.plus, 1));
        add(new Recipe("HotDog", "good", R.drawable.chicken,
                R.drawable.plus, 2));
        add(new Recipe("Pizza", "good", R.drawable.chicken,
                R.drawable.plus, 3));
        add(new Recipe("Burger", "good", R.drawable.chicken,
                R.drawable.plus, 4));
    }};

    protected static ArrayList<String> allCatergories = new ArrayList<String>(){
        {
            add(new String("Favorites"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Resources res = getResources();
        String[] recipeIngredients = res.getStringArray(R.array.Ingredients);
        String[] recipeDesc = res.getStringArray(R.array.smallDescriptions);
        String[] recipeInstr = res.getStringArray(R.array.Instructions);
        String[] recInfo = res.getStringArray(R.array.largeDescriptions);

        createRecipes(recipeIngredients,recipeDesc, recipeInstr, recInfo);


        final Button signIn = (Button) findViewById(R.id.sign_in_button);
        signIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(login.this, home.class);
                startActivity(intent);
            }

        });
    }


    private void createRecipes(String[] ingredients, String[] Desc, String[] instructions, String[] info) {

        for (int i = 0; i < allRecipes.size(); i++) {
            allRecipes.get(i).setDescription(Desc[i]);
        }

        allRecipes.get(0).setInstructions(instructions[0]);
        allRecipes.get(0).setIngredients(ingredients[0]);
        allRecipes.get(0).setInformation(info[0]);
        allRecipes.get(0).setCategory("favorites");
    }
}