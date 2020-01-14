package com.example.mvpexample.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public class MySharedPreferences {

    private SharedPreferences sharedPreferences;
    private Context context;
    private Editor editor;

    public boolean loggedIn;
    public static final String PREFS_NAME = "preferences";
    public static final String ACCESS_TOKEN = "access_token";

    public MySharedPreferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        loggedIn = !TextUtils.isEmpty(sharedPreferences.getString(ACCESS_TOKEN, null));
    }

    public String getAccessToken(){
        String accessToken = sharedPreferences.getString(ACCESS_TOKEN, "");
        return accessToken;
    }

    public void setAccessToken(String accessToken){
        editor.putString(ACCESS_TOKEN, accessToken);
        editor.apply();
        loggedIn = true;
    }

    public boolean isLoggedIn(){

        return loggedIn;
    }

    public void logOut(){

        loggedIn = false;
        editor.putString(ACCESS_TOKEN, null);
        editor.apply();

    }

}
