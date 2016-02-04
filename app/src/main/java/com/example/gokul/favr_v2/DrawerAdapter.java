package com.example.gokul.favr_v2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Gokul on 6/29/2015.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    List<DrawerList> data = Collections.emptyList();

    private Context context;
    public DrawerAdapter(Context context, List<DrawerList> data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.drawer_row, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        DrawerList current = data.get(i);
        viewHolder.textTitle.setText(current.title);
        viewHolder.imageIcon.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        ImageView imageIcon;
        public MyViewHolder(View itemView){
            super(itemView);

            textTitle = (TextView) itemView.findViewById(R.id.appbarText);
            imageIcon = (ImageView) itemView.findViewById(R.id.appbarIcon);
        }

    }

}
