package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by Gokul on 9/14/2015.
 */
public class DiscoverUserPostListAdapter extends ArrayAdapter<ParseObject> implements View.OnClickListener {

    private DiscoverUserPostsActivity adapterTab2Activity;
    private List<ParseObject> mStatus;

    public DiscoverUserPostListAdapter(DiscoverUserPostsActivity tab2Activity, List<ParseObject> status) {
        super (tab2Activity, R.layout.listview_disc_post_item, status);
        this.adapterTab2Activity = tab2Activity;
        this.mStatus = status;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        final ParseObject statusObject = mStatus.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(adapterTab2Activity).inflate(
                    R.layout.listview_disc_post_item, null);
            viewHolder = new ViewHolder();
            viewHolder.textPost = (TextView) convertView.findViewById(R.id.postDiscText);
            convertView.setTag(viewHolder);
            viewHolder.llPostLayout = (RelativeLayout) convertView.findViewById(R.id.llDiscPostLayout);
            viewHolder.textPostType = (TextView) convertView.findViewById(R.id.listviewDiscPostType);
            viewHolder.llPostLayout.setOnClickListener(this);
            viewHolder.textCommentsVary = (TextView) convertView.findViewById(R.id.textDiscCommentsVary);
            viewHolder.textCommentCount = (TextView) convertView.findViewById(R.id.textDiscCommentCount);
            viewHolder.textCoins = (TextView) convertView.findViewById(R.id.textDiscStakePoints);
            String postColor = statusObject.getString("postColor");
            viewHolder.imageFlag = (ImageButton) convertView.findViewById(R.id.imageDiscFlag);
            //viewHolder.imageLike = (ImageButton) convertView.findViewById(R.id.imageLike);
            // viewHolder.imageLike.setBackgroundResource(R.drawable.like_unfilled_100);

            viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_grey_unfilled);

            viewHolder.llPostLayout.setBackgroundResource(R.drawable.post_background);
            GradientDrawable drawable = (GradientDrawable) viewHolder.llPostLayout.getBackground();
            //drawable.setStroke(5,Color.parseColor('"' + postColor + '"'));

            // viewHolder.rlayout.setBackgroundColor(Integer.parseInt(this.adapterColorList.get(i)));

