package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class filter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        ScrollView filterView = (ScrollView) findViewById(R.id.filter_view);

    }
}