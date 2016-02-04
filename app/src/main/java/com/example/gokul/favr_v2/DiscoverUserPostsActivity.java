package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.List;


public class DiscoverUserPostsActivity extends ActionBarActivity {
    Toolbar toolbar;
    protected List<ParseObject> qPosts;
    SlidingUpPanelLayout mLayout;
    TextView textPanelHeadline;
    TextView textPanelContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_user_posts);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textPanelContent = (TextView) this.findViewById(R.id.textPanelContent);
        textPanelHeadline = (TextView) this.findViewById(R.id.textPanelHeadline);


        final Bundle bundle = getIntent().getExtras();
            String panelContentText = bundle.getString("content");
            textPanelContent.setText(panelContentText);
            final String panelContent = bundle.getString("content");
            final String panelHeadline = bundle.getString("headline");
            textPanelHeadline.setText(panelHeadline);

        final String title = bundle.getString("title");

        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Make Post");
        actionC.setIcon(R.drawable.plu);
        actionC.setColorNormal(Color.parseColor("#FCFCFC"));
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent makeUserDiscoverPostActivity = new Intent(DiscoverUserPostsActivity.this, MakeUserDiscoveryPostActivity.class);
                makeUserDiscoverPostActivity.putExtra("panelContent", panelContent);
                //makeUserDiscoverPostActivity.putExtra("DiscoverBool", true);
                makeUserDiscoverPostActivity.putExtra("headline", panelHeadline);
                makeUserDiscoverPostActivity.putExtra("title", title);
                startActivity(makeUserDiscoverPostActivity);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(actionC);

        final FloatingActionButton actionB = (FloatingActionButton) findViewById(R.id.action_b);
        /*actionB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this, "Adsf", Toast.LENGTH_LONG).show();
            }
        });*/

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        final ListView listView = (ListView)findViewById(R.id.listDiscViewPosts);
        ParseUser currentUser = ParseUser.getCurrentUser();
        // Toast.makeText(getActivity(), title + "adsf" , Toast.LENGTH_SHORT).show();
        switch (title){
            case "Sports":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "Sports");
                   query.whereEqualTo("headline", panelContent);
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Business":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "Business");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "U.S.":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "U.S");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "World":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "World");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Politics":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "Politics");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Science":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "Science");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Technology":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "Tech");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Automobiles":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "automobiles");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Economy":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "economy");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            case "Education":
                if (currentUser != null){
                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("DiscoverUserPosts");
                    query.whereEqualTo("category", "education");
                    query.orderByDescending("createdAt");
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null){
                                qPosts = list;
                                PostListViewAdapter qadapter = new PostListViewAdapter(DiscoverUserPostsActivity.this, qPosts);
                                listView.setAdapter(qadapter);
                            }else {

                            }
                        }
                    });
                }
                break;
            default:
                break;
        }
    }
    public void switchArrow(){
        if (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.COLLAPSED){
            Toast.makeText(this, "collapsed", Toast.LENGTH_LONG).show();
        }else if (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED){
            Toast.makeText(this, "expanded", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_discover_user_posts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
