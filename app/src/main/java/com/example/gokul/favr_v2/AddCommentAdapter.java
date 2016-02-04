package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gokul on 8/18/2015.
 */
public class AddCommentAdapter  extends BaseAdapter {

    private ThoughtPostDetailsActivity adapterTPDActivity;
    private List<String> adapterCommentList;


    public AddCommentAdapter(ThoughtPostDetailsActivity TPDActivity, List<String> commentList) {
        this.adapterTPDActivity = TPDActivity;
        this.adapterCommentList = commentList;
    }

    @Override
    public int getCount() {
        return this.adapterCommentList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(adapterTPDActivity).inflate(R.layout.comment_list_row, parent, false);
        TextView textComment = (TextView) view.findViewById(R.id.textComment);
        LinearLayout llUpVote = (LinearLayout) view.findViewById(R.id.llCommentUp);
        textComment.setText(this.adapterCommentList.get(position));
        final TextView textCommentCount = (TextView) view.findViewById(R.id.textCommentCount);
        ImageButton imgUpVote = (ImageButton) view.findViewById(R.id.imgCommentUp);
        imgUpVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intCommentCount = Integer.parseInt(textCommentCount.getText().toString());
                intCommentCount++;
                textCommentCount.setText(Integer.toString(intCommentCount));
            }
        });
        llUpVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int intCommentCount = Integer.parseInt(textCommentCount.getText().toString());
                intCommentCount++;
                textCommentCount.setText(Integer.toString(intCommentCount));
            }
        });


        return view;    }


}

