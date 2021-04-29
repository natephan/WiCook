package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class deleteFriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_friend);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int w = metrics.widthPixels;
        int h = metrics.heightPixels;

        getWindow().setLayout((int) (w*.6), 770);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        Intent intent = getIntent();

        Button cancelDelete = (Button) findViewById(R.id.cancel_delete);
        Button confirmRemove = (Button) findViewById(R.id.confirm_remove);
        TextView name = (TextView) findViewById(R.id.delete_friend_name);
        name.setText(intent.getStringExtra("name"));

        cancelDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        confirmRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friends.adapter.remove(intent.getStringExtra("name"));
                onBackPressed();
            }
        });

    }
}
