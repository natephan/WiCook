package com.example.wicook;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import static android.content.Context.WINDOW_SERVICE;

public class friendsAdapter extends ArrayAdapter<String> {
    private ArrayList<String> friends;
    private Context mContext;

    public friendsAdapter(@NonNull Context context, ArrayList<String> friends) {
        super(context, R.layout.friends_items, friends);

        this.friends = friends;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate
                    (R.layout.friends_items, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.friend_item_name);
        textView.setText(friends.get(position));

        ImageView friendImage = convertView.findViewById(R.id.friend_item_pic);
        friendImage.setImageResource(R.drawable.socialicon);

        return convertView;
    }

}
