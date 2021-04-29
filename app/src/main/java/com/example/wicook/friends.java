package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class friends extends AppCompatActivity {

    protected static ArrayList<String> friendNames = new ArrayList<String>(){
        {
            add("Derrick Jones");
            add("Hannah Williams");
            add("Tim Baker");
            add("Zach Bryan");

        }
    };

    protected static friendsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        ListView friendsList = (ListView) findViewById(R.id.friends_list_view);
        adapter = new friendsAdapter(getApplicationContext(), friendNames);
        friendsList.setAdapter(adapter);

        ImageButton addFriend = (ImageButton) findViewById(R.id.add_friend_button);
        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, addFriend.class);
                startActivity(intent);
            }
        });

        final Button feedTab = (Button) findViewById(R.id.feed_tab);
        feedTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, social.class);
                startActivity(intent);
            }
        });

        final ImageButton navHome = (ImageButton) findViewById(R.id.pageHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(friends.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton navCookbook = (ImageButton) findViewById(R.id.pageCBookBtn);
        navCookbook.setOnClickListener(e-> {
            Intent intent = new Intent(friends.this, cookbook.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.pageExplorBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(friends.this, explore.class);
            startActivity(intent);
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settings_button);
        settings.setOnClickListener(e->{
            Intent intent = new Intent(friends.this, settings.class);
            startActivity(intent);
        });

    }
}