           /* String postType = statusObject.getString("postID");
            switch (postType){
                case "thought":
                    GradientDrawable tDrawable = (GradientDrawable) viewHolder.llPostLayout.getBackground();
                    tDrawable.setStroke(5,Color.parseColor("#EC7568"));
                    break;
                case "prediction":
                    GradientDrawable pDrawable = (GradientDrawable) viewHolder.llPostLayout.getBackground();
                    pDrawable.setStroke(5, Color.parseColor("#55D98D"));
                    break;
                case "question":
                    GradientDrawable qDrawable = (GradientDrawable) viewHolder.llPostLayout.getBackground();
                    qDrawable.setStroke(5, Color.parseColor("#60AEE3"));
                    break;
                default:
                    break;
            }*/
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }



        // statusObject.getClassName();
        final String objectId = statusObject.getObjectId();
        final String postContent = statusObject.getString("content");
        final String postType = statusObject.getString("type");


        //if (postContent == ""){
        viewHolder.textPost.setText(postContent);
    /*    if (statusObject.getList("CommentsArray") != null){
            final List<String> commentCountArray = statusObject.getList("CommentsArray");
            final int commentCount = commentCountArray.size();
            viewHolder.textCommentCount.setText(Integer.toString(commentCount));
        } else {
            viewHolder.textCommentCount.setText(Integer.toString(0));
        }
        if (statusObject.getString("Flag") != null){
            final String flagBool = statusObject.getString("Flag");
            if (flagBool.equals("true")){
                viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_filled_100);
            }else{
                viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_grey_unfilled);
            }
        }else{
            viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_grey_unfilled);
        }*/
        /*ParseQuery<ParseObject> flagQuery = new ParseQuery<ParseObject>("All_Posts");
        //query.whereEqualTo("objectId", objectId);
        // query.orderByDescending("createdAt");
        flagQuery.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                    parseObject.put("Flag", "false");
                    parseObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();

                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(adapterTab2Activity);
                                dialog.setTitle("Sorry");
                                dialog.setMessage(e.getMessage());
                                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(adapterTab2Activity, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });*/

        switch (postType){
            case "thought":
                viewHolder.textPostType.setText("T");
                viewHolder.textPostType.setBackgroundColor(Color.parseColor("#EC7568"));
                break;
            case "prediction":
                viewHolder.textPostType.setText("P");
                viewHolder.textPostType.setBackgroundColor(Color.parseColor("#55D98D"));
                break;
            case "question":
                viewHolder.textPostType.setText("Q");
                viewHolder.textPostType.setBackgroundColor(Color.parseColor("#60AEE3"));
                break;
            default:
                break;
        }
        /*  String title = adapterTab2Activity.getTitle().toString();
        switch (title){
            case "Sports":

                break;
            case "business":
                break;
            default:
                break;
        }
        Toast.makeText(adapterTab2Activity, title, Toast.LENGTH_LONG).show();*/
        // }else {
        //  viewHolder.textPost.setText(postContent);

        // }
        // viewHolder.textPost.setText(postContent2);
        // viewHolder.textPost.setText(postContent3);



      /* if (currentUser != null){

            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
            //query.whereEqualTo("objectId", objectId);
            // query.orderByDescending("createdAt");
            query.getInBackground(objectId, new GetCallback<ParseObject>() {
                @Override
                public void done(final ParseObject parseObject, ParseException e) {
                    if (e == null) {

                        parseObject.get("totalPoints");
                        parseObject.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {

                                    if (parseObject.get("totalPoints") != null){
                                        String stakeQuantity = parseObject.get("totalPoints").toString();
                                        viewHolder.textCoins.setText(stakeQuantity);
                                    }else{
                                        viewHolder.textCoins.setText("0");
                                    }
                                } else {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(adapterTab2Activity);
                                    dialog.setTitle("Sorry");
                                    dialog.setMessage(e.getMessage());
                                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    dialog.show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(adapterTab2Activity, e.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }*/

        /*viewHolder.imageFlag.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                //query.whereEqualTo("objectId", objectId);
                // query.orderByDescending("createdAt");
                query.getInBackground(objectId, new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject parseObject, ParseException e) {
                        if (e == null) {
                            //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                            parseObject.put("Flag", "true");
                            parseObject.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e == null) {
                                        //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                        //v.setBackgroundResource(R.drawable.flag_filled_100);
                                        if (statusObject.getString("Flag") != null){
                                            final String flagBool = statusObject.getString("Flag");
                                            if (flagBool.equals("true")){
                                                viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_filled_100);
                                            }else{
                                                viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_grey_unfilled);
                                            }
                                        }else{
                                            viewHolder.imageFlag.setBackgroundResource(R.drawable.flag_grey_unfilled);
                                        }
                                    } else {
                                        AlertDialog.Builder dialog = new AlertDialog.Builder(adapterTab2Activity);
                                        dialog.setTitle("Sorry");
                                        dialog.setMessage(e.getMessage());
                                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        });
                                        dialog.show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(adapterTab2Activity, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
*/
        /*ParseQuery<ParseObject> commentQuery = new ParseQuery<ParseObject>("All_Posts");
       // commentQuery.whereEqualTo("objectId", objectId);
        // query.orderByDescending("createdAt");
        commentQuery.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    if (parseObject.getNumber("CommentCount") != null){
                        int commentCountCount = parseObject.getNumber("CommentCount").intValue();
                        viewHolder.textCommentCount.setText(Integer.toString(commentCountCount));
                    }else{

                    }

                    //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                  /*  if (parseObject.getList("CommentsArray") != null) {
                        List<String> parseCommentsList = parseObject.getList("CommentsArray");

                        //oast.makeText(ThoughtPostDetailsActivity.this, a.get(1).toString(), Toast.LENGTH_LONG).show();
                       // if (parseCommentsList.size() == 0){
                            viewHolder.textCommentCount.setText(Integer.toString(0));
                        //} else {
                            viewHolder.textCommentCount.setText(Integer.toString(parseCommentsList.size()));

                        //}

                        if (parseCommentsList.size() == 1){
                            viewHolder.textCommentsVary.setText("comment");
                        } else {
                            viewHolder.textCommentsVary.setText("comments");
                        }

                        parseObject.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                } else {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(adapterTab2Activity);
                                    dialog.setTitle("Sorry");
                                    dialog.setMessage(e.getMessage());
                                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                                    dialog.show();
                                }
                            }
                        });
                    } else {
                    }*/

            /*    } else {
                    Toast.makeText(adapterTab2Activity, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });*/
       /*ParseQuery<ParseObject> commentCountQuery = new ParseQuery<ParseObject>("All_Posts");
        //query.whereEqualTo("objectId", objectId);

        // query.orderByDescending("createdAt");
        commentCountQuery.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(final ParseObject parseObject, ParseException e) {
                if (e == null) {
                    //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                    final int commentCount = parseObject.getList("CommentsArray").size();
                    parseObject.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                if (parseObject.getList("CommentsArray") != null) {
                                    viewHolder.textCommentCount.setText(Integer.toString(commentCount));
                                }else{
                                    viewHolder.textCommentCount.setText("0");

                                }

                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(adapterTab2Activity);
                                dialog.setTitle("Sorry");
                                dialog.setMessage(e.getMessage());
                                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(adapterTab2Activity, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });*/
       /* viewHder.imageLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });*/
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }

    public static class ViewHolder {
        TextView textPost;
        RelativeLayout llPostLayout;
        TextView textPostType;
        ImageButton imageFlag;
        TextView textCoins;
        TextView textCommentCount;
        TextView textCommentsVary;
        //ImageButton imageLike;
    }




}
