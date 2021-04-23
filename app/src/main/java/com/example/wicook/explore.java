package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        final ImageButton home = (ImageButton) findViewById(R.id.explore_home_button);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton social = (ImageButton) findViewById(R.id.explore_social_button);
        social.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, social.class);
                startActivity(intent);
            }
        });

        final ImageButton cookbook = (ImageButton) findViewById(R.id.explore_cookbook_button);
        cookbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, cookbook.class);
                startActivity(intent);
            }
        });

        final ImageButton chicken = (ImageButton) findViewById(R.id.explore_chicken_button);
        chicken.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, recipe.class);
                startActivity(intent);
            }
        });

        final ImageButton search = (ImageButton) findViewById(R.id.explore_search_button);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, search.class);
                startActivity(intent);
            }
        });
    }
}