package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        final ImageButton home = (ImageButton) findViewById(R.id.home_nav);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton explore_button = (ImageButton) findViewById(R.id.explore_nav);
        explore_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, explore.class);
                startActivity(intent);
            }
        });

        final ImageButton cookbook = (ImageButton) findViewById(R.id.cookbook_nav);
        cookbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, cookbook.class);
                startActivity(intent);
            }
        });

        final TextView feed_button = (TextView) findViewById(R.id.feed_button);
        feed_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, social.class);
                startActivity(intent);
            }
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, settings.class);
                startActivity(intent);
            }
        });

        final Button friends = (Button) findViewById(R.id.friends_button);
        friends.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(profile.this, friends.class);
                startActivity(intent);
            }
        });
    }
}