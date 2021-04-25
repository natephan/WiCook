package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


public class explore extends AppCompatActivity {
    private ImageButton exploreBtn;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        exploreBtn = (ImageButton) findViewById(R.id.pageExplorBtn);
        exploreBtn.setBackgroundResource(R.color.purple_500);

        searchView = (SearchView) findViewById(R.id.searchBarExplore);


        RecipeAdaptor adaptor = new RecipeAdaptor(getApplicationContext(), login.allRecipes);
        ListView listview = findViewById(R.id.exploreListView);
        listview.setAdapter(adaptor);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(explore.this, RecipePage.class);
                startActivity(intent);
            }
        });



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adaptor.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        final ImageButton navHome = (ImageButton) findViewById(R.id.pageHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(explore.this, home.class);

                startActivity(intent);
            }
        });

        final ImageButton navSocial = (ImageButton) findViewById(R.id.pageSocialBtn);
        navSocial.setOnClickListener(e-> {
            Intent intent = new Intent(explore.this, social.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.pageCBookBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(explore.this, cookbook.class);
            startActivity(intent);
        });
    }

}