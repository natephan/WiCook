package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class cookBookCategory extends AppCompatActivity {

    RecyclerView recyclerCategory;
    ArrayList<CategoryList> categoryList = new ArrayList<>();
    Button buttonEditCategory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerCategory = findViewById(R.id.recycler_categories);
        buttonEditCategory = findViewById(R.id.button_edit_categories);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerCategory.setLayoutManager(layoutManager);

        categoryList = (ArrayList<CategoryList>) getIntent().getExtras().getSerializable("list");

        recyclerCategory.setAdapter(new CategoryAdapter(categoryList));

        buttonEditCategory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(cookBookCategory.this, newCookBook.class);
                startActivity(intent);
            }
        });

    }
}
