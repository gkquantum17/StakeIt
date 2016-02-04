package com.example.gokul.favr_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
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

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PostSettingsActivity extends ActionBarActivity implements View.OnClickListener {
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
        setContentView(R.layout.activity_post_settings);
       /* Bundle bundle = getIntent().getExtras();
        String postContent = (String) bundle.get("post");
        String postType = (String) bundle.get("postType");*/

          /*ParseObject userPost = new ParseObject("Post");
            userPost.put("Thought_Post", newPost);
            userPost.put("Username", currentUsername);
            userPost.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null){
                        Toast.makeText(MakePostActivity.this, "success", Toast.LENGTH_LONG).show();
                    } else{
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MakePostActivity.this);
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
            });*/
        /*ParseUser currentUser = ParseUser.getCurrentUser();
        String currentUsername = currentUser.getUsername();
        ParseObject allPosts = new ParseObject("All_Posts");
        switch (postType) {
            case "thought":
                ParseObject thoughtPost = new ParseObject("Thought_Post");
                thoughtPost.put("ThoughtPost", postContent);
                thoughtPost.put("Username", currentUsername);
                allPosts.put("Post", postContent);
                allPosts.put("postID", postType);
                allPosts.put("postColor", "#EC7568");
                allPosts.put("Username", currentUsername);
                allPosts.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                ParseObject predictionPost = new ParseObject("Prediction_Post");
                predictionPost.put("PredictionPost", postContent);
                predictionPost.put("Username", currentUsername);
                allPosts.put("Post", postContent);
                allPosts.put("postID", postType);
                allPosts.put("postColor", "#55D98D");
                allPosts.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                ParseObject questionPost = new ParseObject("Question_Post");
                questionPost.put("QuestionPost", postContent);
                questionPost.put("Username", currentUsername);
                allPosts.put("Post", postContent);
                allPosts.put("postID", postType);
                allPosts.put("postColor", "#60AEE3");
                allPosts.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                            Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                        } else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
        }*/
        // Toast.makeText(PostSettingsActivity.this, postContent, Toast.LENGTH_SHORT).show();
        // Toast.makeText(PostSettingsActivity.this, postType, Toast.LENGTH_SHORT).show();
        textDaysDay = (TextView) this.findViewById(R.id.textDaysDay);
        btnUp = (ImageButton) this.findViewById(R.id.btnUp);
        btnDown = (ImageButton) this.findViewById(R.id.btnDown);
        textNumTimer = (TextView) this.findViewById(R.id.textTimerNum);

        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);

        btnSports = (ImageView) this.findViewById(R.id.btnSports);
        btnBusiness = (ImageView) this.findViewById(R.id.btnBusiness);
        btnUS = (ImageView) this.findViewById(R.id.btnUS);
        btnWorld = (ImageView) this.findViewById(R.id.btnWorld);
        btnPolitics = (ImageView) this.findViewById(R.id.btnPolitics);
        btnScience = (ImageView) this.findViewById(R.id.btnScience);
        btnTechnology = (ImageView) this.findViewById(R.id.btnTechnology);
        btnAutomobiles = (ImageView) this.findViewById(R.id.btnAutomobiles);
        btnEconomy = (ImageView) this.findViewById(R.id.btnEconomy);
        btnEducation = (ImageView) this.findViewById(R.id.btnEducation);

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
        btnSports.setOnClickListener(this);
        GradientDrawable bDrawable = (GradientDrawable) btnBusiness.getBackground();
        bDrawable.setColor(Color.parseColor("#F9E0C9"));
        btnBusiness.setOnClickListener(this);
        GradientDrawable uDrawable = (GradientDrawable) btnUS.getBackground();
        uDrawable.setColor(Color.parseColor("#FBF1C6"));
        btnUS.setOnClickListener(this);
        GradientDrawable wDrawable = (GradientDrawable) btnWorld.getBackground();
        wDrawable.setColor(Color.parseColor("#CCF4DD"));
        btnWorld.setOnClickListener(this);
        GradientDrawable pDrawable = (GradientDrawable) btnPolitics.getBackground();
        pDrawable.setColor(Color.parseColor("#BEF6EB"));
        btnPolitics.setOnClickListener(this);
        GradientDrawable scDrawable = (GradientDrawable) btnScience.getBackground();
        scDrawable.setColor(Color.parseColor("#CFE7F7"));
        btnScience.setOnClickListener(this);
        GradientDrawable tDrawable = (GradientDrawable) btnTechnology.getBackground();
        tDrawable.setColor(Color.parseColor("#E8D8EE"));
        btnTechnology.setOnClickListener(this);
        GradientDrawable aDrawable = (GradientDrawable) btnAutomobiles.getBackground();
        aDrawable.setColor(Color.parseColor("#F3CECA"));
        btnAutomobiles.setOnClickListener(this);
        GradientDrawable eDrawable = (GradientDrawable) btnEconomy.getBackground();
        eDrawable.setColor(Color.parseColor("#FFD3B5"));
        btnEconomy.setOnClickListener(this);
        GradientDrawable edDrawable = (GradientDrawable) btnEducation.getBackground();
        edDrawable.setColor(Color.parseColor("#FCE8C7"));
        btnEducation.setOnClickListener(this);

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
            Intent postIntent = new Intent(PostSettingsActivity.this, CategoryActivity.class);

            ArrayList<String> bidOptionList = (ArrayList<String>) bundle.getStringArrayList("bidOptionList");

            ParseUser currentUser = ParseUser.getCurrentUser();
            String currentUsername = currentUser.getUsername();
            final String userObjectId = currentUser.getObjectId();
            ParseObject allPosts = new ParseObject("Posts");
            ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
            // Retrieve the object by id
            query.getInBackground(userObjectId, new GetCallback<ParseObject>() {
                public void done(ParseObject userObject, ParseException e) {
                    if (e == null) {
                        final Number posts;
                        if (userObject.getNumber("totalPostsNew") != null) {
                            int posts1 = (int) userObject.getNumber("totalPostsNew");
                            posts = posts1 + 1;
                        }else{
                            posts = 1;
                        }
                        userObject.put("totalPostsNew", posts);
                              /* Number posts = userObject.getNumber("totalPostsNew");
                                int postsInt = Integer.parseInt(String.valueOf(posts));
                                postsInt++;
                                Number postsTo = postsInt;
                               // totalPostsCount++;
                               userObject.put("totalPostsNew", postsTo);*/
                        userObject.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                                } else {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                    }
                }
            });
            allPosts.put("category", postCategory);
            allPosts.put("Username", currentUsername);
            switch (postType) {
                case "thought":
                    ParseObject thoughtPost = new ParseObject("Thought_Post");
                    thoughtPost.put("ThoughtPost", postContent);
                    thoughtPost.put("Username", currentUsername);
                    currentUser.put("test", "test");

                    allPosts.put("content", postContent);
                    allPosts.put("featured", false);
                    allPosts.put("type", postType);
                    //allPosts.put("postColor", "#EC7568");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                    ParseObject predictionPost = new ParseObject("Prediction_Post");
                    predictionPost.put("PredictionPost", postContent);
                    predictionPost.put("Username", currentUsername);
                    allPosts.put("content", postContent);
                    allPosts.put("featured", false);
                    allPosts.put("type", postType);
                    //allPosts.put("postColor", "#55D98D");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                    ParseObject questionPost = new ParseObject("Question_Post");
                    questionPost.put("QuestionPost", postContent);
                    questionPost.put("Username", currentUsername);
                    allPosts.put("content", postContent);
                    allPosts.put("featured", false);
                    allPosts.put("type", postType);
                    allPosts.addAll("bidOptionList", Arrays.asList(bidOptionList));
                    //allPosts.put("postColor", "#60AEE3");
                    allPosts.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
                                Toast.makeText(PostSettingsActivity.this, "success", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(PostSettingsActivity.this);
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
            postIntent.putExtra("postCategory", postCategory);
            startActivity(postIntent);
        }
        return super.onOptionsItemSelected(item);

    }
        @Override
        public void onClick (View v){
            GradientDrawable sDrawable = (GradientDrawable) btnSports.getBackground();
            GradientDrawable bDrawable = (GradientDrawable) btnBusiness.getBackground();
            GradientDrawable uDrawable = (GradientDrawable) btnUS.getBackground();
            GradientDrawable wDrawable = (GradientDrawable) btnWorld.getBackground();
            GradientDrawable pDrawable = (GradientDrawable) btnPolitics.getBackground();
            GradientDrawable scDrawable = (GradientDrawable) btnScience.getBackground();
            GradientDrawable tDrawable = (GradientDrawable) btnTechnology.getBackground();
            GradientDrawable cDrawable = (GradientDrawable) btnAutomobiles.getBackground();
            GradientDrawable eDrawable = (GradientDrawable) btnEconomy.getBackground();
            GradientDrawable edDrawable = (GradientDrawable) btnEducation.getBackground();
            int id = v.getId();
            switch (id) {
                case R.id.btnSports:
              /* sports_counter++;
               if (sports_counter%2 != 0) {
                   sDrawable.setColor(Color.parseColor("#F9D6D2"));
                   btnSports.setImageResource(R.drawable.sports_w);
               }
               else{*/
                    sDrawable.setColor(Color.parseColor("#EC7568"));
                    btnSports.setImageResource(R.drawable.p1);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    postCategory = "Sports";
              /*ParseUser currentUser = ParseUser.getCurrentUser();
              String currentUsername = currentUser.getUsername();
              ParseObject allPosts = new ParseObject("All_Posts");*/


                    // }
                    break;
                case R.id.btnBusiness:
                /*business_counter++;
                if (business_counter%2 != 0) {
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                }else {*/
                    bDrawable.setColor(Color.parseColor("#EB974B"));
                    btnBusiness.setImageResource(R.drawable.p2);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    postCategory = "Business";

                    //}
                    //bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    break;
                case R.id.btnUS:
                /*us_counter++;
                if (us_counter%2 != 0) {
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                }else {*/
                    uDrawable.setColor(Color.parseColor("#F3CF41"));
                    btnUS.setImageResource(R.drawable.p3);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    postCategory = "U.S";
                    //}
                    break;
                case R.id.btnWorld:
                /*world_counter++;
                if (world_counter%2 != 0) {
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                }else {*/
                    wDrawable.setColor(Color.parseColor("#55D98D"));
                    btnWorld.setImageResource(R.drawable.p4);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    postCategory = "World";
                    //}
                    break;
                case R.id.btnPolitics:
               /* politics_counter++;
                if (politics_counter%2 != 0) {
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                }else {*/
                    pDrawable.setColor(Color.parseColor("#28E1BC"));
                    btnPolitics.setImageResource(R.drawable.p5);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    postCategory = "Politics";
                    //}
                    break;
                case R.id.btnScience:
                /*science_counter++;
                if (science_counter%2 != 0) {
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                }else {*/
                    scDrawable.setColor(Color.parseColor("#60AEE3"));
                    btnScience.setImageResource(R.drawable.p6);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    postCategory = "Science";

                    //}
                    break;
                case R.id.btnTechnology:
                /*technology_counter++;
                if (technology_counter%2 != 0) {
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                }else {*/
                    tDrawable.setColor(Color.parseColor("#B17EC7"));
                    btnTechnology.setImageResource(R.drawable.p7);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    postCategory = "Technology";

                    // }
                    break;
                case R.id.btnAutomobiles:
               /* car_counter++;
                if (car_counter%2 != 0) {
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                }else {*/
                    cDrawable.setColor(Color.parseColor("#D85B4E"));
                    btnAutomobiles.setImageResource(R.drawable.p8);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    postCategory = "Automobiles";

                    // }
                    break;
                case R.id.btnEconomy:
               /* economy_counter++;
                if (economy_counter%2 != 0) {
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                }else {*/
                    eDrawable.setColor(Color.parseColor("#FF6B09"));
                    btnEconomy.setImageResource(R.drawable.p9);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    postCategory = "Finance";

                    //}
                    break;
                case R.id.btnEducation:
                /*education_counter++;
                if (education_counter%2 != 0) {
                    edDrawable.setColor(Color.parseColor("#FCE8C7"));
                    btnEducation.setImageResource(R.drawable.education_w);
                }else {*/
                    edDrawable.setColor(Color.parseColor("#F5B343"));
                    btnEducation.setImageResource(R.drawable.p10);
                    sDrawable.setColor(Color.parseColor("#F9D6D2"));
                    btnSports.setImageResource(R.drawable.sports_w);
                    bDrawable.setColor(Color.parseColor("#F9E0C9"));
                    btnBusiness.setImageResource(R.drawable.business_w);
                    uDrawable.setColor(Color.parseColor("#FBF1C6"));
                    btnUS.setImageResource(R.drawable.us_w);
                    wDrawable.setColor(Color.parseColor("#CCF4DD"));
                    btnWorld.setImageResource(R.drawable.world_w);
                    pDrawable.setColor(Color.parseColor("#BEF6EB"));
                    btnPolitics.setImageResource(R.drawable.politics_w);
                    scDrawable.setColor(Color.parseColor("#CFE7F7"));
                    btnScience.setImageResource(R.drawable.science_w);
                    tDrawable.setColor(Color.parseColor("#E8D8EE"));
                    btnTechnology.setImageResource(R.drawable.tech_w);
                    cDrawable.setColor(Color.parseColor("#F3CECA"));
                    btnAutomobiles.setImageResource(R.drawable.cars_w);
                    eDrawable.setColor(Color.parseColor("#FFD3B5"));
                    btnEconomy.setImageResource(R.drawable.economy_w);
                    postCategory = "Education";

                    //}
                    break;
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

