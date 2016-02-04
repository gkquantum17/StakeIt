package com.example.gokul.favr_v2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.parse.ParseObject;


public class CategoryActivity extends ActionBarActivity {
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Featured","General"};
    int Numboftabs = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //if (getIntent().getExtras() != null)

        Bundle bundle = getIntent().getExtras();
        String position = (String) bundle.get("Position");

        if (bundle.get("Position") != null) {
            String position2 = (String) bundle.get("Position");

            switch (position2) {
                case "0":
                    setTitle("Sports");
                    break;
                case "1":
                    setTitle("Business");
                    break;
                case "2":
                    setTitle("U.S.");
                    break;
                case "3":
                    setTitle("World");
                    break;
                case "4":
                    setTitle("Politics");
                    break;
                case "5":
                    setTitle("Science");
                    break;
                case "6":
                    setTitle("Technology");
                    break;
                case "7":
                    setTitle("Automobiles");
                    break;
                case "8":
                    setTitle("Economy");
                    break;
                case "9":
                    setTitle("Education");
                    break;
                default:
                    break;
            }
        }else {
            String postCategory = (String) bundle.get("postCategory");
            switch (postCategory) {
                case "Sports":
                    setTitle("Sports");
                    break;
                case "Business":
                    setTitle("Business");
                    break;
                case "U.S":
                    setTitle("U.S.");
                    break;
                case "World":
                    setTitle("World");
                    break;
                case "Politics":
                    setTitle("Politics");
                    break;
                case "Science":
                    setTitle("Science");
                    break;
                case "Technology":
                    setTitle("Technology");
                    break;
                case "Automobiles":
                    setTitle("Automobiles");
                    break;
                case "Economy":
                    setTitle("Economy");
                    break;
                case "Education":
                    setTitle("Education");
                    break;
                default:
                    break;
            }
        }
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Make Post");
        actionC.setIcon(R.drawable.plu);
        actionC.setColorNormal(Color.parseColor("#FCFCFC"));
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent makePostActivity = new Intent(CategoryActivity.this, MakePostActivity.class);
                startActivity(makePostActivity);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(actionC);

        final FloatingActionButton actionB = (FloatingActionButton) findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(CategoryActivity.this, "Adsf", Toast.LENGTH_LONG).show();
            }
        });

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
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
