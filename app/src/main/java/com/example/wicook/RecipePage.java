package com.example.wicook;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecipePage extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipepage);

        String recipeName = getIntent().getStringExtra("R_NAME");
        TextView rName = (TextView) findViewById(R.id.recipeNamePage);
        rName.setText(recipeName);

        String recipeInstr = getIntent().getStringExtra("R_INST");
        TextView instructions = (TextView) findViewById(R.id.recInstructPage);
        instructions.setText(recipeInstr);

        String recipeIngr = getIntent().getStringExtra("R_INGR");
        TextView ingredients = (TextView) findViewById(R.id.pageIngredients);
        ingredients.setText(recipeIngr);

        String recInfo = getIntent().getStringExtra("R_INFO");
        TextView info = (TextView) findViewById(R.id.recInfoPage);
        info.setText(recInfo);

        int id = getIntent().getIntExtra("R_ID", 0);
        String r_name = getIntent().getStringExtra("R_NAME");

        int isSaved = getIntent().getIntExtra("IS_SAVED", 0);

        Button addBtn = (Button) findViewById(R.id.addRecipeBtn);
        if (isSaved == 1) {
            addBtn.setBackgroundColor(0xFFBB86FC);
            addBtn.setText(R.string.savedBtn);
            addBtn.setEnabled(false);
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipePage.this, SaveRecipeWindow.class);
                intent.putExtra("R_ID", id);
                intent.putExtra("R_NAME", r_name);
                intent.putExtra("R_INST", recipeInstr);
                intent.putExtra("R_INGR", recipeIngr);
                intent.putExtra("R_INFO", recInfo);
                startActivity(intent);
            }
        });


        final ImageButton navHome = (ImageButton) findViewById(R.id.pageHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipePage.this, home.class);

                startActivity(intent);
            }
        });

        final ImageButton navSocial = (ImageButton) findViewById(R.id.pageSocialBtn);
        navSocial.setOnClickListener(e-> {
            Intent intent = new Intent(RecipePage.this, social.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.pageCBookBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(RecipePage.this, cookbook.class);
            startActivity(intent);
        });


    }
}