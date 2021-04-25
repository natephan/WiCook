package com.example.wicook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryView> {
    ArrayList<CategoryList> categoryList = new ArrayList<>();
    public CategoryAdapter(ArrayList<CategoryList> categoryList) {
        this.categoryList  = categoryList;
    }
    @NonNull
    @Override
    public CategoryAdapter.CategoryView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_categories,parent,false);

        return new CategoryView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryView holder, int position) {
       CategoryList cricketer = categoryList.get(position);
       holder.categoryName.setText(cricketer.getCategoryName());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    public class CategoryView extends RecyclerView.ViewHolder{

        TextView categoryName;
        public CategoryView(@NonNull View itemView) {
            super(itemView);

            categoryName = (TextView)itemView.findViewById(R.id.text_category_name);


        }
    }
}

