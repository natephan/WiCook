package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class social extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);

        final ImageButton home = (ImageButton) findViewById(R.id.home_nav);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(social.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton explore_button = (ImageButton) findViewById(R.id.explore_nav);
        explore_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(social.this, explore.class);
                startActivity(intent);
            }
        });

        final ImageButton cookbook = (ImageButton) findViewById(R.id.cookbook_nav);
        cookbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(social.this, cookbook.class);
                startActivity(intent);
            }
        });

        final TextView profile_button = (TextView) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(social.this, profile.class);
                startActivity(intent);
            }
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(social.this, settings.class);
                startActivity(intent);
            }
        });
    }
}