package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class meat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meat);

        final ImageButton home = (ImageButton) findViewById(R.id.home_nav);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(meat.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton explore_button = (ImageButton) findViewById(R.id.explore_nav);
        explore_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(meat.this, explore.class);
                startActivity(intent);
            }
        });

        final ImageButton social_button = (ImageButton) findViewById(R.id.social_nav);
        social_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(meat.this, social.class);
                startActivity(intent);
            }
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(meat.this, settings.class);
                startActivity(intent);
            }
        });

        final TextView history = (TextView) findViewById(R.id.history_tab);
        history.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(meat.this, history.class);
                startActivity(intent);
            }
        });

    }
}