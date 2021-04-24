package com.example.wicook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
//    private ArrayList<recipeName> recipeNamesList;
//    // Constructor
//    public recyclerAdapter(ArrayList<recipeName> recipeNamesList){
//        this.recipeNamesList = recipeNamesList;
//    }
//    public class MyViewHolder extends RecyclerView.ViewHolder{
//        private TextView recipeNameTxT;
//        public MyViewHolder(final View view){
//            super(view);
//            recipeNameTxT = view.findViewById(R.id.recipeNames);
//        }
//    }
//    @NonNull
//    @Override
//    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View nameView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recipes,parent,false);
//        return new MyViewHolder(nameView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
//        String name = recipeNamesList.get(position).getRecipe_name();
//        holder.recipeNameTxT.setText(name);
//    }
//
//    @Override
//    public int getItemCount() {
//        return recipeNamesList.size();
//    }
//}
