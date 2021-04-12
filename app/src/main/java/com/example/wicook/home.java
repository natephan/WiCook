package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final ImageButton settings = (ImageButton) findViewById(R.id.home_settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, settings.class);
                startActivity(intent);
            }
        });

        final Button explore_button = (Button) findViewById(R.id.home_explore_button);
        explore_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, explore.class);
                startActivity(intent);
            }
        });

        final Button social_button = (Button) findViewById(R.id.home_social_button);
        social_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, social.class);
                startActivity(intent);
            }
        });

        final Button cookbook = (Button) findViewById(R.id.home_cookbook_button);
        cookbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, cookbook.class);
                startActivity(intent);
            }
        });
    }
}