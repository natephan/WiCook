package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class friends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        final ImageButton home = (ImageButton) findViewById(R.id.friend_home_button);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton explore = (ImageButton) findViewById(R.id.friend_explore_button);
        explore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, explore.class);
                startActivity(intent);
            }
        });

        final ImageButton cookbook = (ImageButton) findViewById(R.id.friend_cookbook_button);
        cookbook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, cookbook.class);
                startActivity(intent);
            }
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.friends_settings_button);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, settings.class);
                startActivity(intent);
            }
        });
    }
}