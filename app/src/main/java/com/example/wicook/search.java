package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class search extends AppCompatActivity {

    SearchView m_searchView;
    ListView m_recipeList;
    ArrayList<String> recipeNamesList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        m_searchView = (SearchView)findViewById(R.id.searchView);
        m_recipeList = (ListView)findViewById(R.id.recipeList);
        recipeNamesList = new ArrayList<String>();

        recipeNamesList.add("Burger");
        recipeNamesList.add("Salmon");
        recipeNamesList.add("Fried Chicken");
        recipeNamesList.add("Shrimp");
        recipeNamesList.add("Grilled Fish");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,recipeNamesList);
        m_recipeList.setAdapter(adapter);

        m_searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        m_recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    // some sort of string compare 
                    // and somehow pass that to the intent class
                    Intent intent = new Intent(search.this, recipe.class);
                    startActivity(intent);
                }
            }
        });

    } // end of onCreate

}
