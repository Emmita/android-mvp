package com.example.mvpexample.alCuadrado;

import com.example.mvpexample.sharedPreferences.MySharedPreferences;

public class AlCuadradoPresenterImpl implements AlCuadradoContract.Presenter {

    private AlCuadradoContract.View view;
    private AlCuadradoContract.Interactor interactor;

    AlCuadradoPresenterImpl(AlCuadradoContract.View view, MySharedPreferences preferences){
        this.view = view;
        interactor = new AlCuadradoInteractorImpl(this, preferences);
    }

    @Override
    public void showResult(String result) {

        if (view != null){

            view.showResult(result);

        }

    }

    @Override
    public void showError(String error) {

        if (view != null){

            view.showError(error);

        }

    }

    @Override
    public void doSquare(String number) {

        if (view != null){

            interactor.doSquare(number);

        }

    }

    @Override
    public void logOut() {

        if (view != null){
            interactor.logOut();
        }

    }
}
