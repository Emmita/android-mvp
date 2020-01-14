package com.example.mvpexample.login;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class LoginInteractorImpl implements LoginContract.Interactor {

    private LoginContract.Presenter presenter;
    private MySharedPreferences preferences;

    public LoginInteractorImpl(LoginContract.Presenter presenter ,MySharedPreferences preferences){
        this.presenter = presenter;
        this.preferences = preferences;

    }

    @Override
    public void login(String username, String password, LoginContract.OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                boolean error = false;

                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError("User is empty");
                    error = true;
                }

                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError("Password is empty");
                    error = true;
                }

                if (!error){
                    listener.onSuccess();
                    preferences.setAccessToken("123456789");
                }

            }
        }, 2000);

    }

    @Override
    public void checkLogged() {

        if (preferences.isLoggedIn()){
            presenter.isLoggedIn(true);
        }

    }

}
