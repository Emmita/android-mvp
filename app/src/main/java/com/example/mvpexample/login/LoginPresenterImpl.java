package com.example.mvpexample.login;

import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class LoginPresenterImpl implements LoginContract.Presenter, LoginContract.OnLoginFinishedListener {

    private LoginContract.View view;
    private LoginContract.Interactor interactor;


    public LoginPresenterImpl(LoginContract.View view, MySharedPreferences preferences){
        this.view = view;
        this.interactor = new LoginInteractorImpl(this, preferences);
    }

    @Override
    public void validateCredentials(String username, String password) {

        if (view != null){

            view.showProgressBar();

        }

        interactor.login(username, password, this);

    }

    @Override
    public void isLoggedIn(Boolean loggedIn) {

        if (view != null){

            if (loggedIn) view.navigateToHome();

        }

    }

    @Override
    public void onDestroy() {

        view = null;

    }

    @Override
    public void initCheck() {
        interactor.checkLogged();
    }

    @Override
    public void onUsernameError(String error) {

        if (view != null){

            view.hideProgressBar();
            view.showUsernameError(error);

        }

    }

    @Override
    public void onPasswordError(String error) {

        if (view != null){

            view.hideProgressBar();
            view.showPasswordError(error);

        }

    }

    @Override
    public void onSuccess() {

        if (view != null){

            view.hideProgressBar();
            view.navigateToHome();


        }

    }
}
