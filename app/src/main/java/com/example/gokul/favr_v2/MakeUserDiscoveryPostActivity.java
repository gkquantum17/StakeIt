package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MakeUserDiscoveryPostActivity extends ActionBarActivity {

    Toolbar mToolbar;
    Button btnThought;
    Button btnPrediction;
    Button btnQuestion;
    EditText editPost;
    LinearLayout linearLayout;
    EditText editOptionInput;
    Button testbutton;
    private ArrayAdapter<String> adapter2;
    String postType = "thought";
    String thoughtPost;
    final ArrayList<String> optionList = new ArrayList<String>();

    String predictionPost;
    String questionPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_user_discovery_post);
        linearLayout = (LinearLayout) this.findViewById(R.id.ll2Disc);
        linearLayout.setVisibility(View.INVISIBLE);
        final ListView listView = (ListView) this.findViewById(R.id.addDiscOptionListView);


        final ArrayList<Integer> deleteList = new ArrayList<Integer>();
        final ArrayList<Integer> editList = new ArrayList<Integer>();

        final AddDiscBidOptionListAdapter adapter = new AddDiscBidOptionListAdapter(this, deleteList, editList, optionList);
        listView.setAdapter(adapter);
        ImageButton optionAddButton = (ImageButton) this.findViewById(R.id.btnDisc);
        editOptionInput = (EditText) this.findViewById(R.id.editDiscOptionInput);
        optionAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                justifyListViewHeightBasedOnChildren(listView);

                setListViewHeightBasedOnChildren(listView);

                String newOption;
                newOption = editOptionInput.getText().toString();
                optionList.add(newOption);
                deleteList.add(R.drawable.delete_32);
                editList.add(R.drawable.eidt_32);
                adapter.notifyDataSetChanged();
            }
        });
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnThought = (Button) this.findViewById(R.id.btnDiscThought);
        btnPrediction = (Button) this.findViewById(R.id.btnDiscPrediction);
        btnQuestion = (Button) this.findViewById(R.id.btnDiscQuestion);

        editPost = (EditText) this.findViewById(R.id.tvDisc);

        btnThought.setBackgroundResource(R.drawable.thought_button);
        final GradientDrawable tdrawable = (GradientDrawable) btnThought.getBackground();

        btnPrediction.setBackgroundResource(R.drawable.prediction_button);
        final GradientDrawable pDrawable = (GradientDrawable) btnPrediction.getBackground();

        btnQuestion.setBackgroundResource(R.drawable.question_button);
        final GradientDrawable qDrawable = (GradientDrawable) btnQuestion.getBackground();

        tdrawable.setColor(Color.parseColor("#EC7568"));
        btnThought.setTextColor(Color.WHITE);
        pDrawable.setColor(Color.WHITE);
        btnPrediction.setTextColor(Color.parseColor("#55D98D"));
        qDrawable.setColor(Color.WHITE);
        btnQuestion.setTextColor(Color.parseColor("#60AEE3"));


        btnThought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
                tdrawable.setColor(Color.parseColor("#EC7568"));
                btnThought.setTextColor(Color.WHITE);
                pDrawable.setColor(Color.WHITE);
                btnPrediction.setTextColor(Color.parseColor("#55D98D"));
                qDrawable.setColor(Color.WHITE);
                btnQuestion.setTextColor(Color.parseColor("#60AEE3"));
                postType = "thought";
            }
        });
        btnPrediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
                pDrawable.setColor(Color.parseColor("#55D98D"));
                btnPrediction.setTextColor(Color.WHITE);
                tdrawable.setColor(Color.WHITE);
                btnThought.setTextColor(Color.parseColor("#EC7568"));
                qDrawable.setColor(Color.WHITE);
                btnQuestion.setTextColor(Color.parseColor("#60AEE3"));
                postType = "prediction";
            }
        });
        btnQuestion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                listView.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);
                qDrawable.setColor(Color.parseColor("#60AEE3"));
                btnQuestion.setTextColor(Color.WHITE);
                tdrawable.setColor(Color.WHITE);
                btnThought.setTextColor(Color.parseColor("#EC7568"));
                pDrawable.setColor(Color.WHITE);
                btnPrediction.setTextColor(Color.parseColor("#55D98D"));
                postType = "question";
            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_make_post, menu);
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
        if (id == R.id.toSettings){
            Bundle bundle = getIntent().getExtras();
            String title = bundle.getString("title");
            String panelContent = bundle.getString("panelContent");
            String panelHeadline = bundle.getString("headline");
            Intent postDiscSettingsIntent;
            postDiscSettingsIntent = new Intent(MakeUserDiscoveryPostActivity.this, PostDiscSettingsActivity.class);
            // ParseUser currentUser = ParseUser.getCurrentUser();
            //  String currentUsername = currentUser.getUsername();
            String newPost = editPost.getText().toString();
           /* switch (postType){
                case "thought":
                    thoughtPost = editPost.getText().toString();
                    break;
                case "prediction":
                    predictionPost = editPost.getText().toString();
                    postSettingsIntent.putExtra("post", predictionPost);
                    break;
                case "question":
                    questionPost = editPost.getText().toString();
                    postSettingsIntent.putExtra("post", questionPost);
                    break;
                default:
                    break;
            }*/
            postDiscSettingsIntent.putExtra("post", newPost);
            postDiscSettingsIntent.putExtra("panelContent", panelContent);
            postDiscSettingsIntent.putExtra("postType", postType);
            postDiscSettingsIntent.putExtra("title", title);
            postDiscSettingsIntent.putExtra("headline", panelHeadline);
            postDiscSettingsIntent.putStringArrayListExtra("bidOptionList", optionList);

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
            startActivity(postDiscSettingsIntent);

        }
        return super.onOptionsItemSelected(item);
    }

}
