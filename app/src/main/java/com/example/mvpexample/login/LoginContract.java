package com.example.mvpexample.login;

import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public interface LoginContract {


    interface View{

        void showProgressBar();
        void hideProgressBar();
        void showUsernameError(String error);
        void showPasswordError(String error);
        void navigateToHome();

    }

    interface Presenter{

        void validateCredentials(String username, String password);
        void isLoggedIn(Boolean loggedIn);
        void onDestroy();
        void initCheck();

    }

    interface Interactor{

        void login(String username, String password, OnLoginFinishedListener listener);
        void checkLogged();

    }

    interface OnLoginFinishedListener{

        void onUsernameError(String error);
        void onPasswordError(String error);
        void onSuccess();

    }

}
