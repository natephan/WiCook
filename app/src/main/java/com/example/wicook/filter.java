package com.example.wicook;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class filter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        ImageButton backButton = (ImageButton) findViewById(R.id.filter_back);
        Button resetButton = (Button) findViewById(R.id.filter_reset);
        Button saveButton = (Button) findViewById(R.id.filter_save);

        SearchView keywords = (SearchView) findViewById(R.id.keywords);
        SearchView exclude = (SearchView) findViewById(R.id.exclude);
        SearchView allergies = (SearchView) findViewById(R.id.allergies);

        SeekBar priceSeeker = (SeekBar) findViewById(R.id.price_seeker);
        EditText priceText = (EditText) findViewById(R.id.price_text);

        SeekBar calSeeker = (SeekBar) findViewById(R.id.cal_seeker);
        EditText calText = (EditText) findViewById(R.id.cal_text);

        SeekBar timeSeeker = (SeekBar) findViewById(R.id.time_seeker);
        EditText timeText = (EditText) findViewById(R.id.time_text);

        EditText servings = (EditText) findViewById(R.id.servings_box);

        /*priceSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int newProgress = 0;
            public void onProgressChanged(SeekBar priceBar, int progress, boolean user) {
                newProgress = progress;
            }
            public void onStartTrackingTouch(SeekBar priceBar) {

            }
            public void onStopTrackingTouch(SeekBar priceBar) {
                priceText.setText("$" + Integer.toString(newProgress));
            }
        });

        calSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int newProgress = 0;
            public void onProgressChanged(SeekBar calBar, int progress, boolean user) {
                newProgress = progress;
            }
            public void onStartTrackingTouch(SeekBar calBar) {

            }
            public void onStopTrackingTouch(SeekBar calBar) {
                calText.setText(Integer.toString(newProgress));
            }
        });

        timeSeeker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int newProgress = 0;
            public void onProgressChanged(SeekBar timeBar, int progress, boolean user) {
                newProgress = progress;
            }
            public void onStartTrackingTouch(SeekBar timeBar) {

            }
            public void onStopTrackingTouch(SeekBar timeBar) {
                timeText.setText(Integer.toString(newProgress));
            }
        });

        priceText.addTextChangedListener(new TextWatcher() {
            String oldText = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                oldText = priceText.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String newText = priceText.getText().toString();
                int stringVal = stringToInteger(newText);
                if (stringVal >= 0 && stringVal <= 100) {
                    priceSeeker.setProgress(stringVal);
                    priceText.setText("$" + newText);
                }
                else {
                    priceText.setText(oldText);
                }
            }
        });

        calText.addTextChangedListener(new TextWatcher() {
            String oldText = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                oldText = calText.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String newText = calText.getText().toString();
                int stringVal = stringToInteger(newText);
                if (stringVal >= 0 && stringVal <= 1000) {
                    calSeeker.setProgress(stringVal);
                }
                else {
                    calText.setText(oldText);
                }
            }
        });

        timeText.addTextChangedListener(new TextWatcher() {
            String oldText = "";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                oldText = timeText.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String newText = timeText.getText().toString();
                int stringVal = stringToInteger(newText);
                if (stringVal >= 0 && stringVal <= 1000) {
                    timeSeeker.setProgress(stringVal);
                }
                else {
                    timeText.setText(oldText);
                }
            }
        }); */

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keywords.setQuery("", false);
                keywords.clearFocus();

                exclude.setQuery("", false);
                exclude.clearFocus();

                allergies.setQuery("", false);
                allergies.clearFocus();

                priceSeeker.setProgress(0);
                priceText.setText("0");

                calSeeker.setProgress(0);
                calText.setText("0");

                timeSeeker.setProgress(0);
                timeText.setText("0");

                servings.setText("1");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public static int stringToInteger(String string) {
        int val = -1;
        try {
            val = Integer.parseInt(string);
        }
        catch (Exception e) {
            return -1;
        }
        return val;
    }
}