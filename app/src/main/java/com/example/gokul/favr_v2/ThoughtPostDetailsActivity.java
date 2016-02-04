package com.example.gokul.favr_v2;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
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


public class ThoughtPostDetailsActivity extends ActionBarActivity {
    Toolbar mToolbar;
    TextView textPost;
    ListView listThoughtComments;
    TextView textAddComment;
    Button btnAddComment;
    TextView textStakeQuantity;
    Button btnStakeFor;
    Button btnStakeAgainst;
    ImageButton btnMinusStake;
    ImageButton btnAddStake;
    LinearLayout llOne;
    int pointNum = 20;
    protected List<ParseObject> mComments;
    FloatingActionButton fabStakeIt;
    static int height = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thought_post_details);
        llOne = (LinearLayout)this.findViewById(R.id.llone);
        Bundle postBundle = getIntent().getExtras();
        String postContent = (String) postBundle.get("postContent");
        //ParseObject allPosts = new ParseObject("All_Posts");
        final String objectId = (String) postBundle.get("objectId");
        textPost = (TextView)this.findViewById(R.id.textThoughtPostDetails);
        //ImageButton btnAddStake = (ImageButton) this.findViewById(R.id.btnAddStake);
        fabStakeIt = (FloatingActionButton) this.findViewById(R.id.fabStakeIt);
        fabStakeIt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showStakeDialog(objectId);
            }
        });
        textPost.setText(postContent);

       final ArrayList<String> commentsList = new ArrayList<String>();

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listThoughtComments = (ListView) this.findViewById(R.id.listThoughtComments);
        ParseQuery<ParseObject> commentQuery = new ParseQuery<ParseObject>("Posts");
        //query.whereEqualTo("objectId", objectId);
        // query.orderByDescending("createdAt");
        commentQuery.getInBackground(objectId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if (e == null) {
                    //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                    if (parseObject.getList("comments") != null) {
                        List<String> parseCommentsList = parseObject.getList("comments");
                        AddCommentAdapter commentAdapter = new AddCommentAdapter(ThoughtPostDetailsActivity.this, parseCommentsList);
                        listThoughtComments.setAdapter(commentAdapter);
                        //oast.makeText(ThoughtPostDetailsActivity.this, a.get(1).toString(), Toast.LENGTH_LONG).show();

                        parseObject.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                } else {
                                    AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                    }

                } else {
                    Toast.makeText(ThoughtPostDetailsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
        btnAddComment = (Button) this.findViewById(R.id.btnAddComment);
        textAddComment = (TextView) this.findViewById(R.id.textAddComment);
        btnAddComment.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final String commentText = textAddComment.getText().toString();
                textAddComment.setText(null);
                ParseUser currentUser = ParseUser.getCurrentUser();

                //commentsList.add(commentText);
                // Toast.makeText(getActivity(), title + "adsf" , Toast.LENGTH_SHORT).show();
                if (currentUser != null) {

                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                    //query.whereEqualTo("objectId", objectId);
                    // query.orderByDescending("createdAt");
                    query.getInBackground(objectId, new GetCallback<ParseObject>() {
                        @Override
                        public void done(ParseObject parseObject, ParseException e) {
                            if (e == null) {
                                //parseObject.addAllUnique("CommentsArray", Arrays.asList("a", "b"));
                                parseObject.addAll("comments", Arrays.asList(commentText));
                                List<String> parseCommentsList = parseObject.getList("comments");
                                AddCommentAdapter commentAdapter = new AddCommentAdapter(ThoughtPostDetailsActivity.this, parseCommentsList);
                                parseObject.put("totalComments", parseCommentsList.size());
                                listThoughtComments.setAdapter(commentAdapter);
                                //oast.makeText(ThoughtPostDetailsActivity.this, a.get(1).toString(), Toast.LENGTH_LONG).show();

                                parseObject.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        if (e == null) {
                                            //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                        } else {
                                            AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                                Toast.makeText(ThoughtPostDetailsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                  /* ParseQuery<ParseObject> commentQuery = new ParseQuery<ParseObject>("All_Posts");

                    commentQuery.whereEqualTo("objectId", objectId);
                    commentQuery.orderByDescending("createdAt");
                    commentQuery.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> list, ParseException e) {
                            if (e == null) {
                                mComments = list;
                                PostListViewAdapter commentsAdapter = new PostListViewAdapter(ThoughtPostDetailsActivity.this, mComments);
                                listThoughtComments.setAdapter(commentsAdapter);
                            } else {

                            }
                        }
                    });*/

                }

            }
        });
        ViewTreeObserver vto = btnAddComment.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Integer a = llOne.getHeight();
                Integer b = a + 60;
                //Toast.makeText(ThoughtPostDetailsActivity.this, Integer.toString(a) + " " + Integer.toString(b), Toast.LENGTH_LONG).show();
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fabStakeIt.getLayoutParams();
                params.setMargins(0, b, 0, 0);
                fabStakeIt.setLayoutParams(params);
                ViewTreeObserver obs = llOne.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
            }
        });


        //int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, params.height, getResources().getDisplayMetrics());
        //Toast.makeText(ThoughtPostDetailsActivity.this, Integer.toString(height), Toast.LENGTH_LONG).show();

    }


   protected void showStakeDialog (final String newObjectId){
        final Dialog dialog = new Dialog (ThoughtPostDetailsActivity.this);
        //dialog.setTitle("Stake");
        //dialog.setTitle("Stake");
        dialog.setContentView(R.layout.stake_dialog);

       final Integer[] parseStakeQuantity = new Integer[1];
       dialog.show();
       final ParseUser currentUser = ParseUser.getCurrentUser();

       if (currentUser != null){

           ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
           //query.whereEqualTo("objectId", objectId);
           // query.orderByDescending("createdAt");
          /* query.getInBackground(newObjectId, new GetCallback<ParseObject>() {
               @Override
               public void done(ParseObject parseObject, ParseException e) {
                   if (e == null) {

                       parseStakeQuantity[0] = (int) parseObject.getNumber("totalPoints");

                       parseObject.saveInBackground(new SaveCallback() {
                           @Override
                           public void done(ParseException e) {
                               if (e == null) {
                                   //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                               } else {
                                   AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                       Toast.makeText(ThoughtPostDetailsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                   }
               }
           });*/

       }
        textStakeQuantity = (TextView) dialog.findViewById(R.id.quantityText);
        btnStakeAgainst = (Button) dialog.findViewById(R.id.btnStakeAgainst);
        btnStakeFor = (Button) dialog.findViewById(R.id.btnStakeFor);
        btnAddStake = (ImageButton) dialog.findViewById(R.id.btnAddStake);
        btnMinusStake = (ImageButton) dialog.findViewById(R.id.btnMinusStake);
       //final String stakeQuantity = textStakeQuantity.getText().toString();

        final int points[] = new int[0];
       //points[0] = 20;
//       Integer.parseInt(textStakeQuantity.getText().toString());

       btnAddStake.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
               pointNum++;
               textStakeQuantity.setText(Integer.toString(pointNum));
           }
       });

       btnMinusStake.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               pointNum--;
               textStakeQuantity.setText(Integer.toString(pointNum));
           }
       });


       //textStakeQuantity.setText(Integer.toString(points[0]));
       final String userObjectId = currentUser.getObjectId();


       btnStakeAgainst.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               final String stakeQuantity = textStakeQuantity.getText().toString();

               if (currentUser != null){

                   ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                   //query.whereEqualTo("objectId", objectId);
                   // query.orderByDescending("createdAt");
                   query.getInBackground(newObjectId, new GetCallback<ParseObject>() {
                       @Override
                       public void done(ParseObject parseObject, ParseException e) {
                           if (e == null) {
                               /*int toParseStakeQuantityInteger = intStakeQuantity + parseStakeQuantityInteger;
                               String toNewParseStakeQuantityString = Integer.toString(toParseStakeQuantityInteger);*/
                               final int intParseStakeQuantity;
                               if (parseObject.getNumber("totalPoints") != null){
                                   intParseStakeQuantity = (int) parseObject.getNumber("totalPoints");
                               }else{
                                   intParseStakeQuantity = 0;
                               }
                               final int intLocalStakeQuantity = Integer.parseInt(stakeQuantity);
                               final int intFinalStakeQuantity = intParseStakeQuantity - intLocalStakeQuantity;
                               //String stringFinalStakeQuantity = Integer.toString(intFinalStakeQuantity);
                               parseObject.put("totalPoints", intFinalStakeQuantity);

                               ParseQuery<ParseObject> query2 = ParseQuery.getQuery("_User");
                               // Retrieve the object by id
                               query2.getInBackground(userObjectId, new GetCallback<ParseObject>() {
                                   public void done(ParseObject userObject, ParseException e) {
                                       if (e == null) {
                                           // Now let's update it with some new data. In this case, only cheatMode and score
                                           // will get sent to the Parse Cloud. playerName hasn't changed.
                                           final Number points;
                                          if (userObject.get("totalPointsNew") != null) {
                                              // Number points = userObject.getNumber("totalPointsNew");
                                              int parsePoints = (int) userObject.getNumber("totalPointsNew");
                                              points = parsePoints + intLocalStakeQuantity;
                                           } else {
                                              points = intLocalStakeQuantity;
                                           }
                                           userObject.put("totalPointsNew", points);
                                           userObject.saveInBackground(new SaveCallback() {
                                               @Override
                                               public void done(ParseException e) {
                                                   if (e == null) {
                                                       Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                                   } else {
                                                       AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                              // Toast.makeText(ThoughtPostDetailsActivity.this, Integer.toString(points[0]), Toast.LENGTH_LONG).show();
                               parseObject.saveInBackground(new SaveCallback() {
                                   @Override
                                   public void done(ParseException e) {
                                       if (e == null) {
                                           //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                       } else {
                                           AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                               Toast.makeText(ThoughtPostDetailsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                           }
                       }
                   });

               }
           }
       });
       btnStakeFor.setOnClickListener(new OnClickListener() {
           ParseUser currentUser = ParseUser.getCurrentUser();
           //final int intStakeQuantity = Integer.parseInt(stakeQuantity);
          // String al = parseStakeQuantity[0];

           //final int parseStakeQuantityInteger = Integer.parseInt(al);

           @Override
           public void onClick(View v) {
               final String stakeQuantity = textStakeQuantity.getText().toString();

               if (currentUser != null){

                   ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Posts");
                   //query.whereEqualTo("objectId", objectId);
                   // query.orderByDescending("createdAt");
                   query.getInBackground(newObjectId, new GetCallback<ParseObject>() {
                       @Override
                       public void done(ParseObject parseObject, ParseException e) {
                           if (e == null) {
                               /*int toParseStakeQuantityInteger = intStakeQuantity + parseStakeQuantityInteger;
                               String toNewParseStakeQuantityString = Integer.toString(toParseStakeQuantityInteger);*/
                               final int intParseStakeQuantity;
                               if (parseObject.getNumber("totalPoints") != null){
                                   intParseStakeQuantity = (int) parseObject.getNumber("totalPoints");
                               }else{
                                   intParseStakeQuantity = 0;
                               }
                               final int intLocalStakeQuantity = Integer.parseInt(stakeQuantity);
                               int intFinalStakeQuantity = intParseStakeQuantity + intLocalStakeQuantity;
                               //String stringFinalStakeQuantity = Integer.toString(intFinalStakeQuantity);
                               parseObject.put("totalPoints", intFinalStakeQuantity);
                               ParseQuery<ParseObject> query2 = ParseQuery.getQuery("_User");
                               // Retrieve the object by id
                               query2.getInBackground(userObjectId, new GetCallback<ParseObject>() {
                                   public void done(ParseObject userObject, ParseException e) {
                                       if (e == null) {
                                           // Now let's update it with some new data. In this case, only cheatMode and score
                                           // will get sent to the Parse Cloud. playerName hasn't changed.
                                           final Number points;
                                           if (userObject.get("totalPointsNew") != null) {
                                               // Number points = userObject.getNumber("totalPointsNew");
                                               int parsePoints = (int) userObject.getNumber("totalPointsNew");
                                               points = parsePoints + intLocalStakeQuantity;
                                           } else {
                                               points = intLocalStakeQuantity;
                                           }
                                           userObject.put("totalPointsNew", points);
                                           userObject.saveInBackground(new SaveCallback() {
                                               @Override
                                               public void done(ParseException e) {
                                                   if (e == null) {
                                                       Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                                   } else {
                                                       AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                              // Toast.makeText(ThoughtPostDetailsActivity.this, Integer.toString(points[0]), Toast.LENGTH_LONG).show();
                               parseObject.saveInBackground(new SaveCallback() {
                                   @Override
                                   public void done(ParseException e) {
                                       if (e == null) {
                                           //Toast.makeText(ThoughtPostDetailsActivity.this, "success", Toast.LENGTH_LONG).show();
                                       } else {
                                           AlertDialog.Builder dialog = new AlertDialog.Builder(ThoughtPostDetailsActivity.this);
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
                               Toast.makeText(ThoughtPostDetailsActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                           }
                       }
                   });

               }
           }
       });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_thought_post_details, menu);
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
