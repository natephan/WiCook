package com.example.wicook;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class cookbook extends AppCompatActivity {
    private ListView catListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookbook);

        final ImageButton navCook = (ImageButton) findViewById(R.id.pageCBookBtn);
        navCook.setBackgroundResource(R.color.activeMenu);

        catListView = (ListView) findViewById(R.id.categoryListV);
        CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), login.allCatergories);
        catListView.setAdapter(adapter);


        catListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String category = login.allCatergories.get(position);
                Intent intent = new Intent(cookbook.this, CategoryPage.class);
                intent.putExtra("CAT_NAME", category);
                startActivity(intent);
            }
        });

        final EditText catName = (EditText) findViewById(R.id.catInputText);
        final Button addCatBtn = (Button) findViewById(R.id.addCatBtn);
        addCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = catName.getText().toString();
                login.allCatergories.add(s);
                adapter.notifyDataSetChanged();

                catName.setText("");
            }
        });


        final ImageButton navHome = (ImageButton) findViewById(R.id.pageHomeBtn);
        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cookbook.this, home.class);
                startActivity(intent);
            }
        });

        final ImageButton navSocial = (ImageButton) findViewById(R.id.pageSocialBtn);
        navSocial.setOnClickListener(e-> {
            Intent intent = new Intent(cookbook.this, social.class);
            startActivity(intent);
        });

        final ImageButton navBook = (ImageButton) findViewById(R.id.pageExplorBtn);
        navBook.setOnClickListener(e-> {
            Intent intent = new Intent(cookbook.this, explore.class);
            startActivity(intent);
        });

        final ImageButton settings = (ImageButton) findViewById(R.id.settingCookBookBtn);
        settings.setOnClickListener(e->{
            Intent intent = new Intent(cookbook.this, settings.class);
            startActivity(intent);
        });


    }
}