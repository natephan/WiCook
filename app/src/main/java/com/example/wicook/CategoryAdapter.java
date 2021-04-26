package com.example.wicook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<String> {
    private ArrayList<String> categories;
    private Context mContext;

    public CategoryAdapter(@NonNull Context context, ArrayList<String> categories) {
        super(context, R.layout.category_item, categories);

        this.categories = categories;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate
                    (R.layout.category_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.category_TextView);
        textView.setText(categories.get(position));


        return convertView;
    }

}
