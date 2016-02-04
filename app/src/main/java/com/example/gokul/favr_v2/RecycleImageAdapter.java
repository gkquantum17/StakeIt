package com.example.gokul.favr_v2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Gokul on 6/18/2015.
 */
public class RecycleImageAdapter extends RecyclerView.Adapter<RecycleImageAdapter.ViewHolder> {
    public WelcomeActivity adapterMainActivity;
    private ArrayList<String> adapterStringList;
    private ArrayList<String> adapterColorList;
    Context mContext;

    public RecycleImageAdapter(WelcomeActivity mainActivity, ArrayList<String> textList, ArrayList<String> colorList) {
        this.adapterMainActivity = mainActivity;
        this.adapterStringList = textList;
        this.adapterColorList = colorList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(adapterMainActivity).inflate(R.layout.list_row, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
      int resourceId = adapterMainActivity.getResources().getIdentifier("p" + (i + 1), "drawable", adapterMainActivity.getPackageName());
        Picasso.with(adapterMainActivity).load(resourceId).fit().into(viewHolder.imageView);
        viewHolder.txtViewTitle.setText(this.adapterStringList.get(i));
        viewHolder.rlayout.setBackgroundResource(R.drawable.roundedbutton);
       // viewHolder.rlayout.setBackgroundColor(Integer.parseInt(this.adapterColorList.get(i)));
        GradientDrawable drawable = (GradientDrawable) viewHolder.rlayout.getBackground();
        drawable.setColor(Integer.parseInt(this.adapterColorList.get(i)));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public TextView txtViewTitle;
        public RelativeLayout rlayout;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            txtViewTitle = (TextView) itemView.findViewById(R.id.item_title);
            rlayout = (RelativeLayout) itemView.findViewById(R.id.rLayout);
            rlayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String position = Integer.toString(getAdapterPosition());
            Intent categoryIntent = new Intent(adapterMainActivity, CategoryActivity.class);
            categoryIntent.putExtra("Position", position);
            adapterMainActivity.startActivity(categoryIntent);
            /*Toast.makeText(adapterMainActivity, "layot" + position , Toast.LENGTH_SHORT).show();*/
        }
    }
}
