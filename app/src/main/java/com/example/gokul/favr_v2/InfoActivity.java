package com.example.gokul.favr_v2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;


public class InfoActivity extends ActionBarActivity implements View.OnClickListener {
    Toolbar mToolbar;
    private Spinner spinnerMonth;
    private Spinner spinnerDay;
    private Spinner spinnerYear;
    private TextView textMale;
    private EditText editBday;
    private Button btnContinue;
    private TextView textFemale;
    private Button btnBirthday;
    private ImageButton imgProfile;
    int year_x, month_x, day_x;
    static final int DIALOG_ID=0;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        //If the data is not equal to null, or if there is data being sent, then execute the code in the if statement
        if (resultCode == RESULT_OK && data != null){
            //We will use something called a Uri to store the data from the Intent, as shown below
            Toast.makeText(InfoActivity.this, "started", Toast.LENGTH_LONG).show();

            Uri selectedImage = data.getData();
            try {
                //We will use something called a Bitmap to store the image selected by the user
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                //We will create a byte array to store the image data in a format that can be uploadable to Parse
                byte[] byteArray = stream.toByteArray();
                //We will store this byteArray that holds the image data to a ParseFile object under the name "image.png"
                final ParseFile file = new ParseFile("profileImage.png", byteArray);

                ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");

                query.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
                    public void done(ParseObject userObject, ParseException e) {
                        if (e == null) {
                            userObject.put("profilePicture", file);
                            userObject.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e == null) {
                                        Toast.makeText(InfoActivity.this, "success", Toast.LENGTH_LONG).show();
                                    } else {
                                        AlertDialog.Builder dialog = new AlertDialog.Builder(InfoActivity.this);
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
                        }else{
                            AlertDialog.Builder dialog = new AlertDialog.Builder(InfoActivity.this);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Calendar calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);

        imgProfile = (ImageButton) this.findViewById(R.id.imageProfile);
        imgProfile.setOnClickListener(this);
        textFemale = (TextView) this.findViewById(R.id.textFemale);
        textMale = (TextView) this.findViewById(R.id.textMale);
        btnContinue = (Button) this.findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcomeActivity = new Intent(InfoActivity.this, WelcomeActivity.class);
                startActivity(welcomeActivity);
            }
        });
        textMale.setTextColor(Color.parseColor("#9C27B0"));

        textFemale.setOnClickListener(this);
        textMale.setOnClickListener(this);
        final String spinnerMonthArray[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        final String spinnerDayArrayFeb[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};

        final String spinnerDayArrayHigh[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        final String spinnerDayArrayLow[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};

        editBday = (EditText) this.findViewById(R.id.editBday);

        showDialogOnButtonClick();
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID){
            return new DatePickerDialog(InfoActivity.this, dpListener, year_x, month_x, day_x);
        }else {
            return null;
        }
    }

    private DatePickerDialog.OnDateSetListener dpListener = new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear  + 1;
            day_x = dayOfMonth;

            editBday.setText(month_x + "/" + day_x + "/" + year_x);
        }
    };
    private View.OnClickListener buttonClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            showDialog(DIALOG_ID);
        }
    };

    public void showDialogOnButtonClick(){
        btnBirthday = (Button) this.findViewById(R.id.btnBday);
        btnBirthday.setOnClickListener(buttonClickListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
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
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.textFemale:
                textFemale.setTextColor(Color.parseColor("#9C27B0"));
                textMale.setTextColor(-1979711488);
                break;
            case R.id.textMale:
                textMale.setTextColor(Color.parseColor("#9C27B0"));
                textFemale.setTextColor(-1979711488);
                break;
            case R.id.imageProfile:
                Intent sendImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(sendImageIntent, 1);
                Toast.makeText(InfoActivity.this, "not started", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
