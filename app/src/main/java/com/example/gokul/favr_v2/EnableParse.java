package com.example.gokul.favr_v2;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Gokul on 7/5/2015.
 */
public class EnableParse extends Application {
    public static final String APP_KEY = "GjVJtx1d7qDrIJEkx0tZbwA7vu48m9oLpepfZOtH";
    public static final String APP_CLIENT_ID = "O1NyZtcDVkcsaXMZyIv7a0Pyi9zxfJIQMnESaK1f";

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, APP_KEY, APP_CLIENT_ID);


    }
}
