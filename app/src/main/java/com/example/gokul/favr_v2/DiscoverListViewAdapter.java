package com.example.gokul.favr_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by Gokul on 9/11/2015.
 */
public class DiscoverListViewAdapter extends ArrayAdapter<ParseObject> implements View.OnClickListener {
    private FragmentActivity adapterTab1Activity;
    private List<ParseObject> mStatus;

    public DiscoverListViewAdapter(FragmentActivity tab1Activity, List<ParseObject> status) {
        super (tab1Activity, R.layout.discover_post_item, status);
        this.adapterTab1Activity = tab1Activity;
        this.mStatus = status;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        final ParseObject statusObject = mStatus.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(adapterTab1Activity).inflate(
                    R.layout.discover_post_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textHeadline = (TextView) convertView.findViewById(R.id.headlineText);
            viewHolder.textContent = (TextView) convertView.findViewById(R.id.textDiscoverContent);
            viewHolder.layoutToArticle = (LinearLayout) convertView.findViewById(R.id.layoutToArticle);
            convertView.setTag(viewHolder);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }


        final String objectId = statusObject.getString("objectId");
        final String postContent = statusObject.getString("content");
        final String postHeadline = statusObject.getString("headline");
        final String articleLink = statusObject.getString("discoverLink");


        viewHolder.textHeadline.setText(postHeadline);
        viewHolder.textContent.setText(postContent);
        viewHolder.layoutToArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webViewIntent = new Intent(adapterTab1Activity,DiscArticleWebViewActivity.class);
                webViewIntent.putExtra("articleLink", articleLink);
                adapterTab1Activity.startActivity(webViewIntent);
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent discoverUserPostsIntent = new Intent(adapterTab1Activity, DiscoverUserPostsActivity.class);
                discoverUserPostsIntent.putExtra("objectId", objectId);
                discoverUserPostsIntent.putExtra("headline", postHeadline);
                discoverUserPostsIntent.putExtra("content", postContent);
                discoverUserPostsIntent.putExtra("title", adapterTab1Activity.getTitle().toString());
                adapterTab1Activity.startActivity(discoverUserPostsIntent);
                /*thoughtPostDetails.putExtra("postContent", viewHolder.textPost.getText());
                //Toast.makeText(adapterTab2Activity, "asdf" + objectId, Toast.LENGTH_SHORT).show();

                thoughtPostDetails.putExtra("objectId", objectId);
                // thoughtPostDetails.putExtra("activityTitle", adapterTab2Activity.getTitle().toString());
                adapterTab2Activity.startActivity(thoughtPostDetails);*/

            }
        });
        return convertView;
    }

    @Override
    public void onClick(View v) {


    }

    public static class ViewHolder {
        TextView textHeadline;
        TextView textContent;
        LinearLayout layoutToArticle;
        //ImageButton imageLike;
    }

}
