package com.example.gokul.favr_v2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import util.ProgressGenerator;


public class RegisterActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {
    Toolbar mToolbar;
    private EditText editEmail;
    private EditText editUsername;
    private EditText editPassword;
    private EditText editFirstName;
    private EditText editLastName;
    private ProgressGenerator progressGenerator;
    private ActionProcessButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        editEmail = (EditText)this.findViewById(R.id.registerEmail);
        editUsername = (EditText)this.findViewById(R.id.registerUsername);
        editPassword = (EditText)this.findViewById(R.id.registerPassword);
        editFirstName = (EditText)this.findViewById(R.id.firstName);
        editLastName = (EditText)this.findViewById(R.id.lastName);
        btnRegister = (ActionProcessButton)this.findViewById(R.id.btnFinalRegister);
        progressGenerator = new ProgressGenerator(this);

        btnRegister.setMode(ActionProcessButton.Mode.PROGRESS);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createAccount(){
       final String firstName = editFirstName.getText().toString();
        final String lastName = editLastName.getText().toString();
        final String email = editEmail.getText().toString();
        final String username =  editUsername.getText().toString();
        final String password = editPassword.getText().toString();

        if (email.equals("") || username.equals("") || password.equals("") || firstName.equals("")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
            dialog.setTitle("Empty Fields");
            dialog.setMessage("Please complete the form");
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }else{
            ParseUser user = new ParseUser();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);

            user.put("First_Name", firstName);
            user.put("Last_Name", lastName);
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null){
                        progressGenerator.start(btnRegister);
                        editFirstName.setEnabled(false);
                        editLastName.setEnabled(false);
                        btnRegister.setEnabled(false);
                        editEmail.setEnabled(false);
                        editUsername.setEnabled(false);
                        editPassword.setEnabled(false);

                        //log in user
                        logUserIn(username, password);
                    }

                }
            });
        }
    }

    private void logUserIn(String username, String password) {
        if (!username.equals("") || !password.equals("")){
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser parseUser, ParseException e) {
                    if (e == null) {
                        Log.v("USER LOGGED IN IS: ", parseUser.getUsername());
                    } else {

                    }
                }
            });
        }else{

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

    @Override
    public void onComplete() {
        Intent infoActivity = new Intent(RegisterActivity.this, InfoActivity.class);
        startActivity(infoActivity);
    }
}
