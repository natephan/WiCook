package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SaveRecipeWindow extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_recipe_popup);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int w = metrics.widthPixels;
        int h = metrics.heightPixels;

        getWindow().setLayout((int) (w*.6), (int) (h*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        EditText category = (EditText) findViewById(R.id.categoryTextField);
        EditText tag = (EditText) findViewById(R.id.tagTextField);

        Button savebtn = (Button) findViewById(R.id.saveRecipeInfoBtn);
        Button closeBtn = (Button) findViewById(R.id.closeSavePopUp);

        int id = getIntent().getIntExtra("R_ID", 0);
        String r_name = getIntent().getStringExtra("R_NAME");
        String r_inst = getIntent().getStringExtra("R_INST");
        String r_ingr = getIntent().getStringExtra("R_INGR");
        String r_desc = getIntent().getStringExtra("R_INFO");


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String theCategory = category.getText().toString();
                String theTag = tag.getText().toString();

                if(theCategory.isEmpty()) {
                    Toast.makeText(SaveRecipeWindow.this, "Must specify a category", Toast.LENGTH_LONG).show();
                }
                else if (id > 0){

                    //update recipe with category name
                    login.allRecipes.get(id-1).setCategory(theCategory);
                    //go back to the recipe page
                    Intent intent = new Intent(SaveRecipeWindow.this, RecipePage.class);
                    //send info to recipe page
                    intent.putExtra("R_NAME", r_name);
                    intent.putExtra("R_INST", r_inst);
                    intent.putExtra("R_INGR", r_ingr);
                    intent.putExtra("R_INFO", r_desc);
                    intent.putExtra("R_ID", id);
                    login.allRecipes.get(id-1).isSaved = true;
                    startActivity(intent);

                }
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaveRecipeWindow.this, RecipePage.class);
                intent.putExtra("R_NAME", r_name);
                intent.putExtra("R_INST", r_inst);
                intent.putExtra("R_INGR", r_ingr);
                intent.putExtra("R_INFO", r_desc);
                intent.putExtra("R_ID", id);
                startActivity(intent);
            }
        });


    }


}
