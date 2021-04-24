package com.example.wicook;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class explore extends AppCompatActivity {
    private ImageButton exploreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        exploreBtn = (ImageButton) findViewById(R.id.EnavExplorBtn);
        exploreBtn.setBackgroundColor(Color.parseColor("#816DA5"));


        RecipeAdaptor adaptor = new RecipeAdaptor(getApplicationContext(), login.allRecipes);
        ListView listview = findViewById(R.id.exploreListView);
        listview.setAdapter(adaptor);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(explore.this, "Clicked on: "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT);
                t.show();
            }
        });

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

}