package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class social extends AppCompatActivity {

    protected static ArrayList<String> friendNames = new ArrayList<String>(){
        {
            add("Derrick Jones");
            add("Hannah Williams");
            add("Tim Baker");
            add("Zach Bryan");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);
        final ImageButton navSocial= (ImageButton) findViewById(R.id.pageSocialBtn);
        navSocial.setBackgroundResource(R.color.activeMenu);


        ListView feed = (ListView) findViewById(R.id.feed_list_view);
        feedAdapter adapter = new feedAdapter(getApplicationContext(), friendNames);
        feed.setAdapter(adapter);

        final Button friendTab = (Button) findViewById(R.id.friends_tab);
        friendTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(social.this, friends.class);
                startActivity(intent);
            }
        });

        final ImageButton navHome = (ImageButton) findViewById(R.id.pageHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(social.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton navCookbook = (ImageButton) findViewById(R.id.pageCBookBtn);
        navCookbook.setOnClickListener(e-> {
            Intent intent = new Intent(social.this, cookbook.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.pageExplorBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(social.this, explore.class);
            startActivity(intent);
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(e->{
            Intent intent = new Intent(social.this, settings.class);
            startActivity(intent);
        });

    }
}