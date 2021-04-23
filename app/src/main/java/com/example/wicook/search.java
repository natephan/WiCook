package com.example.wicook;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class search extends AppCompatActivity {
    private ArrayList<recipeName> recipeNamesList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        recyclerView = findViewById(R.id.recyclerView);
        recipeNamesList = new ArrayList<>();
        setRecipeNamesList();
        setAdapter();

    }
    private void setAdapter(){
        recyclerAdapter adapter = new recyclerAdapter(recipeNamesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setRecipeNamesList(){
        recipeNamesList.add(new recipeName("Fried Chicken"));
        recipeNamesList.add(new recipeName("Burger"));
        recipeNamesList.add(new recipeName("Shrimp"));
        recipeNamesList.add(new recipeName("Grilled Fish"));
        recipeNamesList.add(new recipeName("Salmon"));
    }
}
