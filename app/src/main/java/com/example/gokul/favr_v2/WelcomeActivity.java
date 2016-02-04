package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager pager;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.fabCreatePost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent makePostIntent = new Intent(WelcomeActivity.this, MakePostActivity.class);
                startActivity(makePostIntent);
            }
        });

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header_file)
                .addProfiles(
                        new ProfileDrawerItem().withName("Gokul Kumarresen").withEmail("gokulk@live.com").withIcon(getResources().getDrawable(R.drawable.stakeit_pic))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        PrimaryDrawerItem itemProfile = new PrimaryDrawerItem().withName("My Profile").withIcon(R.drawable.my_profile).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                Intent myProfileIntent = new Intent(WelcomeActivity.this, UserProfileActivity.class);
                startActivity(myProfileIntent);
                return false;
            }
        });
        PrimaryDrawerItem itemStakes = new PrimaryDrawerItem().withName("My Stakes").withIcon(R.drawable.my_stakes);
        PrimaryDrawerItem itemPosts = new PrimaryDrawerItem().withName("My Posts").withIcon(R.drawable.my_posts);
        PrimaryDrawerItem itemHelp = new PrimaryDrawerItem().withName("Help").withIcon(R.drawable.help);
        PrimaryDrawerItem itemSettings = new PrimaryDrawerItem().withName("Settings").withIcon(R.drawable.settings);

        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        itemProfile,
                        new DividerDrawerItem(),
                        itemStakes,
                        new DividerDrawerItem(),
                        itemPosts,
                        new DividerDrawerItem(),
                        itemHelp,
                        new DividerDrawerItem(),
                        itemSettings,
                        new DividerDrawerItem()
                )
                .build();

        ArrayList<String> textList = new ArrayList<String>();
        textList.add("Sports");
        textList.add("Business");
        textList.add("U.S.");
        textList.add("World");
        textList.add("Politics");
        textList.add("Science");
        textList.add("Technology");
        textList.add("Automobiles");
        textList.add("Economy");
        textList.add("Education");

        ArrayList<String> colorList = new ArrayList<String>();
        colorList.add(String.valueOf(Color.parseColor("#EC7568")));
        colorList.add(String.valueOf(Color.parseColor("#EB974B")));
        colorList.add(String.valueOf(Color.parseColor("#F3CF41")));
        colorList.add(String.valueOf(Color.parseColor("#55D98D")));
        colorList.add(String.valueOf(Color.parseColor("#28E1BC")));
        colorList.add(String.valueOf(Color.parseColor("#60AEE3")));
        colorList.add(String.valueOf(Color.parseColor("#B17EC7")));
        colorList.add(String.valueOf(Color.parseColor("#D85B4E")));
        colorList.add(String.valueOf(Color.parseColor("#FF6B09")));
        colorList.add(String.valueOf(Color.parseColor("#F5B343")));


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        gridLayoutManager = new GridLayoutManager(WelcomeActivity.this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new RecycleImageAdapter(WelcomeActivity.this, textList, colorList));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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
