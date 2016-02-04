package com.example.gokul.favr_v2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class UserProfileActivity extends ActionBarActivity {
    Toolbar mToolbar;
    TextView textName;
    TextView textUsername;
    TextView textPostsTotal;
    TextView textFlagsTotal;
    TextView textBetsTotal;
    TextView textPointsTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textName = (TextView) this.findViewById(R.id.textUserProfileName);
        textUsername = (TextView) this.findViewById(R.id.textUserProfileUsername);
        textPostsTotal = (TextView) this.findViewById(R.id.textTotalPosts);
        textFlagsTotal = (TextView) this.findViewById(R.id.textTotalFlags);
        textBetsTotal = (TextView) this.findViewById(R.id.textTotalBets);
        textPointsTotal = (TextView) this.findViewById(R.id.textTotalPoints);


        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null){
            if (currentUser.getString("First_Name") != null && currentUser.getString("Last_Name") != null){
                String firstName = currentUser.getString("First_Name");
                String lastName = currentUser.getString("Last_Name");
                String fullName = firstName + " " + lastName;
                textName.setText(fullName);
            }
            if (currentUser.getNumber("totalPostsNew") != null) {
                int totalPosts = (int) currentUser.getNumber("totalPostsNew");
                String totalPostsStr = Integer.toString(totalPosts);
                final String totalPostsOrPost;
                if (totalPosts == 1){
                    totalPostsOrPost = "total post";
                }else{
                    totalPostsOrPost = "total posts";
                }
                textPostsTotal.setText(totalPostsStr + "\n" + totalPostsOrPost);
            }
            if (currentUser.getNumber("totalPointsNew") != null){
                Number totalPoints = currentUser.getNumber("totalPointsNew");
                String totalPointsStr = totalPoints.toString();
                textPointsTotal.setText(totalPointsStr + "\n" + "points used");
            }
        }


        String currentUsername = currentUser.getUsername();
        textUsername.setText(currentUsername);
        //String name = currentUser.getString("First_Name");
        //Toast.makeText(UserProfileActivity.this, currentUsername + " " + name , Toast.LENGTH_LONG).show();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
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
