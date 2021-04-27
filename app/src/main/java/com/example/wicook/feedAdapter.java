package com.example.wicook;

import android.content.Context;
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

        return convertView;
    }

}
