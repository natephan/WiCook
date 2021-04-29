package com.example.wicook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class feedAdapter extends ArrayAdapter<String> {
    private ArrayList<String> friends;
    private Context mContext;

    public feedAdapter(@NonNull Context context, ArrayList<String> friends) {
        super(context, R.layout.feed_items, friends);

        this.friends = friends;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate
                    (R.layout.feed_items, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.feed_message);
        textView.setText(friends.get(position) + " has shared a recipe with you!");

        ImageView friendImage = convertView.findViewById(R.id.feed_item_pic);
        friendImage.setImageResource(R.drawable.socialicon);

        Button likeButton = (Button) convertView.findViewById(R.id.like_button);
        Button viewButton = (Button) convertView.findViewById(R.id.view_button);
        Button shareButton = (Button) convertView.findViewById(R.id.share_button);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String liked = likeButton.getText().toString();
                if (liked.equals("Like")) {
                    likeButton.setText("Liked!");
                }
                else {
                    likeButton.setText("Like");
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe r = login.allRecipes.get(0);

                Intent intent = new Intent(parent.getContext(), RecipePage.class);
                intent.putExtra("R_NAME", r.getRecipeName());
                intent.putExtra("R_DESC", r.getDescription());
                intent.putExtra("R_INST", r.getInstructions());
                intent.putExtra("R_INGR", r.getIngredients());
                intent.putExtra("R_INFO", r.getInformation());
                intent.putExtra("R_ID", r.id);
                intent.putExtra("R_CLASS", "Explore");
                parent.getContext().startActivity(intent);
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), shareSocial.class);
                parent.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

}
