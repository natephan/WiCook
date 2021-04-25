package com.example.wicook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class newCookBook extends AppCompatActivity implements View.OnClickListener{
    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonSubmitList;

    //List<String> teamList = new ArrayList<>();
    ArrayList<CategoryList> categoryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookbook_activity);

        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubmitList = findViewById(R.id.button_submit_list);

        buttonAdd.setOnClickListener(this);
        buttonSubmitList.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.button_add:

                addView();

                break;

            case R.id.button_submit_list:

                if(checkIfValidAndRead()){

                    Intent intent = new Intent(newCookBook.this,cookBookCategory.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list",categoryList);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }

                break;

        }
    }
    private void addView() {

        final View categoryView = getLayoutInflater().inflate(R.layout.row_add_categories,null,false);

        EditText editText = (EditText)categoryView.findViewById(R.id.edit_category_name);
        ImageView imageClose = (ImageView)categoryView.findViewById(R.id.image_remove);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutList.removeView(v);
            }
        });

        layoutList.addView(categoryView);
    }
    private boolean checkIfValidAndRead() {
        categoryList.clear();
        boolean result = true;

        for(int i=0;i<layoutList.getChildCount();i++){

            View cricketerView = layoutList.getChildAt(i);

            EditText editTextName = (EditText)cricketerView.findViewById(R.id.edit_category_name);

            CategoryList category = new CategoryList();

            if(!editTextName.getText().toString().equals("")){
                category.setCategoryName(editTextName.getText().toString());
            }else {
                result = false;
                break;
            }
           categoryList.add(category);
        }

        if(categoryList.size()==0){
            result = false;
            Toast.makeText(this, "Add Categories First!", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }


        return result;
    }
}
