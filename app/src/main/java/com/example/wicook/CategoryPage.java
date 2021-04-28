package com.example.wicook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryPage extends AppCompatActivity {
    ArrayList<Recipe> savedRecipes = new ArrayList<Recipe>();
    ListView listView;
    TextView catName;
    RecipeAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_page);

        String name = getIntent().getStringExtra("CAT_NAME");
        catName = (TextView) findViewById(R.id.catTitle);
        catName.setText(name);


        for (Recipe r : login.allRecipes) {
            String temp = r.getCategory().toLowerCase();
            if (temp.equals(name.toLowerCase())){
                Recipe r_temp = new Recipe(r.getRecipeName(), r.getDescription(), r.getRecipeImageId(), r.getRecipeRating(), r.id);
                savedRecipes.add(r_temp);
            }
        }

        if (savedRecipes.size() <= 0) {
            TextView msg = (TextView) findViewById(R.id.defaultTextCatPage);
            msg.setText("No recipes to display");
        }
        else {
            adaptor = new RecipeAdaptor(getApplicationContext(), savedRecipes);
            listView = (ListView) findViewById(R.id.catPageListV);
            listView.setAdapter(adaptor);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Recipe r = login.allRecipes.get(position);

                Intent intent = new Intent(CategoryPage.this, RecipePage.class);
                intent.putExtra("R_NAME", r.getRecipeName());
                intent.putExtra("R_DESC", r.getDescription());
                intent.putExtra("R_INST", r.getInstructions());
                intent.putExtra("R_INGR", r.getIngredients());
                intent.putExtra("R_INFO", r.getInformation());
                intent.putExtra("R_ID", r.id);
                intent.putExtra("R_CLASS", "CategoryPage");
                startActivity(intent);
            }
        });

        final ImageButton backBtn = (ImageButton) findViewById(R.id.catPageBackBtn);
        backBtn.setOnClickListener(e->{
            Intent intent = new Intent(CategoryPage.this, cookbook.class);
            startActivity(intent);
        });




    }
}