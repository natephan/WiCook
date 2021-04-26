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

import java.util.ArrayList;


public class explore extends AppCompatActivity {
    private ImageButton exploreBtn;
    private SearchView searchView;
    private ArrayList<Recipe> list = new ArrayList<>(login.allRecipes);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore);

        exploreBtn = (ImageButton) findViewById(R.id.pageExplorBtn);
        exploreBtn.setBackgroundResource(R.color.activeMenu);

        searchView = (SearchView) findViewById(R.id.searchBarExplore);

        RecipeAdaptor adaptor = new RecipeAdaptor(getApplicationContext(), list);
        ListView listview = findViewById(R.id.exploreListView);
        listview.setAdapter(adaptor);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Recipe r = login.allRecipes.get(position);

                Intent intent = new Intent(explore.this, RecipePage.class);
                intent.putExtra("R_NAME", r.getRecipeName());
                intent.putExtra("R_DESC", r.getDescription());
                intent.putExtra("R_INST", r.getInstructions());
                intent.putExtra("R_INGR", r.getIngredients());
                intent.putExtra("R_INFO", r.getInformation());
                intent.putExtra("R_ID", r.id);
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