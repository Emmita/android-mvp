package com.example.mvpexample.alCuadrado;

import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class AlCuadradoInteractorImpl implements AlCuadradoContract.Interactor {

    private AlCuadradoContract.Presenter presenter;
    private MySharedPreferences preferences;
    private double result;

    public AlCuadradoInteractorImpl(AlCuadradoContract.Presenter presenter, MySharedPreferences preferences){
        this.presenter = presenter;
        this.preferences = preferences;
    }

    @Override
    public void doSquare(String number) {

        if (!number.isEmpty()){
            result = Double.valueOf(number) * Double.valueOf(number);
            presenter.showResult(String.valueOf(result));
        }else {
            presenter.showError("ingresa numero valido");
        }

    }

    @Override
    public void logOut() {

        preferences.logOut();

    }
}
