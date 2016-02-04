package com.example.gokul.favr_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;


public class PostDiscSettingsActivity extends ActionBarActivity implements View.OnClickListener {

    Toolbar mToolbar;

    ImageButton btnUp;
    ImageButton btnDown;
    TextView textDaysDay;
    TextView textNumTimer;
    ImageView btnSports;
    ImageView btnBusiness;
    ImageView btnUS;
    ImageView btnWorld;
    ImageView btnPolitics;
    ImageView btnScience;
    ImageView btnTechnology;
    ImageView btnAutomobiles;
    ImageView btnEconomy;
    ImageView btnEducation;
    int sports_counter = 1;
    int business_counter = 1;
    int us_counter = 1;
    int world_counter = 1;
    int politics_counter = 1;
    int science_counter = 1;
    int technology_counter = 1;
    int car_counter = 1;
    int economy_counter = 1;
    int education_counter = 1;
    int timerNum = 1;
    String postCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_disc_settings);

        textDaysDay = (TextView) this.findViewById(R.id.textDiscDaysDay);
        btnUp = (ImageButton) this.findViewById(R.id.btnDiscUp);
        btnDown = (ImageButton) this.findViewById(R.id.btnDiscDown);
        textNumTimer = (TextView) this.findViewById(R.id.textDiscTimerNum);

        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        Toast.makeText(PostDiscSettingsActivity.this, title, Toast.LENGTH_LONG).show();
        btnSports = (ImageView) this.findViewById(R.id.btnDiscSports);
        btnBusiness = (ImageView) this.findViewById(R.id.btnDiscBusiness);
        btnUS = (ImageView) this.findViewById(R.id.btnDiscUS);
        btnWorld = (ImageView) this.findViewById(R.id.btnDiscWorld);
        btnPolitics = (ImageView) this.findViewById(R.id.btnDiscPolitics);
        btnScience = (ImageView) this.findViewById(R.id.btnDiscScience);
        btnTechnology = (ImageView) this.findViewById(R.id.btnDiscTechnology);
        btnAutomobiles = (ImageView) this.findViewById(R.id.btnDiscAutomobiles);
        btnEconomy = (ImageView) this.findViewById(R.id.btnDiscEconomy);
        btnEducation = (ImageView) this.findViewById(R.id.btnDiscEducation);

        btnSports.setBackgroundResource(R.drawable.sports_button);
        btnBusiness.setBackgroundResource(R.drawable.business_button);
        btnUS.setBackgroundResource(R.drawable.us_button);
        btnWorld.setBackgroundResource(R.drawable.world_button);
        btnPolitics.setBackgroundResource(R.drawable.politics_button);
        btnScience.setBackgroundResource(R.drawable.science_button);
        btnTechnology.setBackgroundResource(R.drawable.technology_button);
        btnAutomobiles.setBackgroundResource(R.drawable.automobiles_button);
        btnEconomy.setBackgroundResource(R.drawable.economy_button);
        btnEducation.setBackgroundResource(R.drawable.education_button);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        GradientDrawable sDrawable = (GradientDrawable) btnSports.getBackground();
        sDrawable.setColor(Color.parseColor("#F9D6D2"));
        GradientDrawable bDrawable = (GradientDrawable) btnBusiness.getBackground();
        bDrawable.setColor(Color.parseColor("#F9E0C9"));
        GradientDrawable uDrawable = (GradientDrawable) btnUS.getBackground();
        uDrawable.setColor(Color.parseColor("#FBF1C6"));
        GradientDrawable wDrawable = (GradientDrawable) btnWorld.getBackground();
        wDrawable.setColor(Color.parseColor("#CCF4DD"));
        GradientDrawable pDrawable = (GradientDrawable) btnPolitics.getBackground();
        pDrawable.setColor(Color.parseColor("#BEF6EB"));
        GradientDrawable scDrawable = (GradientDrawable) btnScience.getBackground();
        scDrawable.setColor(Color.parseColor("#CFE7F7"));
        GradientDrawable tDrawable = (GradientDrawable) btnTechnology.getBackground();
        tDrawable.setColor(Color.parseColor("#E8D8EE"));
        GradientDrawable cDrawable = (GradientDrawable) btnAutomobiles.getBackground();
        cDrawable.setColor(Color.parseColor("#F3CECA"));
        GradientDrawable eDrawable = (GradientDrawable) btnEconomy.getBackground();
        eDrawable.setColor(Color.parseColor("#FFD3B5"));
        GradientDrawable edDrawable = (GradientDrawable) btnEducation.getBackground();
        edDrawable.setColor(Color.parseColor("#FCE8C7"));
        switch (title){
            case "Sports":
                sDrawable.setColor(Color.parseColor("#EC7568"));
                btnSports.setImageResource(R.drawable.p1);
                postCategory = "Sports";
                break;
            case "Business":
                bDrawable.setColor(Color.parseColor("#EB974B"));
                btnBusiness.setImageResource(R.drawable.p2);
                postCategory = "Business";
                break;
            case "U.S":
                uDrawable.setColor(Color.parseColor("#F3CF41"));
                btnUS.setImageResource(R.drawable.p3);
                postCategory = "U.S.";
                break;
            case "World":
                wDrawable.setColor(Color.parseColor("#55D98D"));
                btnWorld.setImageResource(R.drawable.p4);
                postCategory = "World";
                break;
            case "Politics":
                pDrawable.setColor(Color.parseColor("#28E1BC"));
                btnPolitics.setImageResource(R.drawable.p5);
                postCategory = "Politics";
                break;
            case "Science":
                scDrawable.setColor(Color.parseColor("#60AEE3"));
                btnScience.setImageResource(R.drawable.p6);
                postCategory = "Science";
                break;
            case "Technology":
                tDrawable.setColor(Color.parseColor("#B17EC7"));
                btnTechnology.setImageResource(R.drawable.p7);
                postCategory = "Technology";
                break;
            case "Automobiles":
                cDrawable.setColor(Color.parseColor("#D85B4E"));
                btnAutomobiles.setImageResource(R.drawable.p8);
                postCategory = "Automobiles";
                break;
            case "Economy":
                eDrawable.setColor(Color.parseColor("#FF6B09"));
                btnEconomy.setImageResource(R.drawable.p9);
                postCategory = "Economy";
                break;
            case "Education":
                edDrawable.setColor(Color.parseColor("#F5B343"));
                btnEducation.setImageResource(R.drawable.p10);
                postCategory = "Education";
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post_settings, menu);
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

        if (id == R.id.post) {
            Bundle bundle = getIntent().getExtras();
            String postContent = (String) bundle.get("post");
            String postType = (String) bundle.get("postType");
            String panelContent = (String) bundle.get("panelContent");
            String panelHeadline = (String) bundle.get("headline");
            String title = (String) bundle.get("title");
            Intent postIntent = new Intent(PostDiscSettingsActivity.this, DiscoverUserPostsActivity.class);

            ArrayList<String> bidOptionList = (ArrayList<String>) bundle.getStringArrayList("bidOptionList");

            ParseUser currentUser = ParseUser.getCurrentUser();
            String currentUsername = currentUser.getUsername();
            ParseObject allPosts = new ParseObject("DiscoverUserPosts");
            allPosts.put("category", postCategory);
            allPosts.put("Username", currentUsername);
            switch (postType) {
                case "thought":
                    ParseObject thoughtPost = new ParseObject("Thought_Post");
                    thoughtPost.put("ThoughtPost", postContent);
                    thoughtPost.put("Username", currentUsername);
                    allPosts.put("content", postContent);
                    allPosts.put("headline", panelContent);
                    allPosts.put("featured", false);
                    allPosts.put("type", postType);
                    //allPosts.put("postColor", "#EC7568");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    thoughtPost.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    break;
                case "prediction":
                    ParseObject predictionPost = new ParseObject("DiscoverUserPosts");
                    predictionPost.put("PredictionPost", postContent);
                    predictionPost.put("Username", currentUsername);
                    allPosts.put("content", postContent);
                    allPosts.put("featured", false);
                    allPosts.put("headline", panelContent);
                    allPosts.put("type", postType);
                    //allPosts.put("postColor", "#55D98D");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    predictionPost.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    break;
                case "question":
                    ParseObject questionPost = new ParseObject("DiscoverUserPosts");
                    questionPost.put("QuestionPost", postContent);
                    questionPost.put("Username", currentUsername);
                    allPosts.put("content", postContent);
                    allPosts.put("featured", false);
                    allPosts.put("type", postType);
                    allPosts.put("headline", panelContent);
                    allPosts.addAll("bidOptionList", Arrays.asList(bidOptionList));
                    //allPosts.put("postColor", "#60AEE3");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    questionPost.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostDiscSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostDiscSettingsActivity.this);
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
                    break;
                default:
                    break;
            }
            postIntent.putExtra("title", title);
            postIntent.putExtra("headline", panelHeadline);
            postIntent.putExtra("content", panelContent);
            postIntent.putExtra("postCategory", postCategory);
            startActivity(postIntent);
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onClick (View v){
        int id = v.getId();
        switch (id) {
            case R.id.btnUp:
                timerNum++;
                textNumTimer.setText(Integer.toString(timerNum));
                if (timerNum == 1) {
                    textDaysDay.setText("day");
                } else {
                    textDaysDay.setText("days");
                }
                break;
            case R.id.btnDown:
                timerNum--;
                textNumTimer.setText(Integer.toString(timerNum));
                if (timerNum == 1) {
                    textDaysDay.setText("day");
                } else {
                    textDaysDay.setText("days");
                }
                break;
            default:
                break;
        }
    }
}
